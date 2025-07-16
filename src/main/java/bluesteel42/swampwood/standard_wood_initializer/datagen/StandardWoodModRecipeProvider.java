package bluesteel42.swampwood.standard_wood_initializer.datagen;

import bluesteel42.swampwood.standard_wood_initializer.StandardWoodInitializer;
import bluesteel42.swampwood.standard_wood_initializer.block.StandardWoodModBlocks;
import bluesteel42.swampwood.standard_wood_initializer.entity.StandardWoodModBoats;
import bluesteel42.swampwood.standard_wood_initializer.item.StandardWoodModItems;
import bluesteel42.swampwood.standard_wood_initializer.util.StandardWoodModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class StandardWoodModRecipeProvider extends FabricRecipeProvider {

    public StandardWoodModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            public void generateStandardWoodRecipes() {
                offerBarkBlockRecipe(StandardWoodModBlocks.MOD_WOOD, StandardWoodModBlocks.MOD_LOG);
                offerBarkBlockRecipe(StandardWoodModBlocks.STRIPPED_MOD_WOOD, StandardWoodModBlocks.STRIPPED_MOD_LOG);
                offerPlanksRecipe(StandardWoodModBlocks.MOD_PLANKS, StandardWoodModTags.Items.MOD_LOGS, 4);
                createShaped(RecipeCategory.BUILDING_BLOCKS, StandardWoodModBlocks.MOD_STAIRS, 4)
                        .pattern("#  ")
                        .pattern("## ")
                        .pattern("###")
                        .input('#', StandardWoodModBlocks.MOD_PLANKS)
                        .group("wooden_stairs")
                        .criterion("has_planks", conditionsFromItem(StandardWoodModBlocks.MOD_PLANKS))
                        .offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, StandardWoodModBlocks.MOD_SLAB, 6)
                        .pattern("###")
                        .input('#', StandardWoodModBlocks.MOD_PLANKS)
                        .group("wooden_slab")
                        .criterion("has_planks", conditionsFromItem(StandardWoodModBlocks.MOD_PLANKS))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.REDSTONE, StandardWoodModBlocks.MOD_BUTTON, 1)
                        .input(StandardWoodModBlocks.MOD_PLANKS)
                        .group("wooden_button")
                        .criterion("has_planks", conditionsFromItem(StandardWoodModBlocks.MOD_PLANKS))
                        .offerTo(exporter);
                createShaped(RecipeCategory.REDSTONE, StandardWoodModBlocks.MOD_PRESSURE_PLATE, 1)
                        .pattern("##")
                        .input('#', StandardWoodModBlocks.MOD_PLANKS)
                        .group("wooden_pressure_plate")
                        .criterion("has_planks", conditionsFromItem(StandardWoodModBlocks.MOD_PLANKS))
                        .offerTo(exporter);
                createShaped(RecipeCategory.DECORATIONS, StandardWoodModBlocks.MOD_FENCE, 3)
                        .pattern("W#W")
                        .pattern("W#W")
                        .input('#', Items.STICK)
                        .input('W', StandardWoodModBlocks.MOD_PLANKS)
                        .group("wooden_fence")
                        .criterion("has_planks", conditionsFromItem(StandardWoodModBlocks.MOD_PLANKS))
                        .offerTo(exporter);
                createShaped(RecipeCategory.REDSTONE, StandardWoodModBlocks.MOD_FENCE_GATE, 1)
                        .pattern("#W#")
                        .pattern("#W#")
                        .input('#', Items.STICK)
                        .input('W', StandardWoodModBlocks.MOD_PLANKS)
                        .group("wooden_fence_gate")
                        .criterion("has_planks", conditionsFromItem(StandardWoodModBlocks.MOD_PLANKS))
                        .offerTo(exporter);
                createShaped(RecipeCategory.REDSTONE, StandardWoodModBlocks.MOD_DOOR, 3)
                        .pattern("##")
                        .pattern("##")
                        .pattern("##")
                        .input('#', StandardWoodModBlocks.MOD_PLANKS)
                        .group("wooden_door")
                        .criterion("has_planks", conditionsFromItem(StandardWoodModBlocks.MOD_PLANKS))
                        .offerTo(exporter);
                createShaped(RecipeCategory.REDSTONE, StandardWoodModBlocks.MOD_TRAPDOOR, 2)
                        .pattern("###")
                        .pattern("###")
                        .input('#', StandardWoodModBlocks.MOD_PLANKS)
                        .group("wooden_trapdoor")
                        .criterion("has_planks", conditionsFromItem(StandardWoodModBlocks.MOD_PLANKS))
                        .offerTo(exporter);
                createShaped(RecipeCategory.DECORATIONS, StandardWoodModItems.MOD_SIGN, 3)
                        .pattern("###")
                        .pattern("###")
                        .pattern(" X ")
                        .input('#', StandardWoodModBlocks.MOD_PLANKS)
                        .input('X', Items.STICK)
                        .group("wooden_sign")
                        .criterion("has_planks", conditionsFromItem(StandardWoodModBlocks.MOD_PLANKS))
                        .offerTo(exporter);
                offerHangingSignRecipe(StandardWoodModItems.MOD_HANGING_SIGN, StandardWoodModBlocks.STRIPPED_MOD_LOG);
                offerBoatRecipe(StandardWoodModBoats.MOD_BOAT, StandardWoodModBlocks.MOD_PLANKS);
                offerChestBoatRecipe(StandardWoodModBoats.MOD_CHEST_BOAT, StandardWoodModBoats.MOD_BOAT);
            }

            @Override
            public void generate() {
                generateStandardWoodRecipes();
            }
        };
    }

    @Override
    public String getName() {
        return StandardWoodInitializer.WOOD_TYPE + " wood recipes";
    }
}