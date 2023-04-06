package com.excelsus.excelsior.content;

import static com.excelsus.excelsior.Excelsior.*;
import static com.simibubi.create.foundation.data.ModelGen.*;
import static com.simibubi.create.foundation.data.TagGen.*;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.Tags;

import com.excelsus.excelsior.Excelsior;
import com.excelsus.excelsior.content.blocks.castor.CastorPlantBlock;
import com.excelsus.excelsior.content.blocks.centrifuge.CentrifugeBlock;
import com.simibubi.create.content.AllSections;
import com.simibubi.create.content.contraptions.base.CasingBlock;
import com.simibubi.create.foundation.block.BlockStressDefaults;
import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;
import com.tterrag.registrate.util.entry.BlockEntry;

public class ExcelsiorBlocks {
	static {
		REGISTRATE.creativeModeTab(() -> Excelsior.EXCELSIOR_CREATIVE_TAB);
	}

	static {
		REGISTRATE.startSection(AllSections.PALETTES);
	}

	// ORES

	public static final BlockEntry<Block> CHROMITE_ORE = REGISTRATE.block("chromite_ore", Block::new)
		.initialProperties(() -> Blocks.GOLD_ORE)
		.properties(p -> p.color(MaterialColor.METAL))
		.properties(p -> p.requiresCorrectToolForDrops()
			.sound(SoundType.STONE))
		.transform(pickaxeOnly())
		.loot((lt, b) -> lt.add(b,
			RegistrateBlockLootTables.createSilkTouchDispatchTable(b,
				RegistrateBlockLootTables.applyExplosionDecay(b, LootItem.lootTableItem(ExcelsiorItems.RAW_CHROMITE.get())
					.apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))))))
		.tag(BlockTags.NEEDS_IRON_TOOL)
		.tag(Tags.Blocks.ORES)
		.transform(tagBlockAndItem("ores/chromite", "ores_in_ground/stone"))
		.tag(Tags.Items.ORES)
		.build()
		.register();

	public static final BlockEntry<Block> DEEPSLATE_CHROMITE_ORE = REGISTRATE.block("deepslate_chromite_ore", Block::new)
		.initialProperties(() -> Blocks.DEEPSLATE_GOLD_ORE)
		.properties(p -> p.color(MaterialColor.METAL))
		.properties(p -> p.requiresCorrectToolForDrops()
			.sound(SoundType.DEEPSLATE))
		.transform(pickaxeOnly())
		.loot((lt, b) -> lt.add(b,
			RegistrateBlockLootTables.createSilkTouchDispatchTable(b,
				RegistrateBlockLootTables.applyExplosionDecay(b, LootItem.lootTableItem(ExcelsiorItems.RAW_CHROMITE.get())
					.apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))))))
		.tag(BlockTags.NEEDS_IRON_TOOL)
		.tag(Tags.Blocks.ORES)
		.transform(tagBlockAndItem("ores/chromite", "ores_in_ground/deepslate"))
		.tag(Tags.Items.ORES)
		.build()
		.register();

	public static final BlockEntry<Block> URANIUM_ORE = REGISTRATE.block("uranium_ore", Block::new)
		.initialProperties(() -> Blocks.GOLD_ORE)
		.properties(p -> p.color(MaterialColor.METAL))
		.properties(p -> p.requiresCorrectToolForDrops()
			.sound(SoundType.STONE))
		.transform(pickaxeOnly())
		.loot((lt, b) -> lt.add(b,
			RegistrateBlockLootTables.createSilkTouchDispatchTable(b,
				RegistrateBlockLootTables.applyExplosionDecay(b, LootItem.lootTableItem(ExcelsiorItems.RAW_URANIUM.get())
					.apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))))))
		.tag(BlockTags.NEEDS_IRON_TOOL)
		.tag(Tags.Blocks.ORES)
		.transform(tagBlockAndItem("ores/uranium", "ores_in_ground/stone"))
		.tag(Tags.Items.ORES)
		.build()
		.register();

	public static final BlockEntry<Block> DEEPSLATE_URANIUM_ORE = REGISTRATE.block("deepslate_uranium_ore", Block::new)
		.initialProperties(() -> Blocks.DEEPSLATE_GOLD_ORE)
		.properties(p -> p.color(MaterialColor.METAL))
		.properties(p -> p.requiresCorrectToolForDrops()
			.sound(SoundType.DEEPSLATE))
		.transform(pickaxeOnly())
		.loot((lt, b) -> lt.add(b,
			RegistrateBlockLootTables.createSilkTouchDispatchTable(b,
				RegistrateBlockLootTables.applyExplosionDecay(b, LootItem.lootTableItem(ExcelsiorItems.RAW_URANIUM.get())
					.apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))))))
		.tag(BlockTags.NEEDS_IRON_TOOL)
		.tag(Tags.Blocks.ORES)
		.transform(tagBlockAndItem("ores/uranium", "ores_in_ground/deepslate"))
		.tag(Tags.Items.ORES)
		.build()
		.register();

	// STORAGE BLOCKS

	public static final BlockEntry<Block> RAW_CHROMITE_BLOCK = REGISTRATE.block("raw_chromite_block", Block::new)
		.initialProperties(() -> Blocks.RAW_GOLD_BLOCK)
		.properties(p -> p.color(MaterialColor.GLOW_LICHEN))
		.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
		.transform(pickaxeOnly())
		.tag(Tags.Blocks.STORAGE_BLOCKS)
		.tag(BlockTags.NEEDS_IRON_TOOL)
		.lang("Block of Raw Chromite")
		.transform(tagBlockAndItem("storage_blocks/raw_chromite"))
		.tag(Tags.Items.STORAGE_BLOCKS)
		.build()
		.register();

	public static final BlockEntry<Block> CHROME_BLOCK = REGISTRATE.block("chrome_block", Block::new)
		.initialProperties(() -> Blocks.RAW_GOLD_BLOCK)
		.properties(p -> p.color(MaterialColor.GLOW_LICHEN))
		.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
		.transform(pickaxeOnly())
		.tag(Tags.Blocks.STORAGE_BLOCKS)
		.tag(BlockTags.NEEDS_IRON_TOOL)
		.lang("Block of Chrome")
		.transform(tagBlockAndItem("storage_blocks/chrome"))
		.tag(Tags.Items.STORAGE_BLOCKS)
		.build()
		.register();

	public static final BlockEntry<Block> RAW_URANIUM_BLOCK = REGISTRATE.block("raw_uranium_block", Block::new)
		.initialProperties(() -> Blocks.RAW_GOLD_BLOCK)
		.properties(p -> p.color(MaterialColor.GLOW_LICHEN))
		.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
		.transform(pickaxeOnly())
		.tag(Tags.Blocks.STORAGE_BLOCKS)
		.tag(BlockTags.NEEDS_IRON_TOOL)
		.lang("Block of Raw Uranium")
		.transform(tagBlockAndItem("storage_blocks/raw_uranium"))
		.tag(Tags.Items.STORAGE_BLOCKS)
		.build()
		.register();

	public static final BlockEntry<Block> DU_BLOCK = REGISTRATE.block("du_block", Block::new)
		.initialProperties(() -> Blocks.RAW_GOLD_BLOCK)
		.properties(p -> p.color(MaterialColor.GLOW_LICHEN))
		.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
		.transform(pickaxeOnly())
		.tag(Tags.Blocks.STORAGE_BLOCKS)
		.tag(BlockTags.NEEDS_IRON_TOOL)
		.lang("Block of Depleted Uranium")
		.transform(tagBlockAndItem("storage_blocks/du"))
		.tag(Tags.Items.STORAGE_BLOCKS)
		.build()
		.register();

	public static final BlockEntry<Block> LEU_BLOCK = REGISTRATE.block("leu_block", Block::new)
		.initialProperties(() -> Blocks.RAW_GOLD_BLOCK)
		.properties(p -> p.color(MaterialColor.GLOW_LICHEN))
		.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
		.transform(pickaxeOnly())
		.tag(Tags.Blocks.STORAGE_BLOCKS)
		.tag(BlockTags.NEEDS_IRON_TOOL)
		.lang("Block of LEU")
		.transform(tagBlockAndItem("storage_blocks/leu"))
		.tag(Tags.Items.STORAGE_BLOCKS)
		.build()
		.register();

	public static final BlockEntry<Block> HEU_BLOCK = REGISTRATE.block("heu_block", Block::new)
		.initialProperties(() -> Blocks.RAW_GOLD_BLOCK)
		.properties(p -> p.color(MaterialColor.GLOW_LICHEN))
		.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
		.transform(pickaxeOnly())
		.tag(Tags.Blocks.STORAGE_BLOCKS)
		.tag(BlockTags.NEEDS_IRON_TOOL)
		.lang("Block of HEU")
		.transform(tagBlockAndItem("storage_blocks/heu"))
		.tag(Tags.Items.STORAGE_BLOCKS)
		.build()
		.register();

	public static final BlockEntry<Block> STAINLESS_BLOCK = REGISTRATE.block("stainless_block", Block::new)
		.initialProperties(() -> Blocks.RAW_GOLD_BLOCK)
		.properties(p -> p.color(MaterialColor.GLOW_LICHEN))
		.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
		.transform(pickaxeOnly())
		.tag(Tags.Blocks.STORAGE_BLOCKS)
		.tag(BlockTags.NEEDS_IRON_TOOL)
		.lang("Block of Stainless Steel")
		.transform(tagBlockAndItem("storage_blocks/stainless"))
		.tag(Tags.Items.STORAGE_BLOCKS)
		.build()
		.register();

	static {
		REGISTRATE.startSection(AllSections.KINETICS);
	}

	public static final BlockEntry<CentrifugeBlock> CENTRIFUGE = REGISTRATE.block("centrifuge", CentrifugeBlock::new)
		.initialProperties(SharedProperties::stone)
		.properties(p -> p.color(MaterialColor.METAL))
		.transform(pickaxeOnly())
		.blockstate((c, p) -> p.simpleBlock(c.getEntry(), AssetLookup.partialBaseModel(c, p)))
		.transform(BlockStressDefaults.setImpact(16.0))
		.item()
		.transform(customItemModel())
		.register();

	public static final BlockEntry<CasingBlock> STAINLESS_CASING =
		REGISTRATE.block("stainless_casing", CasingBlock::new)
			.properties(p -> p.color(MaterialColor.SNOW))
			.transform(BuilderTransformers.casing(() -> ExcelsiorSpriteShifts.STAINLESS_CASING))
			.lang("Stainless Steel Casing")
			.register();

	static {
		REGISTRATE.startSection(ExcelsiorSections.CASTOR);
	}

	public static final BlockEntry<CastorPlantBlock> CASTOR_PLANT = REGISTRATE.block("castor_plant",
			CastorPlantBlock::new)
		.initialProperties(() -> Blocks.WHEAT)
		.blockstate((c, p) -> {
			ModelFile[] stageModels = new ModelFile[c.get().getMaxAge() + 1];
			for (int i = 0; i < c.get().getMaxAge() + 1; i++) {
				stageModels[i] = p.models().getExistingFile(p.modLoc("block/castor/stage" + i));
			}
			p.getVariantBuilder(c.get())
				.forAllStates(state -> {
					int age = state.getValue(CastorPlantBlock.AGE);
					return ConfiguredModel.builder()
						.modelFile(stageModels[age])
						.build();
				});
		})
		.loot((lt, b) -> lt.add(b, RegistrateBlockLootTables.createCropDrops(b,
			ExcelsiorItems.CASTOR_SEEDS.get(), ExcelsiorItems.CASTOR_SEEDS.get(),
			LootItemBlockStatePropertyCondition.hasBlockStateProperties(b).
				setProperties(StatePropertiesPredicate.Builder.properties()
					.hasProperty(CastorPlantBlock.AGE, CastorPlantBlock.MAX_AGE)))))
		.register();

	// Load this class
	public static void register() {
	}
}
