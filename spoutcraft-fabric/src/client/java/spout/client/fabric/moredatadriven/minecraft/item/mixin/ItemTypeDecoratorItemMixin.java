package spout.client.fabric.moredatadriven.minecraft.item.mixin;

import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import spout.common.moredatadriven.minecraft.item.ItemTypeDecorator;
import spout.common.moredatadriven.minecraft.itemtype.SpoutItemType;
import spout.common.moredatadriven.minecraft.itemtype.SpoutItemTypes;

/**
 * Mixin applying {@link ItemTypeDecorator}
 */
@Mixin(Item.class)
public abstract class ItemTypeDecoratorItemMixin implements ItemTypeDecorator {

    @Override
    public SpoutItemType spout$getItemType() {
        return SpoutItemTypes.ITEM;
    }

}
