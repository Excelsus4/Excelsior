package com.excelsus.excelsior.content.recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import com.excelsus.excelsior.Excelsior;
import com.excelsus.excelsior.content.ExcelsiorBlocks;
import com.excelsus.excelsior.content.ExcelsiorItems;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.AllTags;

public abstract class ExcelsiorRecipeProvider extends RecipeProvider implements IConditionBuilder {
	protected final List<GeneratedRecipe> all = new ArrayList<>();

	public ExcelsiorRecipeProvider(DataGenerator pGenerator) {
		super(pGenerator);
	}

	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
		all.forEach(c -> c.register(pFinishedRecipeConsumer));
		Excelsior.LOGGER.info(getName() + " registered " + all.size() + " recipe" + (all.size() == 1 ? "" : "s"));
	}

	protected GeneratedRecipe register(GeneratedRecipe recipe) {
		all.add(recipe);
		return recipe;
	}

	@FunctionalInterface
	public interface GeneratedRecipe {
		void register(Consumer<FinishedRecipe> consumer);
	}

	protected static class Marker {
	}

	protected static class I {
		static TagKey<Item> redstone() {
			return Tags.Items.DUSTS_REDSTONE;
		}
		static TagKey<Item> planks() {
			return ItemTags.PLANKS;
		}
		static TagKey<Item> woodSlab() {
			return ItemTags.WOODEN_SLABS;
		}
		static TagKey<Item> gold() {
			return AllTags.forgeItemTag("ingots/gold");
		}
		static TagKey<Item> goldSheet() {
			return AllTags.forgeItemTag("plates/gold");
		}
		static TagKey<Item> stone() {
			return Tags.Items.STONE;
		}
		static ItemLike andesite() {
			return AllItems.ANDESITE_ALLOY.get();
		}
		static ItemLike shaft() {
			return AllBlocks.SHAFT.get();
		}
		static ItemLike cog() {
			return AllBlocks.COGWHEEL.get();
		}
		static ItemLike largeCog() {
			return AllBlocks.LARGE_COGWHEEL.get();
		}
		static ItemLike andesiteCasing() {
			return AllBlocks.ANDESITE_CASING.get();
		}
		static TagKey<Item> brass() {
			return AllTags.forgeItemTag("ingots/brass");
		}
		static TagKey<Item> brassSheet() {
			return AllTags.forgeItemTag("plates/brass");
		}
		static TagKey<Item> iron() {
			return Tags.Items.INGOTS_IRON;
		}
		static TagKey<Item> ironNugget() {
			return AllTags.forgeItemTag("nuggets/iron");
		}
		static TagKey<Item> zinc() {
			return AllTags.forgeItemTag("ingots/zinc");
		}
		static TagKey<Item> ironSheet() {
			return AllTags.forgeItemTag("plates/iron");
		}
		static TagKey<Item> sturdySheet() {
			return AllTags.forgeItemTag("plates/obsidian");
		}
		static ItemLike brassCasing() {
			return AllBlocks.BRASS_CASING.get();
		}
		static ItemLike railwayCasing() {
			return AllBlocks.RAILWAY_CASING.get();
		}
		static ItemLike electronTube() {
			return AllItems.ELECTRON_TUBE.get();
		}
		static ItemLike precisionMechanism() {
			return AllItems.PRECISION_MECHANISM.get();
		}
		static ItemLike copperBlock() {
			return Items.COPPER_BLOCK;
		}
		static TagKey<Item> brassBlock() {
			return AllTags.forgeItemTag("storage_blocks/brass");
		}
		static TagKey<Item> zincBlock() {
			return AllTags.forgeItemTag("storage_blocks/zinc");
		}
		static TagKey<Item> wheatFlour() {
			return AllTags.forgeItemTag("flour/wheat");
		}
		static ItemLike copper() {
			return Items.COPPER_INGOT;
		}
		static TagKey<Item> copperSheet() {
			return AllTags.forgeItemTag("plates/copper");
		}
		static TagKey<Item> copperNugget() {
			return AllTags.forgeItemTag("nuggets/copper");
		}
		static TagKey<Item> brassNugget() {
			return AllTags.forgeItemTag("nuggets/brass");
		}
		static TagKey<Item> zincNugget() {
			return AllTags.forgeItemTag("nuggets/zinc");
		}
		static ItemLike copperCasing() {
			return AllBlocks.COPPER_CASING.get();
		}
		static TagKey<Item> stainlessSheet() {
			return AllTags.forgeItemTag("plates/stainless_steel");
		}
		static ItemLike stainlessCasing() {
			return ExcelsiorBlocks.STAINLESS_CASING.get();
		}
		static ItemLike stainlessIngot() {
			return ExcelsiorItems.STAINLESS_STEEL_INGOT.get();
		}
		static ItemLike castorSeeds() {
			return ExcelsiorItems.CASTOR_SEEDS.get();
		}
		static ItemLike dryCastorSeeds() {
			return ExcelsiorItems.DRY_CASTOR_SEEDS.get();
		}
		static ItemLike crushedCastorSeeds() {
			return ExcelsiorItems.CRUSHED_CASTOR_SEEDS.get();
		}
		static ItemLike castorOilCake() {
			return ExcelsiorItems.CASTOR_OIL_CAKE.get();
		}
		static ItemLike oilCakeFertilizer() {
			return ExcelsiorItems.OIL_CAKE_FERTILIZER.get();
		}
		static ItemLike crushedUranium() {
			return AllItems.CRUSHED_URANIUM.get();
		}
		static TagKey<Item> leuIngot() {
			return AllTags.forgeItemTag("ingots/reactor_uranium");
		}
	}
}
