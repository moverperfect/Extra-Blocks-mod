package com.moverperfect.ebm.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

/**
 * BlockCopperBlock
 * 
 * @project Extra-Blocks-Mod
 * 
 * @author Moverperfect
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class BlockCopperBlock extends Block {

    /**
     * Copper block object
     * 
     * @param par1
     */
	public BlockCopperBlock(int par1) {
		super(par1, Material.iron);
		setStepSound(soundMetalFootstep);
		this.setHardness(4F);
		this.setResistance(10F);
	}
	
	/**
	 * Loading the icon
	 */
    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("ebm:" + this.getUnlocalizedName().substring(5));
    }
}