package spout.api.gamecontent.datadriven.material.enuminjection;

import org.apache.commons.lang3.tuple.Triple;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.BlockType;
import org.bukkit.inventory.ItemType;
import spout.api.SpoutAPIServices;
import spout.api.gamecontent.datadriven.common.enuminjection.BukkitEnumNames;
import org.jspecify.annotations.Nullable;

/**
 * The {@link BukkitEnumNames} for {@link Material}.
 */
public interface MaterialEnumNames extends BukkitEnumNames<Triple<NamespacedKey, @Nullable BlockType, @Nullable ItemType>> {

    /**
     * @return The {@link MaterialEnumNames} instance.
     */
    static MaterialEnumNames get() {
        return SpoutAPIServices.getMaterialEnumNames();
    }

}
