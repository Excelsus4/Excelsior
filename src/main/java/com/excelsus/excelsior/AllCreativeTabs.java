package com.excelsus.excelsior;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class AllCreativeTabs {
	public static final CreativeModeTab EXCELSIOR_TAB = new CreativeModeTab("excelsiortab") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(AllItems.RAW_CHROME.get());
		}
	};
}
