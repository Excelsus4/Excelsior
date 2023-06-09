package com.excelsus.excelsior.content.recipe;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluids;

import com.excelsus.excelsior.content.ExcelsiorFluids;
import com.excelsus.excelsior.content.ExcelsiorItems;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;

public class ExcelsiorMixingRecipeGen extends ExcelsiorProcessingRecipeGen {
	GeneratedRecipe
	FISH_DOUGH = create("fish_dough",
		b -> b.require(Fluids.WATER, 100)
		.require(ExcelsiorItems.FISH_POWDER.get())
		.output(ExcelsiorItems.FISH_DOUGH.get(), 1)),

	FISH_CAKE_SOUP = create("fish_cake_soup",
		b -> b.require(Fluids.WATER, 150)
			.require(ExcelsiorItems.FISH_CAKE.get())
			.require(Items.CARROT)
			.require(Items.BROWN_MUSHROOM)
			.require(Items.KELP)
			.output(ExcelsiorItems.FISH_CAKE_SOUP.get(), 2)
			.requiresHeat(HeatCondition.HEATED)),

	CRUDE_CASTOR_OIL = create("crude_castor_oil",
		b-> b.require(Fluids.WATER, 1000)
			.require(ExcelsiorItems.CRUSHED_CASTOR_SEEDS.get())
			.output(ExcelsiorItems.CASTOR_OIL_CAKE.get())
			.output(ExcelsiorFluids.CRUDE_CASTOR_OIL.get(), 1000)
			.requiresHeat(HeatCondition.SUPERHEATED)),

	REFINED_CASTOR_OIL = create("refined_castor_oil",
		b -> b.require(ExcelsiorFluids.CRUDE_CASTOR_OIL.get(), 1000)
			.output(ExcelsiorFluids.REFINED_CASTOR_OIL.get(), 100)
			.output(Fluids.WATER, 1000)
			.requiresHeat(HeatCondition.SUPERHEATED))
		;

	public ExcelsiorMixingRecipeGen(DataGenerator generator) {
		super(generator);
	}

	@Override
	protected IRecipeTypeInfo getRecipeType() {
		return AllRecipeTypes.MIXING;
	}
}
