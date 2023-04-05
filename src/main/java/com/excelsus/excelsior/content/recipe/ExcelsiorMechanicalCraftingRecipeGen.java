package com.excelsus.excelsior.content.recipe;

import java.util.function.UnaryOperator;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;

import com.excelsus.excelsior.Excelsior;
import com.excelsus.excelsior.content.ExcelsiorBlocks;
import com.google.common.base.Supplier;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.foundation.data.recipe.MechanicalCraftingRecipeBuilder;
import com.simibubi.create.foundation.utility.RegisteredObjects;

public class ExcelsiorMechanicalCraftingRecipeGen extends ExcelsiorRecipeProvider {
	GeneratedRecipe

	CENTRIFUGE = create(ExcelsiorBlocks.CENTRIFUGE::get)
		.recipe(b -> b.key('C', AllBlocks.COGWHEEL.get())
			.key('L', AllBlocks.LARGE_COGWHEEL.get())
			.key('M', AllItems.PRECISION_MECHANISM.get())
			.key('P', AllItems.PROPELLER.get())
			.key('Q', AllItems.POLISHED_ROSE_QUARTZ.get())
			.key('S', AllBlocks.SMART_CHUTE.get())
			.key('T', ExcelsiorBlocks.STAINLESS_CASING.get())
			.patternLine(" LCL ")
			.patternLine(" MPM ")
			.patternLine(" QSQ ")
			.patternLine(" QMQ ")
			.patternLine("TTTTT")
			.disallowMirrored());

	public ExcelsiorMechanicalCraftingRecipeGen(DataGenerator pGenerator) {
		super(pGenerator);
	}
	GeneratedRecipeBuilder create(Supplier<ItemLike> result) {
		return new GeneratedRecipeBuilder(result);
	}

	class GeneratedRecipeBuilder {

		private String suffix;
		private Supplier<ItemLike> result;
		private int amount;

		public GeneratedRecipeBuilder(Supplier<ItemLike> result) {
			this.suffix = "";
			this.result = result;
			this.amount = 1;
		}

		GeneratedRecipeBuilder returns(int amount) {
			this.amount = amount;
			return this;
		}

		GeneratedRecipeBuilder withSuffix(String suffix) {
			this.suffix = suffix;
			return this;
		}

		GeneratedRecipe recipe(UnaryOperator<MechanicalCraftingRecipeBuilder> builder) {
			return register(consumer -> {
				MechanicalCraftingRecipeBuilder b =
					builder.apply(MechanicalCraftingRecipeBuilder.shapedRecipe(result.get(), amount));
				ResourceLocation location = Excelsior.asResource("mechanical_crafting/" + RegisteredObjects.getKeyOrThrow(result.get()
						.asItem())
					.getPath() + suffix);
				b.build(consumer, location);
			});
		}
	}

	@Override
	public String getName() {
		return "Excelsior's Mechanical Crafting Recipes";
	}

}
