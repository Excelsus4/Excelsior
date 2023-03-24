package com.excelsus.excelsior.content.item;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class DebugIngotItem extends Item {
	public DebugIngotItem(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
		if(!pLevel.isClientSide && pUsedHand == InteractionHand.MAIN_HAND){
			pPlayer.sendSystemMessage(Component.literal("Hello with a number of "+getRandomInt()));
			pPlayer.getCooldowns().addCooldown(this, 20);
		}

		return super.use(pLevel, pPlayer, pUsedHand);
	}

	@Override
	public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents,
		TooltipFlag pIsAdvanced) {
		if(Screen.hasShiftDown()){
			pTooltipComponents.add(Component.literal("DEBUG COMMENCING!").withStyle(ChatFormatting.RED));
		}else{
			pTooltipComponents.add(Component.literal("Press SHIFT to view more...").withStyle(ChatFormatting.GOLD));
		}
		super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
	}

	private int getRandomInt(){
		return RandomSource.createNewThreadLocalInstance().nextInt();
	}
}
