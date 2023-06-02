package com.excelsus.excelsior.content;

import com.excelsus.excelsior.Excelsior;
import com.excelsus.excelsior.content.blocks.centrifuge.CentrifugeTileEntity;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

public class ExcelsiorTileEntities {
	public static final BlockEntityEntry<CentrifugeTileEntity> CENTRIFUGE = Excelsior.REGISTRATE
		.blockEntity("centrifuge", CentrifugeTileEntity::new)
		.validBlocks(ExcelsiorBlocks.CENTRIFUGE)
		.register();

	public static void register() {}
}
