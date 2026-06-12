package spout.clientview.packetmapping.blockstate.macro.type;

import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import spout.branding.SpoutNamespace;

/**
 * Holds the existing {@link BlockStateMappingMacroType} values.
 */
public final class BlockStateMappingMacroTypes {

    private BlockStateMappingMacroTypes() {
        throw new UnsupportedOperationException();
    }

    public static final BlockStateMappingMacroType BARREL = register("barrel", new BlockStateMappingMacroType());
    public static final BlockStateMappingMacroType BRUSHABLE = register("brushable", new BlockStateMappingMacroType());
    public static final BlockStateMappingMacroType BUTTON = register("button", new BlockStateMappingMacroType());
    public static final BlockStateMappingMacroType CHAIN = register("chain", new BlockStateMappingMacroType());
    public static final BlockStateMappingMacroType CHISELED_BOOKSHELF = register("chiseled_bookshelf", new BlockStateMappingMacroType());
    public static final BlockStateMappingMacroType DOOR = register("door", new BlockStateMappingMacroType());
    public static final BlockStateMappingMacroType FENCE = register("fence", new BlockStateMappingMacroType());
    public static final BlockStateMappingMacroType FENCE_GATE = register("fence_gate", new BlockStateMappingMacroType());
    public static final BlockStateMappingMacroType FLOWER_POT = register("flower_pot", new BlockStateMappingMacroType());
    public static final BlockStateMappingMacroType FULL_BLOCK = register("full_block", new BlockStateMappingMacroType());
    public static final BlockStateMappingMacroType FURNACE = register("furnace", new BlockStateMappingMacroType());
    public static final BlockStateMappingMacroType GLAZED_TERRACOTTA = register("glazed_terracotta", new BlockStateMappingMacroType());
    public static final BlockStateMappingMacroType LADDER = register("ladder", new BlockStateMappingMacroType());
    public static final BlockStateMappingMacroType LEAVES = register("leaves", new BlockStateMappingMacroType());
    public static final BlockStateMappingMacroType LOOM = register("loom", new BlockStateMappingMacroType());
    public static final BlockStateMappingMacroType NETHER_PORTAL = register("nether_portal", new BlockStateMappingMacroType());
    public static final BlockStateMappingMacroType PRESSURE_PLATE = register("pressure_plate", new BlockStateMappingMacroType());
    public static final BlockStateMappingMacroType PUMPKIN = register("pumpkin", new BlockStateMappingMacroType());
    public static final BlockStateMappingMacroType REDSTONE_ORE = register("redstone_ore", new BlockStateMappingMacroType());
    public static final BlockStateMappingMacroType RESPAWN_ANCHOR = register("respawn_anchor", new BlockStateMappingMacroType());
    public static final BlockStateMappingMacroType ROTATED_PILLAR = register("rotated_pillar", new BlockStateMappingMacroType());
    public static final BlockStateMappingMacroType SAPLING = register("sapling", new BlockStateMappingMacroType());
    public static final BlockStateMappingMacroType SINGLE = register("single", new BlockStateMappingMacroType());
    public static final BlockStateMappingMacroType SLAB = register("slab", new BlockStateMappingMacroType());
    public static final BlockStateMappingMacroType STAIRS = register("stairs", new BlockStateMappingMacroType());
    public static final BlockStateMappingMacroType TRAPDOOR = register("trapdoor", new BlockStateMappingMacroType());
    public static final BlockStateMappingMacroType WALL = register("wall", new BlockStateMappingMacroType());

    private static BlockStateMappingMacroType register(String name, BlockStateMappingMacroType value) {
        return register(Identifier.fromNamespaceAndPath(SpoutNamespace.SPOUT, name), value);
    }

    private static BlockStateMappingMacroType register(Identifier location, BlockStateMappingMacroType value) {
        return Registry.register(BuiltInBlockStateMappingMacroTypeRegistry.BLOCK_STATE_MAPPING_MACRO_TYPE, location, value);
    }

    public static BlockStateMappingMacroType bootstrap(Registry<BlockStateMappingMacroType> registry) {
        return WALL;
    }

}
