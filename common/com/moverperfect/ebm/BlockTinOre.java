package com.moverperfect.ebm;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockTinOre extends Block {

	public BlockTinOre(int par1, int par2) {
		super(par1, par2, Material.rock);
		
		setStepSound(soundStoneFootstep);
	}
	
	@Override
	public String getTextureFile(){
		return "/textures/Blocks.png";
	}

}
