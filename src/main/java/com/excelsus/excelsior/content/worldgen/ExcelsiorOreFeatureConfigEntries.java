package com.excelsus.excelsior.content.worldgen;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.registries.ForgeRegistries;

import com.excelsus.excelsior.Excelsior;
import com.excelsus.excelsior.content.ExcelsiorBlocks;
import com.simibubi.create.foundation.data.DynamicDataProvider;
import com.simibubi.create.foundation.worldgen.OreFeatureConfigEntry;

public class ExcelsiorOreFeatureConfigEntries {
	public static final OreFeatureConfigEntry
		CHROME_ORE = create("chrome_ore", 12, 8, -63, 70)
			.standardDatagenExt()
			.withBlock(ExcelsiorBlocks.CHROME_ORE)
			.biomeTag(BiomeTags.IS_OVERWORLD)
			.parent(),

		URANIUM_ORE = create("uranium_ore", 12, 8, -63, 70)
			.standardDatagenExt()
			.withBlock(ExcelsiorBlocks.URANIUM_ORE)
			.biomeTag(BiomeTags.IS_OVERWORLD)
			.parent();

	private static OreFeatureConfigEntry create(String name, int clusterSize, float frequency,
		int minHeight, int maxHeight) {
		ResourceLocation id = Excelsior.asResource(name);
		OreFeatureConfigEntry configDrivenFeatureEntry = new OreFeatureConfigEntry(id, clusterSize, frequency, minHeight, maxHeight);
		return configDrivenFeatureEntry;
	}

	public static void fillConfig(ForgeConfigSpec.Builder builder, String namespace) {
		OreFeatureConfigEntry.ALL
			.forEach((id, entry) -> {
				if (id.getNamespace().equals(namespace)) {
					builder.push(entry.getName());
					entry.addToConfig(builder);
					builder.pop();
				}
			});
	}

	public static void init() {}

	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		RegistryAccess registryAccess = RegistryAccess.BUILTIN.get();

		//

		Map<ResourceLocation, ConfiguredFeature<?, ?>> configuredFeatures = new HashMap<>();
		for (Map.Entry<ResourceLocation, OreFeatureConfigEntry> entry : OreFeatureConfigEntry.ALL.entrySet()) {
			OreFeatureConfigEntry.DatagenExtension datagenExt = entry.getValue().datagenExt();
			if (datagenExt != null) {
				configuredFeatures.put(entry.getKey(), datagenExt.createConfiguredFeature(registryAccess));
			}
		}

		DynamicDataProvider<ConfiguredFeature<?, ?>> configuredFeatureProvider = DynamicDataProvider.create(generator, "Create's Configured Features", registryAccess, Registry.CONFIGURED_FEATURE_REGISTRY, configuredFeatures);
		if (configuredFeatureProvider != null) {
			generator.addProvider(true, configuredFeatureProvider);
		}

		//

		Map<ResourceLocation, PlacedFeature> placedFeatures = new HashMap<>();
		for (Map.Entry<ResourceLocation, OreFeatureConfigEntry> entry : OreFeatureConfigEntry.ALL.entrySet()) {
			OreFeatureConfigEntry.DatagenExtension datagenExt = entry.getValue().datagenExt();
			if (datagenExt != null) {
				placedFeatures.put(entry.getKey(), datagenExt.createPlacedFeature(registryAccess));
			}
		}

		DynamicDataProvider<PlacedFeature> placedFeatureProvider = DynamicDataProvider.create(generator, "Excelsior's Placed Features", registryAccess, Registry.PLACED_FEATURE_REGISTRY, placedFeatures);
		if (placedFeatureProvider != null) {
			generator.addProvider(true, placedFeatureProvider);
		}

		//

		Map<ResourceLocation, BiomeModifier> biomeModifiers = new HashMap<>();
		for (Map.Entry<ResourceLocation, OreFeatureConfigEntry> entry : OreFeatureConfigEntry.ALL.entrySet()) {
			OreFeatureConfigEntry.DatagenExtension datagenExt = entry.getValue().datagenExt();
			if (datagenExt != null) {
				biomeModifiers.put(entry.getKey(), datagenExt.createBiomeModifier(registryAccess));
			}
		}

		DynamicDataProvider<BiomeModifier> biomeModifierProvider = DynamicDataProvider.create(generator, "Excelsior's Biome Modifiers", registryAccess, ForgeRegistries.Keys.BIOME_MODIFIERS, biomeModifiers);
		if (biomeModifierProvider != null) {
			generator.addProvider(true, biomeModifierProvider);
		}
	}
}
