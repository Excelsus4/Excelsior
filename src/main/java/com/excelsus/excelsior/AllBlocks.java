package com.excelsus.excelsior;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AllBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Excelsior.MODID);

	public static void register(IEventBus eventBus){
		BLOCKS.register(eventBus);
	}

	public static final RegistryObject<Block> CHROME_ORE = BLOCKS.register("chrome_ore", () -> new Block(
		BlockBehaviour.Properties.of(Material.STONE)));
}
