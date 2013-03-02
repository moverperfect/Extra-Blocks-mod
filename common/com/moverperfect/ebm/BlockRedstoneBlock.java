package com.moverperfect.ebm;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockRedstoneBlock extends Block {

	public BlockRedstoneBlock(int par1, int par2) {
		super(par1, par2, Material.iron);
		setStepSound(soundMetalFootstep);
	}

	@Override
	public String getTextureFile(){
		return "/textures/Blocks.png";
	}
	@Override
	public boolean canProvidePower() {
		return true;
	}

}
