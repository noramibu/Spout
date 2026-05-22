package spout.common.moredatadriven.minecraft.block;

import net.minecraft.world.level.block.Block;
import spout.common.moredatadriven.minecraft.BuiltInSpoutMoreDataDrivenRegistries;
import spout.common.moredatadriven.minecraft.blocktype.SpoutBlockType;
import java.util.Objects;

/**
 * A decorator of {@link Block} that provides the {@link SpoutBlockType}.
 */
public interface BlockTypeDecorator {

    default SpoutBlockType spout$getBlockType() {
        return Objects.requireNonNull(BuiltInSpoutMoreDataDrivenRegistries.BLOCK_TYPE.byBlockCodec(((BlockCodecAccessor) this).spout$codec()));
    }

}
