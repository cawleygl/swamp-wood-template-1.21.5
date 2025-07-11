package bluesteel42.standard_wood_initializer.datagen;

import bluesteel42.standard_wood_initializer.block.ModBlocks;
import bluesteel42.standard_wood_initializer.entity.ModBoats;
import bluesteel42.standard_wood_initializer.item.ModItems;
import bluesteel42.standard_wood_initializer.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.MOD_LOGS)
                .add(ModBlocks.MOD_LOG.asItem())
                .add(ModBlocks.MOD_WOOD.asItem())
                .add(ModBlocks.STRIPPED_MOD_LOG.asItem())
                .add(ModBlocks.STRIPPED_MOD_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN).addTag(ModTags.Items.MOD_LOGS);
        getOrCreateTagBuilder(ItemTags.PLANKS).add(ModBlocks.MOD_PLANKS.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS).add(ModBlocks.MOD_STAIRS.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_SLABS).add(ModBlocks.MOD_SLAB.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_DOORS).add(ModBlocks.MOD_DOOR.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS).add(ModBlocks.MOD_TRAPDOOR.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_FENCES).add(ModBlocks.MOD_FENCE.asItem());
        getOrCreateTagBuilder(ItemTags.FENCE_GATES).add(ModBlocks.MOD_FENCE_GATE.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS).add(ModBlocks.MOD_BUTTON.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.MOD_PRESSURE_PLATE.asItem());

        getOrCreateTagBuilder(ItemTags.SIGNS).add(ModItems.MOD_SIGN);
        getOrCreateTagBuilder(ItemTags.HANGING_SIGNS).add(ModItems.MOD_HANGING_SIGN);

        getOrCreateTagBuilder(ItemTags.BOATS).add(ModBoats.MOD_BOAT.asItem());
        getOrCreateTagBuilder(ItemTags.CHEST_BOATS).add(ModBoats.MOD_CHEST_BOAT.asItem());

        getOrCreateTagBuilder(ItemTags.LEAVES).add(ModBlocks.MOD_LEAVES.asItem());
        getOrCreateTagBuilder(ItemTags.SAPLINGS).add(ModBlocks.MOD_SAPLING.asItem());
    }
}
