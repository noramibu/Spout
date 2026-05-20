package spout.client.fabric.moredatadriven.minecraft.item.mixin;

import net.minecraft.world.item.DoubleHighBlockItem;
import org.spongepowered.asm.mixin.Mixin;
import spout.common.moredatadriven.minecraft.item.ItemTypeDecorator;
import spout.common.moredatadriven.minecraft.itemtype.SpoutItemType;
import spout.common.moredatadriven.minecraft.itemtype.SpoutItemTypes;

/**
 * Mixin applying {@link ItemTypeDecorator}
 */
@Mixin(DoubleHighBlockItem.class)
public abstract class ItemTypeDecoratorDoubleHighBlockItemMixin implements ItemTypeDecorator {

    @Override
    public SpoutItemType spout$getItemType() {
        return SpoutItemTypes.DOUBLE_HIGH_BLOCK;
    }

}
