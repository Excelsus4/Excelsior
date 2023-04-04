package com.excelsus.excelsior.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import com.excelsus.excelsior.Excelsior;
import com.excelsus.excelsior.data.recipe.ExcelsiorRecipeProvider;
import com.excelsus.excelsior.data.recipe.StandardRecipeGen;
//
// @Mod.EventBusSubscriber(modid = Excelsior.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
// public class DataGenerators {
// 	@SubscribeEvent
// 	public static void gatherData(GatherDataEvent event) {
// 		DataGenerator generator = event.getGenerator();
// 		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
//
// 		generator.addProvider(true, new StandardRecipeGen(generator));
// 	}
// }
