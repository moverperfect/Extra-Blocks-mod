package com.moverperfect.ebm.creativetab;

import com.moverperfect.ebm.ExtraBlocksMain;

import net.minecraft.creativetab.CreativeTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTabEBM extends CreativeTabs {

    public CreativeTabEBM(int par1, String par2Str) {

        super(par1, par2Str);
    }

    @SideOnly(Side.CLIENT)
    /**
     * the itemID for the item to be displayed on the tab
     */
    public int getTabIconItemIndex() {

        return 1;
    }

}