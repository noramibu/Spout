package spout.common.protocol;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.Nullable;
import spout.common.branding.SpoutNamespace;
import java.nio.charset.StandardCharsets;

public final class ClientModCustomContentPacketPayload implements CustomPacketPayload {

    private static final Identifier PACKET_ID = Identifier.fromNamespaceAndPath(SpoutNamespace.SPOUT, "custom_content");
    public static final CustomPacketPayload.Type<ClientModCustomContentPacketPayload> TYPE = new CustomPacketPayload.Type<>(PACKET_ID);
    public static final StreamCodec<FriendlyByteBuf, ClientModCustomContentPacketPayload> STREAM_CODEC = CustomPacketPayload.codec(ClientModCustomContentPacketPayload::write, ClientModCustomContentPacketPayload::new);
    public static final CustomPacketPayload.TypeAndCodec<FriendlyByteBuf, ?> TYPE_AND_CODEC = new CustomPacketPayload.TypeAndCodec<>(TYPE, ClientModCustomContentPacketPayload.STREAM_CODEC);

    private static final Gson GSON = new Gson();

    @Override
    public CustomPacketPayload.Type<ClientModCustomContentPacketPayload> type() {
        return TYPE;
    }

    public final Element[] elements;

    public ClientModCustomContentPacketPayload(Element[] elements) {
        this.elements = elements;
    }

    public ClientModCustomContentPacketPayload(FriendlyByteBuf buffer) {
        this.elements = new Element[buffer.readVarInt()];
        for (int i = 0; i < this.elements.length; i++) {
            this.elements[i] = new Element(buffer);
        }
    }

    private void write(FriendlyByteBuf buffer) {
        buffer.writeVarInt(this.elements.length);
        for (Element element : this.elements) {
            element.write(buffer);
        }
    }

    public static class Element {

        public static final Element END = new Element(Type.END);

        /**
         * The {@link Type} of this payload element.
         */
        public final Type type;

        /**
         * The {@link Identifier}, {@linkplain Identifier#toShortString() encoded} as a string,
         * then converted to {@link StandardCharsets#UTF_8} bytes.
         * or null if the current {@link #type} is {@link Type#END}.
         */
        public final byte @Nullable [] identifier;

        /**
         * The content, {@linkplain Gson#toJson encoded} as a string,
         * then converted to {@link StandardCharsets#UTF_8} bytes.
         * or null if the current {@link #type} is {@link Type#END}.
         */
        public final byte @Nullable [] content;

        public Element(Type type, Identifier identifier, JsonElement content) {
            this(type, identifier.toShortString(), GSON.toJson(content));
        }

        public Element(Type type, String identifier, String content) {
            this(type, identifier.getBytes(StandardCharsets.UTF_8), content.getBytes(StandardCharsets.UTF_8));
        }

        public Element(Type type, byte[] identifier, byte[] content) {
            this.type = type;
            this.identifier = identifier;
            this.content = content;
        }

        private Element(Type type) {
            this.type = type;
            this.identifier = null;
            this.content = null;
        }

        public Element(FriendlyByteBuf buffer) {
            // Read the type
            this.type = Type.VALUES[buffer.readByte()];
            // Read the identifier and content
            if (this.type == Type.END) {
                this.identifier = null;
                this.content = null;
            } else {
                this.identifier = buffer.readByteArray();
                this.content = buffer.readByteArray();
            }
        }

        private void write(FriendlyByteBuf buffer) {
            // Write the type
            buffer.writeByte(this.type.ordinal());
            // Write the identifier and content
            if (this.type != Type.END) {
                buffer.writeByteArray(this.identifier);
                buffer.writeByteArray(this.content);
            }
        }

        public String getIdentifierAsString() {
            return new String(this.identifier, StandardCharsets.UTF_8);
        }

        public Identifier getIdentifier() {
            return Identifier.parse(this.getIdentifierAsString());
        }

        public String getContentAsString() {
            return new String(this.content, StandardCharsets.UTF_8);
        }

        public JsonElement getContentAsJsonElement() {
            return GSON.fromJson(this.getContentAsString(), JsonElement.class);
        }

        /**
         * The content type for an element.
         */
        public enum Type {

            /**
             * A special type indicating the end of the custom content.
             */
            END,
            /**
             * A custom block.
             */
            BLOCK,
            /**
             * A custom item.
             */
            ITEM;

            private static final Type[] VALUES = values();

        }

    }

}
