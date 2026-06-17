package spout.api.clientview.packetmapping.blockstate.registry;

import io.papermc.paper.registry.PaperRegistryBuilder;
import io.papermc.paper.registry.data.util.Conversions;

/**
 * The implementation for {@link BlockStateMappingRegistryEntry}
 * and {@link BlockStateMappingRegistryEntryNMS}.
 */
public class BlockStateMappingRegistryEntryImpl implements BlockStateMappingRegistryEntryNMS {

    public BlockStateMappingRegistryEntryImpl(
        final Conversions ignoredConversions,
        final BlockStateMapping internal
    ) {
        if (internal == null) return;
    }

    public static final class BuilderImpl extends BlockStateMappingRegistryEntryImpl implements BlockStateMappingRegistryEntryNMS.Builder,
        PaperRegistryBuilder<spout.clientview.packetmapping.blockstate.registry.BlockStateMapping, BlockStateMapping> {

        public BuilderImpl(
            final Conversions conversions,
            final BlockStateMapping internal
        ) {
            super(conversions, internal);
        }

        @Override
        public spout.clientview.packetmapping.blockstate.registry.BlockStateMapping build() {
            return null;//TODO
        }

    }

}
