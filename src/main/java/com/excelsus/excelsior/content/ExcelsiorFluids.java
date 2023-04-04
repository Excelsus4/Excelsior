package com.excelsus.excelsior.content;

import static com.excelsus.excelsior.Excelsior.*;

import java.util.function.Consumer;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.fluids.FluidInteractionRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import com.excelsus.excelsior.Excelsior;
import com.simibubi.create.AllTags;
import com.tterrag.registrate.util.entry.FluidEntry;

public class ExcelsiorFluids {
	public static final FluidEntry<ForgeFlowingFluid.Flowing> CASTOR_OIL =
		REGISTRATE.fluid("castor_oil",
				Excelsior.asResource("fluid/" + "castor_oil" + "_still"),
				Excelsior.asResource("fluid/" + "castor_oil" + "_flow"),
				NoColorFluidAttributes::new)
			.lang("Castor Oil")
			.tag(AllTags.forgeFluidTag("castor_oil"))
			.properties(b -> b.viscosity(60)
				.density(80))
			.fluidProperties(p -> p.levelDecreasePerBlock(1)
				.tickRate(1)
				.slopeFindDistance(3)
				.explosionResistance(1f))
			.source(ForgeFlowingFluid.Source::new)
			.bucket()
			.tag(AllTags.forgeItemTag("buckets/castor_oil"))
			.build()
			.register();

	public static void register() {
	}

	public static void registerFluidInteractions() {
		FluidInteractionRegistry.addInteraction(
			ForgeMod.LAVA_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(
				CASTOR_OIL.get().getFluidType(),
				fluidState -> {
					if (fluidState.isSource()) {
						return Blocks.OBSIDIAN.defaultBlockState();
					} else {
						return Blocks.NETHERRACK
							.defaultBlockState();
					}
				}
			));
	}

	@Nullable
	public static BlockState getLavaInteraction(FluidState fluidState) {
		Fluid fluid = fluidState.getType();
		if (fluid.isSame(CASTOR_OIL.get()))
			return Blocks.NETHERRACK
				.defaultBlockState();
		return null;
	}

	public static abstract class TintedFluidType extends FluidType {

		protected static final int NO_TINT = 0xffffffff;
		private final ResourceLocation stillTexture;
		private final ResourceLocation flowingTexture;

		public TintedFluidType(Properties properties, ResourceLocation stillTexture, ResourceLocation flowingTexture) {
			super(properties);
			this.stillTexture = stillTexture;
			this.flowingTexture = flowingTexture;
		}

		@Override
		public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
			consumer.accept(new IClientFluidTypeExtensions() {

				@Override
				public ResourceLocation getStillTexture() {
					return stillTexture;
				}

				@Override
				public ResourceLocation getFlowingTexture() {
					return flowingTexture;
				}

				@Override
				public int getTintColor(FluidStack stack) {
					return TintedFluidType.this.getTintColor(stack);
				}

				@Override
				public int getTintColor(FluidState state, BlockAndTintGetter getter, BlockPos pos) {
					return TintedFluidType.this.getTintColor(state, getter, pos);
				}

			});
		}

		protected abstract int getTintColor(FluidStack stack);

		protected abstract int getTintColor(FluidState state, BlockAndTintGetter getter, BlockPos pos);

	}

	private static class NoColorFluidAttributes extends TintedFluidType {

		public NoColorFluidAttributes(Properties properties, ResourceLocation stillTexture,
			ResourceLocation flowingTexture) {
			super(properties, stillTexture, flowingTexture);
		}

		@Override
		protected int getTintColor(FluidStack stack) {
			return NO_TINT;
		}

		@Override
		public int getTintColor(FluidState state, BlockAndTintGetter world, BlockPos pos) {
			return 0x00ffffff;
		}

	}
}
