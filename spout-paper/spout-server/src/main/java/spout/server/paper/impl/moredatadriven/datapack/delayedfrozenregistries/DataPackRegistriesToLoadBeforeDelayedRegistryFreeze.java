package spout.server.paper.impl.moredatadriven.datapack.delayedfrozenregistries;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraft.resources.RegistryValidator;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import spout.common.moredatadriven.minecraft.block.ContextAwareBlockPropertiesDecoding;
import spout.common.moredatadriven.minecraft.block.SpoutNonBuiltInBlock;
import spout.common.moredatadriven.minecraft.item.ContextAwareItemPropertiesDecoding;
import spout.common.moredatadriven.minecraft.item.SpoutNonBuiltInItem;
import spout.server.paper.impl.moredatadriven.datapack.CopyResourcesFromDataPackRegistryToInternalRegistry;
import spout.server.paper.impl.moredatadriven.datapack.SpoutDataPackRegistries;
import spout.server.paper.impl.packetmapping.block.datadriven.UnappliedDataDrivenBlockMapping;
import spout.server.paper.impl.packetmapping.item.datadriven.UnappliedDataDrivenItemMapping;
import java.util.List;
import java.util.function.Consumer;

/**
 * A holder, similar to {@link RegistryDataLoader#WORLDGEN_REGISTRIES},
 * for the registries that are loaded from data packs before the delayed registries are frozen.
 */
public final class DataPackRegistriesToLoadBeforeDelayedRegistryFreeze {

    private DataPackRegistriesToLoadBeforeDelayedRegistryFreeze() {
        throw new UnsupportedOperationException();
    }

    public static final List<Instance<?>> REGISTRIES = List.of(
        new Instance<>(
            SpoutDataPackRegistries.BLOCK_FROM_DATA_PACK,
            SpoutNonBuiltInBlock.CODEC,
            registry -> CopyResourcesFromDataPackRegistryToInternalRegistry.copyInitialized(
                registry,
                BuiltInRegistries.BLOCK,
                _ -> (key, resource) -> {
                    ContextAwareBlockPropertiesDecoding.setKey(key);
                    resource.initializeValueFromInput(false);
                    ContextAwareBlockPropertiesDecoding.clearKey();
                    Block block = resource.getValue();
                    Object mappingsInput = resource.getInput().input().get("mappings");
                    if (mappingsInput != null) {
                        DataResult<com.mojang.datafixers.util.Pair<List<UnappliedDataDrivenBlockMapping>, ?>> mappings = UnappliedDataDrivenBlockMapping.LIST_CODEC.decode((DynamicOps) resource.getInput().ops(), mappingsInput);
                        block.unappliedDataPackMappings = mappings.getOrThrow().getFirst();
                    }
                    resource.clearInput();
                    return block;
                }
            )
        ),
        new Instance<>(
            SpoutDataPackRegistries.ITEM_FROM_DATA_PACK,
            SpoutNonBuiltInItem.CODEC,
            registry -> CopyResourcesFromDataPackRegistryToInternalRegistry.copyInitialized(
                registry,
                BuiltInRegistries.ITEM,
                _ -> (key, resource) -> {
                    ContextAwareItemPropertiesDecoding.setKey(key);
                    resource.initializeValueFromInput(false);
                    ContextAwareItemPropertiesDecoding.clearKey();
                    Item item = resource.getValue();
                    Object mappingsInput = resource.getInput().input().get("mappings");
                    if (mappingsInput != null) {
                        DataResult<com.mojang.datafixers.util.Pair<List<UnappliedDataDrivenItemMapping>, ?>> mappings = UnappliedDataDrivenItemMapping.LIST_CODEC.decode((DynamicOps) resource.getInput().ops(), mappingsInput);
                        item.unappliedDataPackMappings = mappings.getOrThrow().getFirst();
                    }
                    resource.clearInput();
                    return item;
                }
            )
        )
    );

    public record Instance<T>(
        RegistryDataLoader.RegistryData<T> registryData,
        Consumer<Registry<T>> postLoadAction
    ) {

        public Instance(ResourceKey<Registry<T>> registryKey, Codec<T> codec, Consumer<Registry<T>> postLoadAction) {
            this(new RegistryDataLoader.RegistryData<>(registryKey, codec, RegistryValidator.none()), postLoadAction);
        }

        public Instance(ResourceKey<Registry<T>> registryKey, MapCodec<T> codec, Consumer<Registry<T>> postLoadAction) {
            this(registryKey, codec.codec(), postLoadAction);
        }

    }

}
