package spout.server.paper.api.packetmapping.component;

import spout.util.composable.Composable;
import spout.api.SpoutAPIServices;

/**
 * A service for the component mappings that Spout applies.
 */
public interface ComponentMappings<M> extends Composable<ComponentMappingsComposeEvent<M>> {

    /**
     * @return The {@link ComponentMappings} instance.
     */
    static ComponentMappings<?> get() {
        return SpoutAPIServices.getComponentMappings();
    }

}
