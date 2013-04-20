package com.moverperfect.ebm.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

/**
 * Extra-Blocks-Mod
 * 
 * ItemIngot
 * 
 * @author Moverperfect
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ItemIngot extends Item {

	public ItemIngot(int par1) {
		super(par1);
	}
	
    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("ebm:" + this.getUnlocalizedName().substring(5));
    }

}
