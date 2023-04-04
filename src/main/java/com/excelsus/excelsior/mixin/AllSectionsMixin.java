package com.excelsus.excelsior.mixin;

import java.util.ArrayList;
import java.util.Arrays;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.gen.Invoker;

import com.excelsus.excelsior.content.ExcelsiorSections;
import com.simibubi.create.content.AllSections;
import com.simibubi.create.foundation.item.ItemDescription.Palette;

@Mixin(AllSections.class)
@Unique
public class AllSectionsMixin {
	@Shadow
	@Final
	@Mutable
	private static AllSections[] $VALUES;

	static {
		ExcelsiorSections.CASTOR = sectionsExpansion$addVariant("CASTOR", Palette.Green);
	}

	@Invoker("<init>")
	public static AllSections sectionsExpansion$invokeInit(String internalName, int ordinal, Palette palette) {
		throw new AssertionError();
	}

	private static AllSections sectionsExpansion$addVariant(String internalName, Palette palette) {
		ArrayList<AllSections> variants = new ArrayList<>(Arrays.asList($VALUES));
		AllSections section = sectionsExpansion$invokeInit(internalName, variants.size(), palette);
		variants.add(section);
		$VALUES = variants.toArray(new AllSections[0]);
		return section;
	}
}
