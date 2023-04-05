package com.excelsus.excelsior.content;

import com.excelsus.excelsior.Excelsior;
import com.simibubi.create.foundation.block.connected.AllCTTypes;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;
import com.simibubi.create.foundation.block.connected.CTType;
import com.simibubi.create.foundation.block.render.SpriteShiftEntry;
import com.simibubi.create.foundation.block.render.SpriteShifter;
import com.simibubi.create.foundation.utility.Couple;

public class ExcelsiorSpriteShifts {

	public static final CTSpriteShiftEntry STAINLESS_CASING = omni("stainless_casing");

	static {
		populateMaps();
	}

	private static void populateMaps() {
	}

	private static Couple<CTSpriteShiftEntry> vault(String name) {
		final String prefixed = "vault_" + name;
		return Couple.createWithContext(b -> getCT(AllCTTypes.CROSS, prefixed, b ? prefixed : prefixed + "_large"));
	}

	//

	private static CTSpriteShiftEntry omni(String name) {
		return getCT(AllCTTypes.OMNIDIRECTIONAL, name);
	}

	private static CTSpriteShiftEntry horizontal(String name) {
		return getCT(AllCTTypes.HORIZONTAL, name);
	}

	private static CTSpriteShiftEntry vertical(String name) {
		return getCT(AllCTTypes.VERTICAL, name);
	}

	//

	private static SpriteShiftEntry get(String originalLocation, String targetLocation) {
		return SpriteShifter.get(Excelsior.asResource(originalLocation), Excelsior.asResource(targetLocation));
	}

	private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName, String connectedTextureName) {
		return CTSpriteShifter.getCT(type, Excelsior.asResource("block/" + blockTextureName), Excelsior.asResource("block/" + connectedTextureName + "_connected"));
	}

	private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName) {
		return getCT(type, blockTextureName, blockTextureName);
	}
}
