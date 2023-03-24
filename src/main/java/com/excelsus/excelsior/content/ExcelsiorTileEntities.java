package com.excelsus.excelsior.content;

import com.excelsus.excelsior.Excelsior;
import com.excelsus.excelsior.content.blocks.centrifuge.CentrifugeTileEntity;
import com.simibubi.create.content.contraptions.components.millstone.MillStoneCogInstance;
import com.simibubi.create.content.contraptions.components.millstone.MillstoneRenderer;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

public class ExcelsiorTileEntities {
	public static final BlockEntityEntry<CentrifugeTileEntity> CENTRIFUGE = Excelsior.REGISTRATE
		.tileEntity("centrifuge", CentrifugeTileEntity::new)
		.instance(() -> MillStoneCogInstance::new, false)
		.validBlocks(ExcelsiorBlocks.CENTRIFUGE)
		.renderer(() -> MillstoneRenderer::new)
		.register();

	public static void register() {}
}
