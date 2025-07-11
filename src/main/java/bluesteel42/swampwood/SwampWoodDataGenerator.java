package bluesteel42.swampwood;

import bluesteel42.swampwood.datagen.ModRegistryDataGenerator;
import bluesteel42.standard_wood_initializer.datagen.ModBlockTagProvider;
import bluesteel42.standard_wood_initializer.datagen.ModItemTagProvider;
import bluesteel42.standard_wood_initializer.datagen.ModLootTableProvider;
import bluesteel42.standard_wood_initializer.datagen.ModModelProvider;
import bluesteel42.standard_wood_initializer.datagen.ModRecipeProvider;
import bluesteel42.swampwood.world.ModConfiguredFeatures;
import bluesteel42.swampwood.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class SwampWoodDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		// Standard Wood Package
		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		// Mod Datagen
		pack.addProvider(ModRegistryDataGenerator::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
	}
}
