package spout.common.moredatadriven.minecraft.blocktype;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.Nullable;
import spout.common.moredatadriven.minecraft.block.SpoutNonBuiltInBlock;
import spout.common.moredatadriven.minecraft.common.type.TypeWithCodec;

/**
 * A block type, which represents an implementation of a {@link Block}.
 */
public interface SpoutBlockType extends TypeWithCodec<Block, SpoutNonBuiltInBlock> {

    @Nullable MapCodec<? extends Block> getBlockClassCodec();

}
