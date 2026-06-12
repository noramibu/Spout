package spout.clientview.packetmapping.blockstate.macro;

import com.mojang.serialization.MapCodec;
import spout.clientview.packetmapping.blockstate.macro.type.BlockStateMappingMacroType;
import spout.clientview.packetmapping.blockstate.macro.type.BuiltInBlockStateMappingMacroTypeRegistry;
import spout.util.minecraft.resources.IdentifierUtil;

/**
 * A macro to generate block state mappings.
 */
public interface BlockStateMappingMacro {

    MapCodec<BlockStateMappingMacro> CODEC = IdentifierUtil.byNameWithSpoutNamespaceAsDefaultCodec(BuiltInBlockStateMappingMacroTypeRegistry.BLOCK_STATE_MAPPING_MACRO_TYPE).dispatchMap(BlockStateMappingMacro::type, BlockStateMappingMacroType::codec);

    BlockStateMappingMacroType type();

}
