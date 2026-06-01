package spout.common.moredatadriven.minecraft;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import spout.branding.SpoutNamespace;
import spout.common.moredatadriven.minecraft.blocktype.SpoutBlockType;
import spout.common.moredatadriven.minecraft.itemtype.SpoutItemType;
import spout.common.util.minecraft.registry.RegistryKeyUtil;

/**
 * A class similar to {@link Registries},
 * that holds the keys for some registries in {@link BuiltInSpoutMoreDataDrivenRegistries}.
 */
public final class SpoutMoreDataDrivenRegistries {

    private SpoutMoreDataDrivenRegistries() {
        throw new UnsupportedOperationException();
    }

    /**
     * Key for {@link BuiltInSpoutMoreDataDrivenRegistries#BLOCK_TYPE}.
     */
    public static final ResourceKey<Registry<SpoutBlockType>> BLOCK_TYPE = RegistryKeyUtil.createWithSpoutNamespace("block_type");

    /**
     * Key for {@link BuiltInSpoutMoreDataDrivenRegistries#ITEM_TYPE}.
     */
    public static final ResourceKey<Registry<SpoutItemType>> ITEM_TYPE = RegistryKeyUtil.createWithSpoutNamespace("item_type");

}
