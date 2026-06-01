package spout.clientview.packetmapping;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;

/**
 * A class similar to {@link BuiltInRegistries},
 * that holds the built-in Spout registries for packet mappings.
 */
public final class BuiltInSpoutPacketMappingRegistries {

    private BuiltInSpoutPacketMappingRegistries() {
        throw new UnsupportedOperationException();
    }

    /**
     * A registry for block state mappings.
     */
    // public static final BlockStateMappingRegistry BLOCK_STATE_MAPPING = BuiltInRegistries.internalRegister(SpoutPacketMappingRegistries.BLOCK_STATE_MAPPING, new BlockStateMappingRegistry(), _ -> null);

    // public static Registry<?> bootstrap() {
    //     return BLOCK_STATE_MAPPING;
    // }

}
