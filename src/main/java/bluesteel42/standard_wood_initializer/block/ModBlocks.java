package bluesteel42.standard_wood_initializer.block;

import bluesteel42.standard_wood_initializer.StandardWoodInitializer;
import bluesteel42.standard_wood_initializer.tree.ModSaplingGenerators;
import com.terraformersmc.terraform.sign.api.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallSignBlock;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {
    public static final Block MOD_LOG = register(StandardWoodInitializer.WOOD_TYPE + "_log", PillarBlock::new, Blocks.createLogSettings(StandardWoodInitializer.FIBER_COLOR, StandardWoodInitializer.BARK_COLOR, BlockSoundGroup.WOOD), true, false);
    public static final Block MOD_WOOD = register(StandardWoodInitializer.WOOD_TYPE + "_wood", PillarBlock::new, Blocks.createLogSettings(StandardWoodInitializer.BARK_COLOR, StandardWoodInitializer.BARK_COLOR, BlockSoundGroup.WOOD), true, false);
    public static final Block STRIPPED_MOD_LOG = register("stripped_" + StandardWoodInitializer.WOOD_TYPE + "_log", PillarBlock::new, Blocks.createLogSettings(StandardWoodInitializer.FIBER_COLOR, StandardWoodInitializer.FIBER_COLOR, BlockSoundGroup.WOOD), true, false);
    public static final Block STRIPPED_MOD_WOOD = register("stripped_" + StandardWoodInitializer.WOOD_TYPE + "_wood", PillarBlock::new, Blocks.createLogSettings(StandardWoodInitializer.FIBER_COLOR, StandardWoodInitializer.FIBER_COLOR, BlockSoundGroup.WOOD), true, false);
    public static final Block MOD_PLANKS = register(
            StandardWoodInitializer.WOOD_TYPE + "_planks",
            Block::new,
            AbstractBlock.Settings.create()
                    .mapColor(StandardWoodInitializer.FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_STAIRS = register(
            StandardWoodInitializer.WOOD_TYPE + "_stairs",
            settings -> new StairsBlock(MOD_PLANKS.getDefaultState(), settings),
            AbstractBlock.Settings.copy(MOD_PLANKS),
            true,
            false
    );
    public static final Block MOD_SLAB = register(
            StandardWoodInitializer.WOOD_TYPE + "_slab",
            SlabBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(StandardWoodInitializer.FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_BUTTON = register(
            StandardWoodInitializer.WOOD_TYPE + "_button",
            settings -> new ButtonBlock(BlockSetType.OAK, 30, settings),
            AbstractBlock.Settings.create()
                    .noCollision()
                    .strength(0.5F)
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            false
    );
    public static final Block MOD_PRESSURE_PLATE = register(
            StandardWoodInitializer.WOOD_TYPE + "_pressure_plate",
            settings -> new PressurePlateBlock(BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(StandardWoodInitializer.FIBER_COLOR)
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollision()
                    .strength(0.5F)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            false
    );
    public static final Block MOD_FENCE = register(
            StandardWoodInitializer.WOOD_TYPE + "_fence",
            FenceBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(StandardWoodInitializer.FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_FENCE_GATE = register(
            StandardWoodInitializer.WOOD_TYPE + "_fence_gate",
            settings -> new FenceGateBlock(WoodType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(StandardWoodInitializer.FIBER_COLOR)
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_DOOR = register(
            StandardWoodInitializer.WOOD_TYPE + "_door",
            settings -> new DoorBlock(BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(StandardWoodInitializer.FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
                    .nonOpaque()
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            true
    );
    public static final Block MOD_TRAPDOOR = register(
            StandardWoodInitializer.WOOD_TYPE + "_trapdoor",
            settings -> new TrapdoorBlock(BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(StandardWoodInitializer.FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
                    .nonOpaque()
                    .allowsSpawning(Blocks::never)
                    .burnable(),
            true,
            true
    );
    public static final Identifier MOD_SIGN_TEXTURE = Identifier.of(StandardWoodInitializer.MOD_ID, "entity/signs/" + StandardWoodInitializer.WOOD_TYPE);
    public static final Identifier MOD_HANGING_SIGN_TEXTURE = Identifier.of(StandardWoodInitializer.MOD_ID, "entity/signs/hanging/" + StandardWoodInitializer.WOOD_TYPE);
    public static final Identifier MOD_HANGING_GUI_SIGN_TEXTURE = Identifier.of(StandardWoodInitializer.MOD_ID, "textures/gui/hanging_signs/" + StandardWoodInitializer.WOOD_TYPE);
    public static final Block MOD_STANDING_SIGN = register(
            StandardWoodInitializer.WOOD_TYPE + "_standing_sign",
            settings -> new TerraformSignBlock(MOD_SIGN_TEXTURE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_SIGN).mapColor(StandardWoodInitializer.FIBER_COLOR),
            false,
            false
    );

    public static final Block MOD_WALL_SIGN = register(
            StandardWoodInitializer.WOOD_TYPE + "_wall_sign",
            settings -> new TerraformWallSignBlock(MOD_SIGN_TEXTURE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_SIGN).mapColor(StandardWoodInitializer.FIBER_COLOR).lootTable(MOD_STANDING_SIGN.getLootTableKey()).overrideTranslationKey(MOD_STANDING_SIGN.getTranslationKey()),
            false,
            false
    );

    public static final Block MOD_HANGING_SIGN = register(
            StandardWoodInitializer.WOOD_TYPE + "_hanging_sign",
            settings -> new TerraformHangingSignBlock(MOD_HANGING_SIGN_TEXTURE, MOD_HANGING_GUI_SIGN_TEXTURE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN).mapColor(StandardWoodInitializer.FIBER_COLOR),
            false,
            false
    );

    public static final Block MOD_WALL_HANGING_SIGN = register(
            StandardWoodInitializer.WOOD_TYPE + "_hanging_wall_sign",
            settings -> new TerraformWallHangingSignBlock(MOD_HANGING_SIGN_TEXTURE, MOD_HANGING_GUI_SIGN_TEXTURE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN).mapColor(StandardWoodInitializer.FIBER_COLOR).lootTable(MOD_HANGING_SIGN.getLootTableKey()).overrideTranslationKey(MOD_HANGING_SIGN.getTranslationKey()),
            false,
            false
    );

    public static final BlockFamily MOD_SIGN_FAMILY = BlockFamilies.register(ModBlocks.MOD_PLANKS)
            .sign(ModBlocks.MOD_STANDING_SIGN, ModBlocks.MOD_WALL_SIGN)
            .group("wooden").unlockCriterionName("has_planks").build();

    public static final Block MOD_LEAVES = register(
            StandardWoodInitializer.WOOD_TYPE + "_leaves",
            settings -> new TintedParticleLeavesBlock(0.01F, settings),
            Blocks.createLeavesSettings(BlockSoundGroup.GRASS),
            true,
            true
    );
    public static final Block MOD_SAPLING = register(
            StandardWoodInitializer.WOOD_TYPE + "_sapling",
            settings -> new SaplingBlock(ModSaplingGenerators.MOD_SAPLING_GENERATOR, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_SAPLING),
            true,
            true
    );
    public static final Block POTTED_MOD_SAPLING = register(
            "potted_" + StandardWoodInitializer.WOOD_TYPE + "_sapling",
            settings -> new FlowerPotBlock(MOD_SAPLING, settings),
            Blocks.createFlowerPotSettings(),
            true,
            true
    );

    private static Block register(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings, boolean registerItem, boolean nonOpaqueBlock) {
        final Identifier identifier = Identifier.of(StandardWoodInitializer.MOD_ID, path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);

        final Block block = Blocks.register(registryKey, factory, settings);

        if (registerItem) {
            Items.register(block);
        }

        if (nonOpaqueBlock) {
            BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
        }

        return block;
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.MOD_BUTTON);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.MOD_PRESSURE_PLATE);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.MOD_TRAPDOOR);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.MOD_DOOR);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.MOD_FENCE_GATE);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.MOD_FENCE);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.MOD_SLAB);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.MOD_STAIRS);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.MOD_PLANKS);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.STRIPPED_MOD_WOOD);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.STRIPPED_MOD_LOG);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.MOD_WOOD);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.MOD_LOG);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.PALE_OAK_LOG, ModBlocks.MOD_LOG);
                    itemGroup.addAfter(Items.PALE_OAK_LEAVES, ModBlocks.MOD_LEAVES);
                    itemGroup.addAfter(Items.PALE_OAK_SAPLING, ModBlocks.MOD_SAPLING);
                });
    }
}
