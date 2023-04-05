package com.excelsus.excelsior.content.worldgen;

import java.util.Map;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import com.excelsus.excelsior.Excelsior;
import com.simibubi.create.foundation.worldgen.OreFeatureConfigEntry;

public class ExcelsiorBuiltinRegistration {
	private static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURE_REGISTER = DeferredRegister.create(
		Registry.CONFIGURED_FEATURE_REGISTRY, Excelsior.ID);
	private static final DeferredRegister<PlacedFeature> PLACED_FEATURE_REGISTER = DeferredRegister.create(
		Registry.PLACED_FEATURE_REGISTRY, Excelsior.ID);
	private static final DeferredRegister<BiomeModifier> BIOME_MODIFIER_REGISTER = DeferredRegister.create(
		ForgeRegistries.Keys.BIOME_MODIFIERS, Excelsior.ID);

	static {
		for (Map.Entry<ResourceLocation, OreFeatureConfigEntry> entry : OreFeatureConfigEntry.ALL.entrySet()) {
			ResourceLocation id = entry.getKey();
			if (id.getNamespace().equals(Excelsior.ID)) {
				OreFeatureConfigEntry.DatagenExtension datagenExt = entry.getValue().datagenExt();
				if (datagenExt != null) {
					CONFIGURED_FEATURE_REGISTER.register(id.getPath(), () -> datagenExt.createConfiguredFeature(
						BuiltinRegistries.ACCESS));
					PLACED_FEATURE_REGISTER.register(id.getPath(), () -> datagenExt.createPlacedFeature(BuiltinRegistries.ACCESS));
					BIOME_MODIFIER_REGISTER.register(id.getPath(), () -> datagenExt.createBiomeModifier(BuiltinRegistries.ACCESS));
				}
			}
		}
	}

	public static void register(IEventBus modEventBus) {
		CONFIGURED_FEATURE_REGISTER.register(modEventBus);
		PLACED_FEATURE_REGISTER.register(modEventBus);
		BIOME_MODIFIER_REGISTER.register(modEventBus);
	}
}
