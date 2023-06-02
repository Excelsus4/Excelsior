package com.excelsus.excelsior.content.recipe;

import net.minecraft.data.DataGenerator;

import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;

public class ExcelsiorCompactingRecipeGen extends ExcelsiorProcessingRecipeGen {
	GeneratedRecipe
	OIL_CAKE_FERTILIZER = create("oil_cake_fertilizer",
		b -> b.require(I.castorOilCake())
			.require(I.castorOilCake())
			.require(I.castorOilCake())
			.require(I.castorOilCake())
			.output(I.oilCakeFertilizer(), 3)
			.requiresHeat(HeatCondition.HEATED));

	public ExcelsiorCompactingRecipeGen(DataGenerator generator) {
		super(generator);
	}

	@Override
	protected IRecipeTypeInfo getRecipeType() {
		return AllRecipeTypes.COMPACTING;
	}
}
