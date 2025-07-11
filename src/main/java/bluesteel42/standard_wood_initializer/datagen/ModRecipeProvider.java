package bluesteel42.standard_wood_initializer.datagen;

import bluesteel42.standard_wood_initializer.StandardWoodInitializer;
import bluesteel42.standard_wood_initializer.block.ModBlocks;
import bluesteel42.standard_wood_initializer.entity.ModBoats;
import bluesteel42.standard_wood_initializer.item.ModItems;
import bluesteel42.standard_wood_initializer.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {

            @Override
            public void generate() {
                RegistryEntryLookup<Item> registryLookup = wrapperLookup.getOrThrow(RegistryKeys.ITEM);

                offerBarkBlockRecipe(ModBlocks.MOD_WOOD, ModBlocks.MOD_LOG);
                offerBarkBlockRecipe(ModBlocks.STRIPPED_MOD_WOOD, ModBlocks.STRIPPED_MOD_LOG);
                offerPlanksRecipe(ModBlocks.MOD_PLANKS, ModTags.Items.MOD_LOGS, 4);
                ShapedRecipeJsonBuilder.create(registryLookup, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOD_STAIRS, 4)
                        .pattern("#  ")
                        .pattern("## ")
                        .pattern("###")
                        .input('#', ModBlocks.MOD_PLANKS)
                        .group("wooden_stairs")
                        .criterion("has_planks", conditionsFromItem(ModBlocks.MOD_PLANKS))
                        .offerTo(exporter);
                ShapedRecipeJsonBuilder.create(registryLookup, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOD_SLAB, 6)
                        .pattern("###")
                        .input('#', ModBlocks.MOD_PLANKS)
                        .group("wooden_slab")
                        .criterion("has_planks", conditionsFromItem(ModBlocks.MOD_PLANKS))
                        .offerTo(exporter);
                ShapelessRecipeJsonBuilder.create(registryLookup, RecipeCategory.REDSTONE, ModBlocks.MOD_BUTTON, 1)
                        .input(ModBlocks.MOD_PLANKS)
                        .group("wooden_button")
                        .criterion("has_planks", conditionsFromItem(ModBlocks.MOD_PLANKS))
                        .offerTo(exporter);
                ShapedRecipeJsonBuilder.create(registryLookup, RecipeCategory.REDSTONE, ModBlocks.MOD_PRESSURE_PLATE, 1)
                        .pattern("##")
                        .input('#', ModBlocks.MOD_PLANKS)
                        .group("wooden_pressure_plate")
                        .criterion("has_planks", conditionsFromItem(ModBlocks.MOD_PLANKS))
                        .offerTo(exporter);
                ShapedRecipeJsonBuilder.create(registryLookup, RecipeCategory.DECORATIONS, ModBlocks.MOD_FENCE, 3)
                        .pattern("W#W")
                        .pattern("W#W")
                        .input('#', Items.STICK)
                        .input('W', ModBlocks.MOD_PLANKS)
                        .group("wooden_fence")
                        .criterion("has_planks", conditionsFromItem(ModBlocks.MOD_PLANKS))
                        .offerTo(exporter);
                ShapedRecipeJsonBuilder.create(registryLookup, RecipeCategory.REDSTONE, ModBlocks.MOD_FENCE_GATE, 1)
                        .pattern("#W#")
                        .pattern("#W#")
                        .input('#', Items.STICK)
                        .input('W', ModBlocks.MOD_PLANKS)
                        .group("wooden_fence_gate")
                        .criterion("has_planks", conditionsFromItem(ModBlocks.MOD_PLANKS))
                        .offerTo(exporter);
                ShapedRecipeJsonBuilder.create(registryLookup, RecipeCategory.REDSTONE, ModBlocks.MOD_DOOR, 3)
                        .pattern("##")
                        .pattern("##")
                        .pattern("##")
                        .input('#', ModBlocks.MOD_PLANKS)
                        .group("wooden_door")
                        .criterion("has_planks", conditionsFromItem(ModBlocks.MOD_PLANKS))
                        .offerTo(exporter);
                ShapedRecipeJsonBuilder.create(registryLookup, RecipeCategory.REDSTONE, ModBlocks.MOD_TRAPDOOR, 2)
                        .pattern("###")
                        .pattern("###")
                        .input('#', ModBlocks.MOD_PLANKS)
                        .group("wooden_trapdoor")
                        .criterion("has_planks", conditionsFromItem(ModBlocks.MOD_PLANKS))
                        .offerTo(exporter);
                ShapedRecipeJsonBuilder.create(registryLookup, RecipeCategory.DECORATIONS, ModItems.MOD_SIGN, 3)
                        .pattern("###")
                        .pattern("###")
                        .pattern(" X ")
                        .input('#', ModBlocks.MOD_PLANKS)
                        .input('X', Items.STICK)
                        .group("wooden_sign")
                        .criterion("has_planks", conditionsFromItem(ModBlocks.MOD_PLANKS))
                        .offerTo(exporter);
                offerHangingSignRecipe(ModItems.MOD_HANGING_SIGN, ModBlocks.STRIPPED_MOD_LOG);
                offerBoatRecipe(ModBoats.MOD_BOAT, ModBlocks.MOD_PLANKS);
                offerChestBoatRecipe(ModBoats.MOD_CHEST_BOAT, ModBoats.MOD_BOAT);

            }
        };
    }

    @Override
    public String getName() {
        return StandardWoodInitializer.WOOD_TYPE + " wood recipes";
    }
}