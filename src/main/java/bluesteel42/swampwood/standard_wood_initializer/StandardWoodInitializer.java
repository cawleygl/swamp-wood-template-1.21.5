package bluesteel42.swampwood.standard_wood_initializer;

import bluesteel42.swampwood.SwampWood;
import bluesteel42.swampwood.world.ModConfiguredFeatures;
import bluesteel42.swampwood.standard_wood_initializer.block.StandardWoodModBlocks;
import bluesteel42.swampwood.standard_wood_initializer.entity.StandardWoodModBoats;
import bluesteel42.swampwood.standard_wood_initializer.item.StandardWoodModItems;
import bluesteel42.swampwood.standard_wood_initializer.registries.StandardWoodModRegistries;
import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.MapColor;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.FoliageColors;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;

import java.util.Optional;

public class StandardWoodInitializer {
    /*
     * Standard Wood Type Initializer
     *  - Edits: None
     */
    public static String MOD_ID = SwampWood.MOD_ID;
    public static String WOOD_TYPE = "swamp";
    public static MapColor BARK_COLOR = MapColor.GREEN;
    public static MapColor FIBER_COLOR = MapColor.TERRACOTTA_CYAN;
    public static int LEAF_TINT_COLOR = FoliageColors.MANGROVE;

    public static float SAPLING_RARE_VARIANT_CHANCE = 0.1F;
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> SAPLING_STANDARD_TREE = Optional.of(TreeConfiguredFeatures.SWAMP_OAK);
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> SAPLING_RARE_TREE = Optional.of(ModConfiguredFeatures.SWAMP_WILLOW_KEY);
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> SAPLING_MEGA_TREE = Optional.empty();
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> SAPLING_RARE_MEGA_TREE = Optional.empty();
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> SAPLING_BEES_TREE = Optional.empty();
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> SAPLING_RARE_BEES_TREE = Optional.empty();

    public static void initalizeWoodType() {
        StandardWoodModBlocks.initialize();
        StandardWoodModItems.initialize();
        StandardWoodModBoats.initialize();
        StandardWoodModRegistries.registerStrippables();
        StandardWoodModRegistries.registerCompostables();
        StandardWoodModRegistries.registerFlammables();
        StandardWoodModRegistries.registerTrades();
    }

    public static void initializeWoodTypeClient() {
        // Register Boat Models
        TerraformBoatClientHelper.registerModelLayers(StandardWoodModBoats.MOD_BOATS_ID);

        // Color Leaves
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
            if (view == null || pos == null) {
                return LEAF_TINT_COLOR;
            }
            return BiomeColors.getFoliageColor(view, pos);
        }, StandardWoodModBlocks.MOD_LEAVES);
    }
}
