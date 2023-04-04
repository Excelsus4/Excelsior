package com.excelsus.excelsior.data.recipe;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluids;

import com.excelsus.excelsior.content.ExcelsiorItems;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.contraptions.processing.HeatCondition;
import com.simibubi.create.foundation.utility.recipe.IRecipeTypeInfo;

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
			.requiresHeat(HeatCondition.HEATED))
		;

	public ExcelsiorMixingRecipeGen(DataGenerator generator) {
		super(generator);
	}

	@Override
	protected IRecipeTypeInfo getRecipeType() {
		return AllRecipeTypes.MIXING;
	}
}
