package bluesteel42.swampwood.standard_wood_initializer.datagen;

import bluesteel42.swampwood.standard_wood_initializer.block.StandardWoodModBlocks;
import bluesteel42.swampwood.standard_wood_initializer.util.StandardWoodModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class StandardWoodModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public StandardWoodModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public void generateStandardWoodBlocks() {
        getOrCreateTagBuilder(StandardWoodModTags.Blocks.MOD_LOGS)
                .add(StandardWoodModBlocks.MOD_LOG)
                .add(StandardWoodModBlocks.MOD_WOOD)
                .add(StandardWoodModBlocks.STRIPPED_MOD_LOG)
                .add(StandardWoodModBlocks.STRIPPED_MOD_WOOD);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).addTag(StandardWoodModTags.Blocks.MOD_LOGS);
        getOrCreateTagBuilder(BlockTags.PLANKS).add(StandardWoodModBlocks.MOD_PLANKS);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(StandardWoodModBlocks.MOD_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(StandardWoodModBlocks.MOD_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS).add(StandardWoodModBlocks.MOD_DOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS).add(StandardWoodModBlocks.MOD_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(StandardWoodModBlocks.MOD_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(StandardWoodModBlocks.MOD_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS).add(StandardWoodModBlocks.MOD_BUTTON);
        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(StandardWoodModBlocks.MOD_PRESSURE_PLATE);

        getOrCreateTagBuilder(BlockTags.STANDING_SIGNS).add(StandardWoodModBlocks.MOD_STANDING_SIGN);
        getOrCreateTagBuilder(BlockTags.WALL_SIGNS).add(StandardWoodModBlocks.MOD_WALL_SIGN);
        getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS).add(StandardWoodModBlocks.MOD_HANGING_SIGN);
        getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS).add(StandardWoodModBlocks.MOD_WALL_HANGING_SIGN);

        getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS).add(StandardWoodModBlocks.MOD_WALL_HANGING_SIGN);

        getOrCreateTagBuilder(BlockTags.LEAVES).add(StandardWoodModBlocks.MOD_LEAVES);
        getOrCreateTagBuilder(BlockTags.SAPLINGS).add(StandardWoodModBlocks.MOD_SAPLING);
        getOrCreateTagBuilder(BlockTags.FLOWER_POTS).add(StandardWoodModBlocks.POTTED_MOD_SAPLING);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        generateStandardWoodBlocks();
    }
}

