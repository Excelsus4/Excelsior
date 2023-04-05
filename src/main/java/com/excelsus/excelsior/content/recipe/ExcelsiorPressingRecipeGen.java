package com.excelsus.excelsior.content.recipe;

import net.minecraft.data.DataGenerator;

import com.excelsus.excelsior.content.ExcelsiorItems;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.foundation.utility.recipe.IRecipeTypeInfo;

public class ExcelsiorPressingRecipeGen extends ExcelsiorProcessingRecipeGen {
	GeneratedRecipe
	FISH_CAKE_RAW = create("fish_cake_raw",
		ExcelsiorItems.FISH_DOUGH::get,
		b -> b.output(ExcelsiorItems.FISH_CAKE_RAW.get())),
		STAINLESS_SHEET = create("stainless_sheet",
			b -> b.require(I.stainlessIngot())
			.output(ExcelsiorItems.STAINLESS_SHEET.get()))
		;

	public ExcelsiorPressingRecipeGen(DataGenerator generator) {
		super(generator);
	}

	@Override
	protected IRecipeTypeInfo getRecipeType() {
		return AllRecipeTypes.PRESSING;
	}
}
