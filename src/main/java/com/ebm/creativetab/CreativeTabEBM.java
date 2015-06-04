package com.moverperfect.ebm.creativetab;

import com.moverperfect.ebm.lib.BlockIds;
import net.minecraft.creativetab.CreativeTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Extra-Blocks-Mod
 * 
 * CreativeTabEBM
 * 
 * @author Moverperfect
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class CreativeTabEBM extends CreativeTabs {

    public CreativeTabEBM(int par1, String par2Str) {

        super(par1, par2Str);
    }

    @SideOnly(Side.CLIENT)
    /**
     * the itemID for the item to be displayed on the tab
     */
    public int getTabIconItemIndex() {

        return BlockIds.COPPER_BLOCK;
    }

}