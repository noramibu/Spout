package spout.clientview.packetmapping.blockstate.macro.type;

import com.mojang.serialization.MapCodec;
import spout.clientview.packetmapping.blockstate.macro.BlockStateMappingMacro;

/**
 * A type of {@link BlockStateMappingMacro}.
 */
public class BlockStateMappingMacroType {

    BlockStateMappingMacroType() {
    }

    public MapCodec<BlockStateMappingMacro> codec() {
        return null; // TODO
    }

    @Override
    public String toString() {
        return "BlockStateMappingMacroType{" + BuiltInBlockStateMappingMacroTypeRegistry.BLOCK_STATE_MAPPING_MACRO_TYPE.wrapAsHolder(this).getRegisteredName() + "}";
    }

}
