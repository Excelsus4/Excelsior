package com.excelsus.excelsior.data.recipe;

import net.minecraft.data.DataGenerator;

import com.excelsus.excelsior.content.ExcelsiorItems;
import com.excelsus.excelsior.content.ExcelsiorRecipeTypes;
import com.simibubi.create.AllItems;
import com.simibubi.create.foundation.utility.recipe.IRecipeTypeInfo;

public class ExcelsiorCentrifugingRecipeGen extends ExcelsiorProcessingRecipeGen {
	GeneratedRecipe
		CRUSHED_URANIUM = create(AllItems.CRUSHED_URANIUM::get, b -> b.duration(200)
		.output(ExcelsiorItems.LOW_ENRICHED_URANIUM_INGOT.get()));

	public ExcelsiorCentrifugingRecipeGen(DataGenerator generator) {
		super(generator);
	}

	@Override
	protected IRecipeTypeInfo getRecipeType() {
		return ExcelsiorRecipeTypes.CENTRIFUGING;
	}
}
