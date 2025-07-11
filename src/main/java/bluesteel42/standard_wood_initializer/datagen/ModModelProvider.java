package bluesteel42.standard_wood_initializer.datagen;

import bluesteel42.standard_wood_initializer.StandardWoodInitializer;
import bluesteel42.standard_wood_initializer.block.ModBlocks;
import bluesteel42.standard_wood_initializer.entity.ModBoats;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.TexturedModel;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.createLogTexturePool(ModBlocks.MOD_LOG).log(ModBlocks.MOD_LOG).wood(ModBlocks.MOD_WOOD);
        blockStateModelGenerator.createLogTexturePool(ModBlocks.STRIPPED_MOD_LOG).log(ModBlocks.STRIPPED_MOD_LOG).wood(ModBlocks.STRIPPED_MOD_WOOD);

        BlockStateModelGenerator.BlockTexturePool swampPlankPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MOD_PLANKS);
        swampPlankPool.stairs(ModBlocks.MOD_STAIRS);
        swampPlankPool.slab(ModBlocks.MOD_SLAB);
        swampPlankPool.button(ModBlocks.MOD_BUTTON);
        swampPlankPool.fence(ModBlocks.MOD_FENCE);
        swampPlankPool.fenceGate(ModBlocks.MOD_FENCE_GATE);
        swampPlankPool.pressurePlate(ModBlocks.MOD_PRESSURE_PLATE);
        blockStateModelGenerator.registerDoor(ModBlocks.MOD_DOOR);
        blockStateModelGenerator.registerOrientableTrapdoor(ModBlocks.MOD_TRAPDOOR);
        swampPlankPool.family(ModBlocks.MOD_SIGN_FAMILY);
        blockStateModelGenerator.registerHangingSign(ModBlocks.STRIPPED_MOD_LOG, ModBlocks.MOD_HANGING_SIGN, ModBlocks.MOD_WALL_HANGING_SIGN);

        blockStateModelGenerator.registerTintedBlockAndItem(ModBlocks.MOD_LEAVES, TexturedModel.LEAVES, StandardWoodInitializer.LEAF_TINT_COLOR);
        blockStateModelGenerator.registerFlowerPotPlantAndItem(ModBlocks.MOD_SAPLING, ModBlocks.POTTED_MOD_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);

        blockStateModelGenerator.registerItemModel(ModBoats.MOD_BOAT);
        blockStateModelGenerator.registerItemModel(ModBoats.MOD_CHEST_BOAT);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
