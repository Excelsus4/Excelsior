package com.excelsus.excelsior.content.blocks.centrifuge;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.world.level.Level;
import net.minecraftforge.items.wrapper.RecipeWrapper;

import com.excelsus.excelsior.content.ExcelsiorRecipeTypes;
import com.simibubi.create.content.kinetics.crusher.AbstractCrushingRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;

@ParametersAreNonnullByDefault
public class CentrifugingRecipe extends AbstractCrushingRecipe {
	public CentrifugingRecipe(ProcessingRecipeBuilder.ProcessingRecipeParams params) {
		super(ExcelsiorRecipeTypes.CENTRIFUGING, params);
	}

	@Override
	public boolean matches(RecipeWrapper inv, Level worldIn) {
		if (inv.isEmpty())
			return false;
		return ingredients.get(0)
			.test(inv.getItem(0));
	}

	@Override
	protected int getMaxOutputCount() {
		return 4;
	}
}

