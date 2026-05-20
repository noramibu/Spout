package spout.common.moredatadriven.minecraft.item;

import net.minecraft.world.item.Item;
import spout.common.moredatadriven.minecraft.itemtype.SpoutItemType;

/**
 * A decorator of {@link Item} that provides the {@link SpoutItemType}.
 */
public interface ItemTypeDecorator {

    SpoutItemType spout$getItemType();

}
