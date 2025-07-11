package bluesteel42.standard_wood_initializer.datagen;

import bluesteel42.standard_wood_initializer.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.MOD_LOG);
        addDrop(ModBlocks.MOD_WOOD);
        addDrop(ModBlocks.STRIPPED_MOD_LOG);
        addDrop(ModBlocks.STRIPPED_MOD_WOOD);

        addDrop(ModBlocks.MOD_PLANKS);
        addDrop(ModBlocks.MOD_STAIRS);
        addDrop(ModBlocks.MOD_BUTTON);
        addDrop(ModBlocks.MOD_FENCE_GATE);
        addDrop(ModBlocks.MOD_FENCE);
        addDrop(ModBlocks.MOD_PRESSURE_PLATE);
        addDrop(ModBlocks.MOD_TRAPDOOR);
        addDrop(ModBlocks.MOD_DOOR, doorDrops(ModBlocks.MOD_DOOR));
        addDrop(ModBlocks.MOD_SLAB, slabDrops(ModBlocks.MOD_SLAB));

        addDrop(ModBlocks.MOD_STANDING_SIGN);
        addDrop(ModBlocks.MOD_WALL_SIGN);
        addDrop(ModBlocks.MOD_HANGING_SIGN);
        addDrop(ModBlocks.MOD_WALL_HANGING_SIGN);

        addDrop(ModBlocks.MOD_SAPLING);
        addDrop(ModBlocks.POTTED_MOD_SAPLING, pottedPlantDrops(ModBlocks.MOD_SAPLING));
        addDrop(ModBlocks.MOD_LEAVES, leavesDrops(ModBlocks.MOD_LEAVES, ModBlocks.MOD_SAPLING, 0.05f));
    }
}
