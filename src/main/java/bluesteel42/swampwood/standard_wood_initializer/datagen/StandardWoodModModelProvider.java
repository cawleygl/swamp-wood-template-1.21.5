package bluesteel42.swampwood.standard_wood_initializer.datagen;

import bluesteel42.swampwood.standard_wood_initializer.StandardWoodInitializer;
import bluesteel42.swampwood.standard_wood_initializer.block.StandardWoodModBlocks;
import bluesteel42.swampwood.standard_wood_initializer.entity.StandardWoodModBoats;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.TexturedModel;

public class StandardWoodModModelProvider extends FabricModelProvider {
    public StandardWoodModModelProvider(FabricDataOutput output) {
        super(output);
    }

    public void generateStandardWoodBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.createLogTexturePool(StandardWoodModBlocks.MOD_LOG).log(StandardWoodModBlocks.MOD_LOG).wood(StandardWoodModBlocks.MOD_WOOD);
        blockStateModelGenerator.createLogTexturePool(StandardWoodModBlocks.STRIPPED_MOD_LOG).log(StandardWoodModBlocks.STRIPPED_MOD_LOG).wood(StandardWoodModBlocks.STRIPPED_MOD_WOOD);

        BlockStateModelGenerator.BlockTexturePool swampPlankPool = blockStateModelGenerator.registerCubeAllModelTexturePool(StandardWoodModBlocks.MOD_PLANKS);
        swampPlankPool.stairs(StandardWoodModBlocks.MOD_STAIRS);
        swampPlankPool.slab(StandardWoodModBlocks.MOD_SLAB);
        swampPlankPool.button(StandardWoodModBlocks.MOD_BUTTON);
        swampPlankPool.fence(StandardWoodModBlocks.MOD_FENCE);
        swampPlankPool.fenceGate(StandardWoodModBlocks.MOD_FENCE_GATE);
        swampPlankPool.pressurePlate(StandardWoodModBlocks.MOD_PRESSURE_PLATE);
        blockStateModelGenerator.registerDoor(StandardWoodModBlocks.MOD_DOOR);
        blockStateModelGenerator.registerOrientableTrapdoor(StandardWoodModBlocks.MOD_TRAPDOOR);
        swampPlankPool.family(StandardWoodModBlocks.MOD_SIGN_FAMILY);
        blockStateModelGenerator.registerHangingSign(StandardWoodModBlocks.STRIPPED_MOD_LOG, StandardWoodModBlocks.MOD_HANGING_SIGN, StandardWoodModBlocks.MOD_WALL_HANGING_SIGN);

        blockStateModelGenerator.registerTintedBlockAndItem(StandardWoodModBlocks.MOD_LEAVES, TexturedModel.LEAVES, StandardWoodInitializer.LEAF_TINT_COLOR);
        blockStateModelGenerator.registerFlowerPotPlantAndItem(StandardWoodModBlocks.MOD_SAPLING, StandardWoodModBlocks.POTTED_MOD_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);

        blockStateModelGenerator.registerItemModel(StandardWoodModBoats.MOD_BOAT);
        blockStateModelGenerator.registerItemModel(StandardWoodModBoats.MOD_CHEST_BOAT);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        generateStandardWoodBlockStateModels(blockStateModelGenerator);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
