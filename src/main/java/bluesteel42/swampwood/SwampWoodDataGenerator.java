package bluesteel42.swampwood;

import bluesteel42.swampwood.datagen.ModRegistryDataGenerator;
import bluesteel42.swampwood.standard_wood_initializer.datagen.*;
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
		pack.addProvider(StandardWoodModBlockTagProvider::new);
		pack.addProvider(StandardWoodModItemTagProvider::new);
		pack.addProvider(StandardWoodModLootTableProvider::new);
		pack.addProvider(StandardWoodModModelProvider::new);
		pack.addProvider(StandardWoodModRecipeProvider::new);
		// Mod Datagen
		pack.addProvider(ModRegistryDataGenerator::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
	}
}
