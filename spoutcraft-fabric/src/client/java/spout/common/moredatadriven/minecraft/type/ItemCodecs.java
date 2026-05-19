package spout.common.moredatadriven.minecraft.type;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.EggItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

/**
 * Holder for {@link Item} codecs.
 */
public final class ItemCodecs {

    private ItemCodecs() {
        throw new UnsupportedOperationException();
    }

    /**
     * Based on {@link Block#CODEC}.
     */
    public static final MapCodec<Item> ITEM_CODEC = spout.common.moredatadriven.minecraft.item.ItemCodecs.simpleCodec(Item::new);

    /**
     * Based on {@link Block#CODEC}.
     */
    public static final MapCodec<BlockItem> BLOCK_ITEM_CODEC = spout.common.moredatadriven.minecraft.item.ItemCodecs.simpleCodec(
        BuiltInRegistries.BLOCK.byNameCodec().fieldOf("block").forGetter(BlockItem::getBlock),
        (block, properties) -> new BlockItem(block, properties.useBlockDescriptionPrefix())
    );

    /**
     * Based on {@link Block#CODEC}.
     */
    public static final MapCodec<EggItem> EGG_ITEM_CODEC = spout.common.moredatadriven.minecraft.item.ItemCodecs.simpleCodec(EggItem::new);

    public static final MapCodec<BlockItem> DOUBLE_HIGH_BLOCK_ITEM_CODEC = spout.common.moredatadriven.minecraft.item.ItemCodecs.simpleCodec(
        BuiltInRegistries.BLOCK.byNameCodec().fieldOf("block").forGetter(BlockItem::getBlock),
        (block, properties) -> new BlockItem(block, properties.useBlockDescriptionPrefix())
    );

}
