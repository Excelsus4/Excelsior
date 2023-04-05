package com.excelsus.excelsior.content.recipe;

import net.minecraft.data.DataGenerator;

import com.excelsus.excelsior.content.ExcelsiorItems;
import com.excelsus.excelsior.content.ExcelsiorRecipeTypes;
import com.simibubi.create.AllItems;
import com.simibubi.create.foundation.utility.recipe.IRecipeTypeInfo;

public class ExcelsiorCentrifugingRecipeGen extends ExcelsiorProcessingRecipeGen {
	GeneratedRecipe
		CRUSHED_URANIUM = create("crushed_uranium", b -> b.require(I.crushedUranium()).duration(10000)
			.output(ExcelsiorItems.LOW_ENRICHED_URANIUM_NUGGET.get())
			.output(ExcelsiorItems.DEPLETED_URANIUM_NUGGET.get(), 8)),
		LOW_ENRICHED_URANIUM = create("leu_ingot", b -> b.require(I.leuIngot()).duration(10000)
			.output(ExcelsiorItems.HIGH_ENRICHED_URANIUM_NUGGET.get())
			.output(ExcelsiorItems.DEPLETED_URANIUM_NUGGET.get(), 8));

	public ExcelsiorCentrifugingRecipeGen(DataGenerator generator) {
		super(generator);
	}

	@Override
	protected IRecipeTypeInfo getRecipeType() {
		return ExcelsiorRecipeTypes.CENTRIFUGING;
	}
}
