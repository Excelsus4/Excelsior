package com.excelsus.excelsior.mixin;

import java.util.ArrayList;
import java.util.Arrays;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.gen.Invoker;

import com.excelsus.excelsior.content.ExcelsiorRecipeTypes;
import com.excelsus.excelsior.content.blocks.centrifuge.CentrifugingRecipe;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.contraptions.processing.ProcessingRecipeBuilder;

@Mixin(AllRecipeTypes.class)
@Unique
public class AllRecipeTypesMixin {
	@Shadow
	@Final
	@Mutable
	private static AllRecipeTypes[] $VALUES;

	static {
		ExcelsiorRecipeTypes.CENTRIFUGING = recipeTypeExpansion$addVariant("CENTRIFUGING", CentrifugingRecipe::new);
	}

	@Invoker("<init>")
	public static AllRecipeTypes recipeTypeExpansion$invokeInit(String internalName, int ordinal, ProcessingRecipeBuilder.ProcessingRecipeFactory<?> processingRecipeFactory) {
		throw new AssertionError();
	}

	private static AllRecipeTypes recipeTypeExpansion$addVariant(String internalName, ProcessingRecipeBuilder.ProcessingRecipeFactory<?> processingRecipeFactory) {
		ArrayList<AllRecipeTypes> variants = new ArrayList<>(Arrays.asList($VALUES));
		AllRecipeTypes section = recipeTypeExpansion$invokeInit(internalName, variants.size(), processingRecipeFactory);
		variants.add(section);
		$VALUES = variants.toArray(new AllRecipeTypes[0]);
		return section;
	}
}
