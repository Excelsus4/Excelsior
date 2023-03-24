package com.excelsus.excelsior.content;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import com.excelsus.excelsior.Excelsior;
import com.simibubi.create.AllBlocks;

public class ExcelsiorItemGroup extends CreativeModeTab {

	public ExcelsiorItemGroup() {
		super(Excelsior.ID);
	}

	@Override
	public ItemStack makeIcon() {
		return AllBlocks.MILLSTONE.asStack();
	}

}
