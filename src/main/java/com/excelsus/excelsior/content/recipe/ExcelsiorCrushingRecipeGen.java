package com.excelsus.excelsior.content.recipe;

import net.minecraft.data.DataGenerator;

import com.excelsus.excelsior.content.ExcelsiorItems;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.foundation.utility.recipe.IRecipeTypeInfo;

public class ExcelsiorCrushingRecipeGen extends ExcelsiorProcessingRecipeGen {
	GeneratedRecipe
	DRY_CASTOR_SEEDS = create(ExcelsiorItems.DRY_CASTOR_SEEDS::get, b -> b.duration(100)
		.output(ExcelsiorItems.CRUSHED_CASTOR_SEEDS.get()));

	public ExcelsiorCrushingRecipeGen(DataGenerator generator) {
		super(generator);
	}

	@Override
	protected IRecipeTypeInfo getRecipeType() {
		return AllRecipeTypes.CRUSHING;
	}
}
