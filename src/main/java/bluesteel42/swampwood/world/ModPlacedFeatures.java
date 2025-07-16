package bluesteel42.swampwood.world;

import bluesteel42.swampwood.SwampWood;
import bluesteel42.swampwood.standard_wood_initializer.block.StandardWoodModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> SWAMP_TREE_PLACED_KEY = registerKey("swamp_tree");
    public static final RegistryKey<PlacedFeature> SWAMP_TREE_LEAF_LITTER_PLACED_KEY = registerKey("swamp_tree_leaf_litter");
    public static final RegistryKey<PlacedFeature> SWAMP_WILLOW_PLACED_KEY = registerKey("swamp_willow");
    public static final RegistryKey<PlacedFeature> HUGE_RED_MUSHROOM_PLACED_KEY = registerKey("swamp_huge_red_mushroom");
    public static final RegistryKey<PlacedFeature> HUGE_BROWN_MUSHROOM_PLACED_KEY = registerKey("swamp_huge_brown_mushroom");
    public static final RegistryKey<PlacedFeature> FALLEN_SWAMP_TREE_PLACED_KEY = registerKey("fallen_swamp_tree");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, SWAMP_TREE_PLACED_KEY, configuredFeatures.getOrThrow(TreeConfiguredFeatures.SWAMP_OAK),
                List.of(PlacedFeatures.wouldSurvive(StandardWoodModBlocks.MOD_SAPLING))
        );
        register(context, SWAMP_TREE_LEAF_LITTER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SWAMP_TREE_LEAF_LITTER_KEY),
                List.of(PlacedFeatures.wouldSurvive(StandardWoodModBlocks.MOD_SAPLING))
        );
        register(context, SWAMP_WILLOW_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SWAMP_WILLOW_KEY),
                List.of(PlacedFeatures.wouldSurvive(StandardWoodModBlocks.MOD_SAPLING))
        );
        register(context, HUGE_RED_MUSHROOM_PLACED_KEY, configuredFeatures.getOrThrow(TreeConfiguredFeatures.HUGE_RED_MUSHROOM),
                List.of(PlacedFeatures.wouldSurvive(StandardWoodModBlocks.MOD_SAPLING))
        );
        register(context, HUGE_BROWN_MUSHROOM_PLACED_KEY, configuredFeatures.getOrThrow(TreeConfiguredFeatures.HUGE_BROWN_MUSHROOM),
                List.of(PlacedFeatures.wouldSurvive(StandardWoodModBlocks.MOD_SAPLING))
        );
        register(context, FALLEN_SWAMP_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FALLEN_SWAMP_TREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(StandardWoodModBlocks.MOD_SAPLING))
        );

    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(SwampWood.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
