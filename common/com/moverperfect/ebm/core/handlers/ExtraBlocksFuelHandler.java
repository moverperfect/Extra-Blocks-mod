package com.moverperfect.ebm.core.handlers;

import com.moverperfect.ebm.lib.BlockIds;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

/**
 * Extra-Blocks-Mod
 * 
 * ExtraBlocksFuelHandler
 * 
 * @author Moverperfect
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ExtraBlocksFuelHandler implements IFuelHandler {
	@Override
	public int getBurnTime(ItemStack fuel) {
		int var1 = fuel.itemID;
		// Id item in the furnace = coal block then make it last for 12800 ticks
		if(var1 == BlockIds.COAL_BLOCK){
			return 12800;
		}else{
			return 0;
		}
	}
}