package com.excelsus.excelsior.content.recipe;

import net.minecraft.data.DataGenerator;

import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.foundation.utility.recipe.IRecipeTypeInfo;

public class ExcelsiorItemApplicationRecipeGen extends ExcelsiorProcessingRecipeGen {
	GeneratedRecipe
	STAINLESS = create("stainless_casing", b -> b.require(I.brassCasing())
		.require(I.stainlessSheet())
		.output(I.stainlessCasing()));

	public ExcelsiorItemApplicationRecipeGen(DataGenerator generator) {
		super(generator);
	}

	@Override
	protected IRecipeTypeInfo getRecipeType() {
		return AllRecipeTypes.ITEM_APPLICATION;
	}
}
