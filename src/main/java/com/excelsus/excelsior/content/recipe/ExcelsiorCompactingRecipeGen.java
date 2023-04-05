package com.excelsus.excelsior.content.recipe;

import net.minecraft.data.DataGenerator;

import com.excelsus.excelsior.content.ExcelsiorItems;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.contraptions.processing.HeatCondition;
import com.simibubi.create.foundation.utility.recipe.IRecipeTypeInfo;

import mezz.jei.api.recipe.RecipeType;

public class ExcelsiorCompactingRecipeGen extends ExcelsiorProcessingRecipeGen {
	GeneratedRecipe
	OIL_CAKE_FERTILIZER = create("oil_cake_fertilizer",
		b -> b.require(ExcelsiorItems.CASTOR_OIL_CAKE.get())
			.require(ExcelsiorItems.CASTOR_OIL_CAKE.get())
			.require(ExcelsiorItems.CASTOR_OIL_CAKE.get())
			.require(ExcelsiorItems.CASTOR_OIL_CAKE.get())
			.output(ExcelsiorItems.OIL_CAKE_FERTILIZER.get(), 3)
			.requiresHeat(HeatCondition.HEATED));

	public ExcelsiorCompactingRecipeGen(DataGenerator generator) {
		super(generator);
	}

	@Override
	protected IRecipeTypeInfo getRecipeType() {
		return AllRecipeTypes.COMPACTING;
	}
}
