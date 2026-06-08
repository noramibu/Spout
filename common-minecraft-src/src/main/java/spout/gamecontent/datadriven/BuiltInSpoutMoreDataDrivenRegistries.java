package spout.gamecontent.datadriven;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import spout.gamecontent.datadriven.blocktype.SpoutBlockTypeRegistry;
import spout.gamecontent.datadriven.blocktype.SpoutBlockTypes;
import spout.gamecontent.datadriven.itemtype.SpoutItemType;
import spout.gamecontent.datadriven.itemtype.SpoutItemTypes;

/**
 * A class similar to {@link BuiltInRegistries},
 * that holds the built-in Spout registries that Spout uses to add more data-driven elements.
 */
public final class BuiltInSpoutMoreDataDrivenRegistries {

    private BuiltInSpoutMoreDataDrivenRegistries() {
        throw new UnsupportedOperationException();
    }

    /**
     * A registry for block types.
     *
     * <p>
     * This registry is synchronized with {@link BuiltInRegistries#BLOCK_TYPE}:
     * entries added to either are added to the other.
     * </p>
     */
    public static final SpoutBlockTypeRegistry BLOCK_TYPE = BuiltInRegistries.internalRegister(SpoutMoreDataDrivenRegistries.BLOCK_TYPE, new SpoutBlockTypeRegistry(), SpoutBlockTypes::bootstrap);

    /**
     * A registry for item types.
     */
    public static final Registry<SpoutItemType> ITEM_TYPE = BuiltInRegistries.registerSimple(SpoutMoreDataDrivenRegistries.ITEM_TYPE, SpoutItemTypes::bootstrap);

    public static Registry<?> bootstrap() {
        return ITEM_TYPE;
    }

}
