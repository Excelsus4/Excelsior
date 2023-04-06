package com.excelsus.excelsior.content;

import static com.excelsus.excelsior.Excelsior.*;
import static com.simibubi.create.AllTags.*;
import static com.simibubi.create.AllTags.AllItemTags.*;
import static com.simibubi.create.content.AllSections.*;

import net.minecraft.tags.TagKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.Tags;

import com.excelsus.excelsior.Excelsior;
import com.excelsus.excelsior.content.item.CastorSeedItem;
import com.excelsus.excelsior.content.item.DebugIngotItem;
import com.simibubi.create.content.curiosities.CombustibleItem;
import com.tterrag.registrate.util.entry.ItemEntry;

public class ExcelsiorItems {
	static {
		REGISTRATE.creativeModeTab(() -> Excelsior.EXCELSIOR_CREATIVE_TAB);
	}

	static {
		REGISTRATE.startSection(MATERIALS);
	}

	public static final ItemEntry<Item>
		FISH_POWDER = ingredient("fish_powder"),
		FISH_DOUGH = ingredient("fish_dough"),
		FISH_CAKE_RAW = ingredient("fish_cake_raw");

	public static final ItemEntry<Item> FISH_CAKE = REGISTRATE.item("fish_cake", Item::new)
		.properties(p -> p.food(new FoodProperties.Builder().nutrition(6)
			.saturationMod(0.3F)
			.build()))
		.register();

	public static final ItemEntry<Item> FISH_CAKE_SOUP = REGISTRATE.item("fish_cake_soup", Item::new)
		.properties(p -> p.food(new FoodProperties.Builder().nutrition(6)
			.saturationMod(0.8F)
			.build()))
		.register();

	public static final ItemEntry<CombustibleItem> YELLOW_CAKE = REGISTRATE.item("yellow_cake", CombustibleItem::new)
		.tag(AllItemTags.BLAZE_BURNER_FUEL_SPECIAL.tag, AllItemTags.UPRIGHT_ON_BELT.tag)
		.onRegister(i -> i.setBurnTime(3200))
		.register();

	public static final ItemEntry<Item>
		RAW_CHROMITE = taggedIngredient("raw_chromite", forgeItemTag("raw_materials/chromite"),
		forgeItemTag("raw_materials")),
		RAW_URANIUM = taggedIngredient("raw_uranium", forgeItemTag("raw_materials/uranium"),
			forgeItemTag("raw_materials"));

	public static final ItemEntry<Item>
		CHROME_INGOT = taggedIngredient("chrome_ingot",
		forgeItemTag("ingots/chrome"), CREATE_INGOTS.tag),
		STAINLESS_STEEL_INGOT = taggedIngredient("stainless_steel_ingot",
			forgeItemTag("ingots/stainless_steel"), CREATE_INGOTS.tag),
		DEPLETED_URANIUM_INGOT = taggedIngredient("depleted_uranium",
			forgeItemTag("ingots/depleted_uranium"), CREATE_INGOTS.tag),
		LOW_ENRICHED_URANIUM_INGOT = taggedIngredient("low_enriched_uranium",
			forgeItemTag("ingots/reactor_uranium"), CREATE_INGOTS.tag),
		HIGH_ENRICHED_URANIUM_INGOT = taggedIngredient("high_enriched_uranium",
			forgeItemTag("ingots/weapon_uranium"), CREATE_INGOTS.tag);

	public static final ItemEntry<Item>
		DEPLETED_URANIUM_NUGGET = taggedIngredient("depleted_uranium_nugget",
			forgeItemTag("nuggets/depleted_uranium"), Tags.Items.NUGGETS),
		LOW_ENRICHED_URANIUM_NUGGET = taggedIngredient("low_enriched_uranium_nugget",
			forgeItemTag("nuggets/reactor_uranium"), Tags.Items.NUGGETS),
		HIGH_ENRICHED_URANIUM_NUGGET = taggedIngredient("high_enriched_uranium_nugget",
			forgeItemTag("nuggets/weapon_uranium"), Tags.Items.NUGGETS);

	public static final ItemEntry<Item>
		STAINLESS_SHEET = taggedIngredient("stainless_sheet", forgeItemTag("plates/stainless_steel"), PLATES.tag),

	CRUSHED_CHROMITE = taggedIngredient("crushed_chromite_ore", CRUSHED_ORES.tag),
	CRUSHED_CHROME = taggedIngredient("crushed_chrome", CRUSHED_ORES.tag);

	static {
		REGISTRATE.startSection(CURIOSITIES);
	}

	public static final ItemEntry<DebugIngotItem> DEBUG_INGOT =
		REGISTRATE.item("debug_ingot", DebugIngotItem::new)
			.properties(p -> p.stacksTo(1))
			.register();

	static {
		REGISTRATE.startSection(ExcelsiorSections.CASTOR);
	}

	public static final ItemEntry<CastorSeedItem> CASTOR_SEEDS =
		REGISTRATE.item("castor_seeds", CastorSeedItem::new)
			.properties(p -> p.stacksTo(64))
			.register();

	public static final ItemEntry<Item>
		DRY_CASTOR_SEEDS = ingredient("dry_castor_seeds"),
		CRUSHED_CASTOR_SEEDS = ingredient("crushed_castor_seeds"),
		CASTOR_OIL_CAKE = ingredient("castor_oil_cake");

	public static final ItemEntry<BoneMealItem> OIL_CAKE_FERTILIZER =
		REGISTRATE.item("oil_cake_fertilizer", BoneMealItem::new)
			.properties(p -> p.stacksTo(64))
			.register();

	// Shortcuts
	private static ItemEntry<Item> ingredient(String name) {
		return REGISTRATE.item(name, Item::new)
			.register();
	}

	@SafeVarargs
	private static ItemEntry<Item> taggedIngredient(String name, TagKey<Item>... tags) {
		return REGISTRATE.item(name, Item::new)
			.tag(tags)
			.register();
	}

	// Load this class
	public static void register() {
	}
}
