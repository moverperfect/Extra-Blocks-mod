package com.moverperfect.ebm.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemSap extends Item {

    public ItemSap(int par1) {
        super(par1);
        this.setCreativeTab(CreativeTabs.tabTools);
    }
    
    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("ebm:" + this.getUnlocalizedName().substring(5));
    }
}
