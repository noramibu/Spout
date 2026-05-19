package spout.common.moredatadriven.minecraft.item;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import spout.common.moredatadriven.minecraft.common.subtypes.SubtypeCodecs;
import spout.common.util.mojang.codec.CodecUtil;
import java.util.Optional;

/**
 * Implements a codec for {@link Item.Properties}.
 */
public final class ItemPropertiesCodec {

    private ItemPropertiesCodec() {
        throw new UnsupportedOperationException();
    }

    private static Item.Properties constructItemProperties(DataComponentMap components, FeatureFlagSet requiredFeatures, Optional<Identifier> id) {
        Item.Properties properties = new Item.Properties();
        ItemPropertiesSerializationAccessor accessor = (ItemPropertiesSerializationAccessor) properties;
        ItemPropertiesSerializationDecorator decorator = (ItemPropertiesSerializationDecorator) properties;
        decorator.spout$initializedComponents(components);
        accessor.spout$componentInitializer(accessor.spout$componentInitializer().andThen((builder, _, _) -> builder.addAll(
            components
        )));
        accessor.spout$requiredFeatures(requiredFeatures);
        id.ifPresent(identifier -> accessor.spout$id(ResourceKey.create(BuiltInRegistries.ITEM.key(), identifier)));
        return properties;
    }

    private static Item.Properties reconstructItemProperties(Item item) {
        return constructItemProperties(item.components(), item.requiredFeatures(), Optional.of(item.builtInRegistryHolder().key().identifier()));
    }

    public static final Codec<Item.Properties> CODEC = RecordCodecBuilder.create(instance -> instance.group(
        DataComponentMap.CODEC.optionalFieldOf("components", DataComponentMap.EMPTY).forGetter(properties -> ((ItemPropertiesSerializationDecorator) properties).spout$initializedComponents()),
        CodecUtil.optionalFieldOf(SubtypeCodecs.FEATURE_FLAG_SET_CODEC, "required_features", FeatureFlagSet::of).forGetter(properties -> ((ItemPropertiesSerializationAccessor) properties).spout$requiredFeatures()),
        Identifier.CODEC.optionalFieldOf("id").forGetter(properties -> Optional.ofNullable(((ItemPropertiesSerializationAccessor) properties).spout$id()).map(ResourceKey::identifier))
    ).apply(instance, ItemPropertiesCodec::constructItemProperties));

    public static <I extends Item> RecordCodecBuilder<I, Item.Properties> getBuilder() {
        return CodecUtil.optionalFieldOf(CODEC, "properties", Item.Properties::new).forGetter(ItemPropertiesCodec::reconstructItemProperties);
    }

}
