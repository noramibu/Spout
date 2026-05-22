package spout.common.protocol;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.Nullable;
import spout.common.moredatadriven.minecraft.block.SpoutNonBuiltInBlock;
import spout.common.moredatadriven.minecraft.item.SpoutNonBuiltInItem;
import spout.common.util.minecraft.resources.KeyedValue;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains all custom content sent by a Spout server.
 */
public final class ClientModCustomContent {

    /**
     * The blocks.
     */
    private final List<KeyedValue<SpoutNonBuiltInBlock>> blocks;

    /**
     * The items.
     */
    private final List<KeyedValue<SpoutNonBuiltInItem>> items;

    /**
     * The parsed blocks,
     * or null if not initialized yet.
     */
    private @Nullable List<Block> parsedBlocks;

    /**
     * The parsed items,
     * or null if not initialized yet.
     */
    private @Nullable List<Item> parsedItems;

    private ClientModCustomContent() {
        this.blocks = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    public List<KeyedValue<SpoutNonBuiltInBlock>> getBlocks() {
        return this.blocks;
    }

    public List<KeyedValue<SpoutNonBuiltInItem>> getItems() {
        return this.items;
    }

    public static ClientModCustomContent createFilled(
        List<Block> blocks,
        List<Item> items
    ) {
        ClientModCustomContent content = new ClientModCustomContent();
        content.blocks.addAll(
            blocks.stream().map(block -> KeyedValue.of(block.builtInRegistryHolder().key().identifier(), new SpoutNonBuiltInBlock(block))).toList()
        );
        content.items.addAll(
            items.stream().map(item -> KeyedValue.of(item.builtInRegistryHolder().key().identifier(), new SpoutNonBuiltInItem(item))).toList()
        );
        return content;
    }

    public static ClientModCustomContent createEmpty() {
        return new ClientModCustomContent();
    }

}
