package spout.common.moredatadriven.clientmodprotocol;

import com.mojang.serialization.JsonOps;
import it.unimi.dsi.fastutil.Pair;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.Nullable;
import spout.client.fabric.clientview.ClientModState;
import spout.client.fabric.clientview.SpoutProtocol;
import spout.client.fabric.moredatadriven.TemporaryRegistryModifiers;
import spout.common.moredatadriven.minecraft.block.ContextAwareBlockPropertiesDecoding;
import spout.common.moredatadriven.minecraft.block.SpoutNonBuiltInBlock;
import spout.common.moredatadriven.minecraft.item.ContextAwareItemPropertiesDecoding;
import spout.common.moredatadriven.minecraft.item.SpoutNonBuiltInItem;
import spout.common.protocol.ClientModCustomContent;
import spout.common.protocol.ClientModCustomContentPacketPayload;
import spout.common.util.minecraft.resources.KeyedValue;
import java.util.function.Supplier;

/**
 * Collects all custom content received.
 */
public final class ClientModCustomContentReceiving {

    private ClientModCustomContentReceiving() {
        throw new UnsupportedOperationException();
    }

    /**
     * The current received content, or null if not currently receiving.
     */
    private static volatile @Nullable ClientModCustomContent receivedContent;

    public static void handlePacket(ClientModCustomContentPacketPayload payload) {
        while (SpoutProtocol.getState() != ClientModState.RECEIVED_CUSTOM_CONTENT && !SpoutProtocol.tryChangeState(ClientModState.CLIENT_MOD_DETECTED, ClientModState.RECEIVED_CUSTOM_CONTENT)) {
            Thread.onSpinWait();
        }
        if (receivedContent == null) {
            receivedContent = ClientModCustomContent.createEmpty();
        }
        for (ClientModCustomContentPacketPayload.Element element : payload.elements) {
            switch (element.type) {
                case BLOCK ->
                    receivedContent.getBlocks().add(KeyedValue.of(element.getIdentifier(), SpoutNonBuiltInBlock.CODEC.decode(JsonOps.INSTANCE, element.getContentAsJsonElement()).getOrThrow().getFirst()));
                case ITEM ->
                    receivedContent.getItems().add(KeyedValue.of(element.getIdentifier(), SpoutNonBuiltInItem.CODEC.decoder().decode(JsonOps.INSTANCE, element.getContentAsJsonElement()).getOrThrow().getFirst()));
                case END -> {
                    // Add the received content
                    TemporaryRegistryModifiers.prepareToAddCustomContent();
                    TemporaryRegistryModifiers.addCustomContent(
                        () -> receivedContent.getBlocks().stream().map(keyedValue -> {
                            ResourceKey<Block> key = ResourceKey.create(BuiltInRegistries.BLOCK.key(), keyedValue.identifier());
                            return Pair.of(key, (Supplier<Block>) () -> {
                                SpoutNonBuiltInBlock received = keyedValue.value();
                                ContextAwareBlockPropertiesDecoding.setKey(key);
                                received.initializeValueFromInput(true);
                                ContextAwareItemPropertiesDecoding.clearKey();
                                return received.getValue();
                            });
                        }).toList(),
                        () -> receivedContent.getItems().stream().map(keyedValue -> {
                            ResourceKey<Item> key = ResourceKey.create(BuiltInRegistries.ITEM.key(), keyedValue.identifier());
                            return Pair.of(key, (Supplier<Item>) () -> {
                                SpoutNonBuiltInItem received = keyedValue.value();
                                ContextAwareItemPropertiesDecoding.setKey(key);
                                received.initializeValueFromInput(true);
                                ContextAwareItemPropertiesDecoding.clearKey();
                                return received.getValue();
                            });
                        }).toList()
                    );
                    SpoutProtocol.changeState(ClientModState.RECEIVED_CUSTOM_CONTENT, ClientModState.ADDED_CUSTOM_CONTENT);
                    receivedContent = null;
                }
            }
        }
    }

}
