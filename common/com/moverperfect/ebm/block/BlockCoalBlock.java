package com.moverperfect.ebm.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

/**
 * Extra-Blocks-Mod
 * 
 * BlockCoalBlock
 * 
 * @author Moverperfect
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class BlockCoalBlock extends Block {

	public BlockCoalBlock(int par1) {
		super(par1, Material.rock);
		setStepSound(soundMetalFootstep);
		this.setHardness(4F);
		this.setResistance(10F);
	}
	
    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("ebm:" + this.getUnlocalizedName().substring(5));
    }
}
