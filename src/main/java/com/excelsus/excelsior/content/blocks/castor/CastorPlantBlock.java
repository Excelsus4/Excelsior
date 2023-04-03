package com.excelsus.excelsior.content.blocks.castor;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import com.excelsus.excelsior.content.ExcelsiorItems;

public class CastorPlantBlock extends CropBlock {
	public static final int MAX_AGE = 6;
	public static final IntegerProperty AGE = IntegerProperty.create("age", 0, MAX_AGE);

	public CastorPlantBlock(Properties properties) {
		super(properties);
	}

	@Override
	protected ItemLike getBaseSeedId(){
		return ExcelsiorItems.CASTOR_SEEDS.get();
	}

	@Override
	public IntegerProperty getAgeProperty(){
		return AGE;
	}

	@Override
	public int getMaxAge(){
		return MAX_AGE;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder){
		builder.add(AGE);
	}
}
