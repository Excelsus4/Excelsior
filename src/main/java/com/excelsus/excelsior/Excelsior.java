package com.excelsus.excelsior;

import org.slf4j.Logger;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.excelsus.excelsior.content.ExcelsiorBlocks;
import com.excelsus.excelsior.content.ExcelsiorFluids;
import com.excelsus.excelsior.content.ExcelsiorItemGroup;
import com.excelsus.excelsior.content.ExcelsiorItems;
import com.excelsus.excelsior.content.ExcelsiorTileEntities;
import com.excelsus.excelsior.content.recipe.ExcelsiorMechanicalCraftingRecipeGen;
import com.excelsus.excelsior.content.worldgen.ExcelsiorBuiltinRegistration;
import com.excelsus.excelsior.content.worldgen.ExcelsiorOreFeatureConfigEntries;
import com.excelsus.excelsior.content.recipe.ExcelsiorProcessingRecipeGen;
import com.excelsus.excelsior.content.recipe.ExcelsiorStandardRecipeGen;
import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.data.CreateRegistrate;

@Mod(Excelsior.ID)
public class Excelsior {
	public static final String ID = "excelsior";
	public static final String NAME = "Excelsior";
	public static final Logger LOGGER = LogUtils.getLogger();
	public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(ID);
	public static final CreativeModeTab EXCELSIOR_CREATIVE_TAB = new ExcelsiorItemGroup();

	public Excelsior() {
		onCtor();
	}

	public void onCtor() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		REGISTRATE.registerEventListeners(modEventBus);

		ExcelsiorBlocks.register();
		ExcelsiorItems.register();
		ExcelsiorTileEntities.register();
		ExcelsiorFluids.register();
		ExcelsiorOreFeatureConfigEntries.init();
		ExcelsiorBuiltinRegistration.register(modEventBus);

		modEventBus.addListener(EventPriority.LOWEST, Excelsior::gatherData);

		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void init(final FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			ExcelsiorFluids.registerFluidInteractions();
		});
	}

	public static void gatherData(GatherDataEvent event) {
		DataGenerator gen = event.getGenerator();
		if (event.includeServer()) {
			gen.addProvider(true, new ExcelsiorStandardRecipeGen(gen));
			gen.addProvider(true, new ExcelsiorMechanicalCraftingRecipeGen(gen));
			ExcelsiorProcessingRecipeGen.registerAll(gen);
		}
	}

	public static ResourceLocation asResource(String path) {
		return new ResourceLocation(ID, path);
	}
}
