package spout.client.fabric.moredatadriven.minecraft.item.mixin;

import net.minecraft.core.component.DataComponentInitializers;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import spout.common.moredatadriven.minecraft.item.ItemPropertiesSerializationAccessor;

/**
 * Mixin applying {@link ItemPropertiesSerializationAccessor}
 */
@Mixin(Item.Properties.class)
public interface ItemPropertiesSerializationAccessorItemPropertiesMixin extends ItemPropertiesSerializationAccessor {

    @Accessor("componentInitializer")
    @Override
    DataComponentInitializers.Initializer<Item> spout$componentInitializer();

    @Accessor("componentInitializer")
    @Override
    void spout$componentInitializer(DataComponentInitializers.Initializer<Item> initializer);

    @Accessor("requiredFeatures")
    @Override
    FeatureFlagSet spout$requiredFeatures();

    @Accessor("requiredFeatures")
    @Override
    void spout$requiredFeatures(FeatureFlagSet requiredFeatures);

    @Accessor("id")
    @Override
    @Nullable ResourceKey<Item> spout$id();

    @Accessor("id")
    @Override
    void spout$id(@Nullable ResourceKey<Item> id);

}
