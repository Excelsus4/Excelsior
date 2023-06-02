package com.excelsus.excelsior.content.recipe;

import net.minecraft.data.DataGenerator;

import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;

public class ExcelsiorCrushingRecipeGen extends ExcelsiorProcessingRecipeGen {
	GeneratedRecipe
	DRY_CASTOR_SEEDS = create("dry_castor_seeds", b -> b.require(I.dryCastorSeeds()).duration(100)
		.output(I.crushedCastorSeeds()));

	public ExcelsiorCrushingRecipeGen(DataGenerator generator) {
		super(generator);
	}

	@Override
	protected IRecipeTypeInfo getRecipeType() {
		return AllRecipeTypes.CRUSHING;
	}
}
