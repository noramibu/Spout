package spout.api.clientview.packetmapping.blockstate.registry;

import org.jetbrains.annotations.ApiStatus;

/**
 * NMS extension for {@link BlockStateMappingRegistryEntry}.
 */
public interface BlockStateMappingRegistryEntryNMS extends BlockStateMappingRegistryEntry {

    /**
     * NMS extension for {@link BlockStateMappingRegistryEntry.Builder}.
     */
    @ApiStatus.NonExtendable
    interface Builder extends BlockStateMappingRegistryEntryNMS, BlockStateMappingRegistryEntry.Builder {

    }

}
