package spout.server.paper.api.packetmapping.block;

import spout.api.SpoutAPIServices;
import spout.util.composable.Composable;

/**
 * A service for the block mappings that Spout applies.
 */
public interface BlockMappings extends Composable<BlockMappingsComposeEvent> {

    /**
     * @return The {@link BlockMappings} instance.
     */
    static BlockMappings get() {
        return SpoutAPIServices.getBlockMappings();
    }

}
