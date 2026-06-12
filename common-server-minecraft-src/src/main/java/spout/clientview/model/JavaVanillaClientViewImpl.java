package spout.clientview.model;

import net.minecraft.network.Connection;
import spout.api.clientview.model.ClientView;

/**
 * A simple implementation of {@link ClientView}
 * for {@link ClientView.AwarenessLevel#VANILLA} clients.
 */
public class JavaVanillaClientViewImpl extends ConnectionClientViewImpl {

    public JavaVanillaClientViewImpl(Connection connection) {
        super(connection);
    }

    @Override
    public AwarenessLevel getAwarenessLevel() {
        return AwarenessLevel.VANILLA;
    }

}
