package spout.clientview.packetmapping;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import spout.common.util.minecraft.registry.RegistryKeyUtil;

/**
 * A class similar to {@link Registries},
 * that holds the keys for some registries in {@link BuiltInSpoutPacketMappingRegistries}.
 */
public final class SpoutPacketMappingRegistries {

    private SpoutPacketMappingRegistries() {
        throw new UnsupportedOperationException();
    }

    /**
     * Key for {@link BuiltInSpoutPacketMappingRegistries#BLOCK_STATE_MAPPING}.
     */
    // public static final ResourceKey<Registry<BlockStateMapping>> BLOCK_STATE_MAPPING = RegistryKeyUtil.createWithSpoutNamespace("block_state_mapping");

}
