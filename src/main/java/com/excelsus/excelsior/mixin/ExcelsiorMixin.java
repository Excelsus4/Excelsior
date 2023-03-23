package com.excelsus.excelsior.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.Minecraft;
import net.minecraft.client.main.GameConfig;

@Mixin(Minecraft.class)
public class ExcelsiorMixin {
	@Inject(method = "<init>", at = @At("TAIL"))
	private void excelsior$init(GameConfig gameConfig, CallbackInfo ci) {
	}
}
