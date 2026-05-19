package spout.common.moredatadriven.minecraft.item;

import net.minecraft.core.component.DataComponentInitializers;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import org.jspecify.annotations.Nullable;

/**
 * An accessor for values in {@link Item.Properties}
 * that are important for serialization.
 */
public interface ItemPropertiesSerializationAccessor {

    DataComponentInitializers.Initializer<Item> spout$componentInitializer();

    void spout$componentInitializer(DataComponentInitializers.Initializer<Item> componentInitializer);

    FeatureFlagSet spout$requiredFeatures();

    void spout$requiredFeatures(FeatureFlagSet requiredFeatures);

    @Nullable ResourceKey<Item> spout$id();

    void spout$id(@Nullable ResourceKey<Item> id);

}
