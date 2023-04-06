package com.excelsus.excelsior.content.worldgen;

import java.util.List;

import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import com.excelsus.excelsior.Excelsior;

public class ExcelsiorPlacedFeatures {
	public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
		DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Excelsior.ID);

	public static final RegistryObject<PlacedFeature> CHROMITE_ORE_PLACED = PLACED_FEATURES.register("chromite_ore_placed",
		() -> new PlacedFeature(ExcelsiorConfiguredFeatures.CHROMITE_ORE.getHolder().get(),
			commonOrePlacement(7, // VeinsPerChunk
				HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

	public static final RegistryObject<PlacedFeature> URANIUM_ORE_PLACED = PLACED_FEATURES.register("uranium_ore_placed",
		() -> new PlacedFeature(ExcelsiorConfiguredFeatures.URANIUM_ORE.getHolder().get(),
			commonOrePlacement(7, // VeinsPerChunk
				HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

	private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
		return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
	}

	private static List<PlacementModifier> commonOrePlacement(int pCount, PlacementModifier pHeightRange) {
		return orePlacement(CountPlacement.of(pCount), pHeightRange);
	}

	private static List<PlacementModifier> rareOrePlacement(int pChance, PlacementModifier pHeightRange) {
		return orePlacement(RarityFilter.onAverageOnceEvery(pChance), pHeightRange);
	}

	public static void register(IEventBus eventBus) {
		PLACED_FEATURES.register(eventBus);
	}
}
