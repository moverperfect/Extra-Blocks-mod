package com.moverperfect.ebm.core.handlers;

import com.moverperfect.ebm.ExtraBlocksMain;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class ExtraBlocksFuelHandler implements IFuelHandler {
	@Override
	public int getBurnTime(ItemStack fuel) {
		int var1 = fuel.itemID;
		
		// Id item in the furnace = coal block then make it last for 12800 ticks
		if(var1 == ExtraBlocksMain.coalBlockID){
			return 12800;
		}else{
			return 0;
		}
	}
}