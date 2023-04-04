package com.excelsus.excelsior.data.recipe;

import net.minecraft.data.DataGenerator;

import com.excelsus.excelsior.content.ExcelsiorItems;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.foundation.utility.recipe.IRecipeTypeInfo;

public class ExcelsiorPressingRecipeGen extends ExcelsiorProcessingRecipeGen {
	GeneratedRecipe
	FISH_CAKE_RAW = create("fish_cake_raw",
		ExcelsiorItems.FISH_DOUGH::get,
		b -> b.output(ExcelsiorItems.FISH_CAKE_RAW.get()))
		;

	public ExcelsiorPressingRecipeGen(DataGenerator generator) {
		super(generator);
	}

	@Override
	protected IRecipeTypeInfo getRecipeType() {
		return AllRecipeTypes.PRESSING;
	}
}
