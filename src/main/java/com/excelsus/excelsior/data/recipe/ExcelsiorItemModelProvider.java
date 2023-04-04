package com.excelsus.excelsior.data.recipe;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import com.excelsus.excelsior.Excelsior;

public class ExcelsiorItemModelProvider extends ItemModelProvider {

	public ExcelsiorItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, Excelsior.ID, existingFileHelper);
	}

	@Override
	protected void registerModels() {

	}



}
