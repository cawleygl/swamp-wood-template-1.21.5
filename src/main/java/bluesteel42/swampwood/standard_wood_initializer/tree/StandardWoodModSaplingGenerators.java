package bluesteel42.swampwood.standard_wood_initializer.tree;

import bluesteel42.swampwood.standard_wood_initializer.StandardWoodInitializer;
import net.minecraft.block.SaplingGenerator;

public class StandardWoodModSaplingGenerators {
    public static final SaplingGenerator MOD_SAPLING_GENERATOR = new SaplingGenerator(
            StandardWoodInitializer.MOD_ID + ":" + StandardWoodInitializer.WOOD_TYPE,
            StandardWoodInitializer.SAPLING_RARE_VARIANT_CHANCE,
            StandardWoodInitializer.SAPLING_MEGA_TREE,
            StandardWoodInitializer.SAPLING_RARE_MEGA_TREE,
            StandardWoodInitializer.SAPLING_STANDARD_TREE,
            StandardWoodInitializer.SAPLING_RARE_TREE,
            StandardWoodInitializer.SAPLING_BEES_TREE,
            StandardWoodInitializer.SAPLING_RARE_BEES_TREE
    );
}
