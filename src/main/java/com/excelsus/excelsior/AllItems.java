package com.excelsus.excelsior;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AllItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Excelsior.MODID);

	public static void register(IEventBus eventBus){
		ITEMS.register(eventBus);
	}

	public static final RegistryObject<Item> RAW_CHROME = ITEMS.register("raw_chrome",
		() -> new Item(new Item.Properties().tab(AllCreativeTabs.EXCELSIOR_TAB)));

}
