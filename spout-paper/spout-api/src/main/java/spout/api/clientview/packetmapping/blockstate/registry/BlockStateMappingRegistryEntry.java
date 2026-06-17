package spout.api.clientview.packetmapping.blockstate.registry;

import io.papermc.paper.registry.RegistryBuilder;
import org.jetbrains.annotations.ApiStatus;

/**
 * A data-centric version-specific registry entry for the {@link BlockStateMapping} type.
 */
public interface BlockStateMappingRegistryEntry {

    /**
     * A mutable builder for a {@link BlockStateMappingRegistryEntry}.
     */
    @ApiStatus.NonExtendable
    interface Builder extends BlockStateMappingRegistryEntry, RegistryBuilder<BlockStateMapping> {

    }

}
