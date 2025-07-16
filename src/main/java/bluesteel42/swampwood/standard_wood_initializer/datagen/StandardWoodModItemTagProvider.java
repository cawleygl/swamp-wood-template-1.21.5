package bluesteel42.swampwood.standard_wood_initializer.datagen;

import bluesteel42.swampwood.standard_wood_initializer.block.StandardWoodModBlocks;
import bluesteel42.swampwood.standard_wood_initializer.entity.StandardWoodModBoats;
import bluesteel42.swampwood.standard_wood_initializer.item.StandardWoodModItems;
import bluesteel42.swampwood.standard_wood_initializer.util.StandardWoodModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class StandardWoodModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public StandardWoodModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    public void generateStandardWoodItems() {
        getOrCreateTagBuilder(StandardWoodModTags.Items.MOD_LOGS)
                .add(StandardWoodModBlocks.MOD_LOG.asItem())
                .add(StandardWoodModBlocks.MOD_WOOD.asItem())
                .add(StandardWoodModBlocks.STRIPPED_MOD_LOG.asItem())
                .add(StandardWoodModBlocks.STRIPPED_MOD_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN).addTag(StandardWoodModTags.Items.MOD_LOGS);
        getOrCreateTagBuilder(ItemTags.PLANKS).add(StandardWoodModBlocks.MOD_PLANKS.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS).add(StandardWoodModBlocks.MOD_STAIRS.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_SLABS).add(StandardWoodModBlocks.MOD_SLAB.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_DOORS).add(StandardWoodModBlocks.MOD_DOOR.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS).add(StandardWoodModBlocks.MOD_TRAPDOOR.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_FENCES).add(StandardWoodModBlocks.MOD_FENCE.asItem());
        getOrCreateTagBuilder(ItemTags.FENCE_GATES).add(StandardWoodModBlocks.MOD_FENCE_GATE.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS).add(StandardWoodModBlocks.MOD_BUTTON.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES).add(StandardWoodModBlocks.MOD_PRESSURE_PLATE.asItem());

        getOrCreateTagBuilder(ItemTags.SIGNS).add(StandardWoodModItems.MOD_SIGN);
        getOrCreateTagBuilder(ItemTags.HANGING_SIGNS).add(StandardWoodModItems.MOD_HANGING_SIGN);

        getOrCreateTagBuilder(ItemTags.BOATS).add(StandardWoodModBoats.MOD_BOAT.asItem());
        getOrCreateTagBuilder(ItemTags.CHEST_BOATS).add(StandardWoodModBoats.MOD_CHEST_BOAT.asItem());

        getOrCreateTagBuilder(ItemTags.LEAVES).add(StandardWoodModBlocks.MOD_LEAVES.asItem());
        getOrCreateTagBuilder(ItemTags.SAPLINGS).add(StandardWoodModBlocks.MOD_SAPLING.asItem());
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        generateStandardWoodItems();
    }
}
