package com.excelsus.excelsior.content.worldgen;

import java.util.List;
import java.util.function.Supplier;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import com.excelsus.excelsior.Excelsior;
import com.excelsus.excelsior.content.ExcelsiorBlocks;
import com.google.common.base.Suppliers;

public class ExcelsiorConfiguredFeatures {
	public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURE =
		DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Excelsior.ID);

	public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_CHROMITE_ORES = Suppliers.memoize(() -> List.of(
		OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ExcelsiorBlocks.CHROMITE_ORE.get().defaultBlockState()),
		OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ExcelsiorBlocks.DEEPSLATE_CHROMITE_ORE.get().defaultBlockState())));

	public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_URANIUM_ORES = Suppliers.memoize(() -> List.of(
		OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ExcelsiorBlocks.URANIUM_ORE.get().defaultBlockState()),
		OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ExcelsiorBlocks.DEEPSLATE_URANIUM_ORE.get().defaultBlockState())));

	public static final RegistryObject<ConfiguredFeature<?, ?>> CHROMITE_ORE = CONFIGURED_FEATURE.register("chromite_ore",
		() -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_CHROMITE_ORES.get(), 30)));

	public static final RegistryObject<ConfiguredFeature<?, ?>> URANIUM_ORE = CONFIGURED_FEATURE.register("uranium_ore",
		() -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_URANIUM_ORES.get(), 30)));

	public static void register(IEventBus eventBus) {
		CONFIGURED_FEATURE.register(eventBus);
	}

}
