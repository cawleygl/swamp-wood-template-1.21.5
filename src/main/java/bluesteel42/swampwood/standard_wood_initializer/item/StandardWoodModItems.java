package bluesteel42.swampwood.standard_wood_initializer.item;

import bluesteel42.swampwood.standard_wood_initializer.StandardWoodInitializer;
import bluesteel42.swampwood.standard_wood_initializer.block.StandardWoodModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class StandardWoodModItems {
    public static final Item MOD_SIGN = registerSignItem(StandardWoodInitializer.WOOD_TYPE + "_sign");
    public static final Item MOD_HANGING_SIGN = registerHangingSignItem(StandardWoodInitializer.WOOD_TYPE + "_hanging_sign");

    public static Item registerSignItem(String path) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(StandardWoodInitializer.MOD_ID, path));
        final Item item = new SignItem(
                StandardWoodModBlocks.MOD_STANDING_SIGN,
                StandardWoodModBlocks.MOD_WALL_SIGN,
                new Item.Settings().registryKey(registryKey).maxCount(16));

        return Registry.register(Registries.ITEM, registryKey.getValue(), item);
    }

    public static Item registerHangingSignItem(String path) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(StandardWoodInitializer.MOD_ID, path));
        final Item item = new HangingSignItem(
                StandardWoodModBlocks.MOD_HANGING_SIGN,
                StandardWoodModBlocks.MOD_WALL_HANGING_SIGN,
                new Item.Settings().registryKey(registryKey).maxCount(16));

        return Registry.register(Registries.ITEM, registryKey.getValue(), item);
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.PALE_OAK_HANGING_SIGN, StandardWoodModItems.MOD_HANGING_SIGN);
                    itemGroup.addAfter(Items.PALE_OAK_HANGING_SIGN, StandardWoodModItems.MOD_SIGN);
                });

    }
}
