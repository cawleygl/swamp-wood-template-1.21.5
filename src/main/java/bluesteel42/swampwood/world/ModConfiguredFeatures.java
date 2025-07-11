package bluesteel42.swampwood.world;

import bluesteel42.swampwood.SwampWood;
import bluesteel42.standard_wood_initializer.block.ModBlocks;
import bluesteel42.swampwood.world.tree.SwampTrunkPlacer;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.Pool;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.treedecorator.AttachedToLogsTreeDecorator;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.PlaceOnGroundTreeDecorator;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> SWAMP_TREE_LEAF_LITTER_KEY = registerKey("swamp_tree_leaf_litter");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SWAMP_WILLOW_KEY = registerKey("swamp_willow");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_SWAMP_TREE_KEY = registerKey("fallen_swamp_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TREES_SWAMP_KEY = registerKey("trees_swamp");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> registryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        PlaceOnGroundTreeDecorator placeOnGroundTreeDecorator = new PlaceOnGroundTreeDecorator(
                96, 4, 2, new WeightedBlockStateProvider(VegetationConfiguredFeatures.leafLitter(1, 3))
        );
        PlaceOnGroundTreeDecorator placeOnGroundTreeDecorator2 = new PlaceOnGroundTreeDecorator(
                150, 2, 2, new WeightedBlockStateProvider(VegetationConfiguredFeatures.leafLitter(1, 4))
        );
        register(context, SWAMP_TREE_LEAF_LITTER_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.MOD_LOG),
                new StraightTrunkPlacer(5, 3, 0),
                BlockStateProvider.of(ModBlocks.MOD_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)
        ).decorators(ImmutableList.of(new LeavesVineTreeDecorator(0.25F), placeOnGroundTreeDecorator, placeOnGroundTreeDecorator2)).build());


        register(context, SWAMP_WILLOW_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.MOD_LOG),
                new SwampTrunkPlacer(6, 3, 2, UniformIntProvider.create(2, 4), UniformIntProvider.create(7, 9), UniformIntProvider.create(3, 5), UniformIntProvider.create(3, 4), UniformIntProvider.create(2, 4)),
                BlockStateProvider.of(ModBlocks.MOD_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),
                new TwoLayersFeatureSize(1, 0, 1)
        )
                .decorators(ImmutableList.of(new LeavesVineTreeDecorator(0.7F)))
                .build());

        register(context, FALLEN_SWAMP_TREE_KEY, Feature.FALLEN_TREE, new FallenTreeFeatureConfig.Builder(BlockStateProvider.of(ModBlocks.MOD_LOG), UniformIntProvider.create(5, 8))
                .logDecorators(
                        ImmutableList.of(
                                new AttachedToLogsTreeDecorator(
                                        0.5F,
                                        new WeightedBlockStateProvider(Pool.<BlockState>builder().add(Blocks.RED_MUSHROOM.getDefaultState(), 1).add(Blocks.BROWN_MUSHROOM.getDefaultState(), 2)),
                                        List.of(Direction.UP)
                                )
                        )
                ).build());

        register(context, TREES_SWAMP_KEY, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
            new RandomFeatureEntry(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(ModPlacedFeatures.SWAMP_WILLOW_PLACED_KEY), 0.1F),
            new RandomFeatureEntry(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(ModPlacedFeatures.HUGE_RED_MUSHROOM_PLACED_KEY), 0.05F),
            new RandomFeatureEntry(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(ModPlacedFeatures.HUGE_BROWN_MUSHROOM_PLACED_KEY), 0.05F),
            new RandomFeatureEntry(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(ModPlacedFeatures.FALLEN_SWAMP_TREE_PLACED_KEY), 0.0125F)
        ), context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(ModPlacedFeatures.SWAMP_TREE_PLACED_KEY)
        ));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(SwampWood.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration ) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
