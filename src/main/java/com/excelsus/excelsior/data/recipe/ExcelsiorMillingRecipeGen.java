package com.excelsus.excelsior.data.recipe;

import net.minecraft.data.DataGenerator;
import net.minecraft.tags.ItemTags;

import com.excelsus.excelsior.content.ExcelsiorItems;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.foundation.utility.recipe.IRecipeTypeInfo;

public class ExcelsiorMillingRecipeGen extends ExcelsiorProcessingRecipeGen{
	GeneratedRecipe
	FISH = create("fish", b -> b.duration(25)
		.require(ItemTags.FISHES)
		.output(ExcelsiorItems.FISH_POWDER.get()))
		;

	public ExcelsiorMillingRecipeGen(DataGenerator generator) {
		super(generator);
	}

	@Override
	protected IRecipeTypeInfo getRecipeType() {
		return AllRecipeTypes.MILLING;
	}
}
