package com.moverperfect.ebm.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import com.moverperfect.ebm.ExtraBlocksMain;
import com.moverperfect.ebm.configuration.ConfigurationSettings;
import com.moverperfect.ebm.item.ModItems;
import com.moverperfect.ebm.lib.BlockIds;
import com.moverperfect.ebm.lib.Strings;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * Extra-Blocks-Mod
 * 
 * ModBlocks
 * 
 * @author Moverperfect
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ModBlocks {

    /* Mod block instances */
    public static Block copperOre;
    public static Block copperBlock;
    public static Block tinOre;
    public static Block tinBlock;
    public static Block coalBlock;

    public static void init() {
        
        if (ConfigurationSettings.METALS = true) {
            copperOre = new BlockCopperOre(BlockIds.COPPER_ORE).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("orecopper");
            copperBlock = new BlockCopperBlock(BlockIds.COPPER_BLOCK).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("blockcopper");
            tinOre = new BlockTinOre(BlockIds.TIN_ORE).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("oretin");
            tinBlock = new BlockTinBlock(BlockIds.TIN_BLOCK).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("blocktin");
            
            GameRegistry.registerBlock(copperOre, Strings.COPPER_ORE_NAME);
            GameRegistry.registerBlock(copperBlock, Strings.COPPER_BLOCK_NAME);
            GameRegistry.registerBlock(tinOre,Strings.TIN_ORE_NAME);
            GameRegistry.registerBlock(tinBlock,Strings.TIN_BLOCK_NAME);
            
            LanguageRegistry.addName(copperOre, Strings.COPPER_ORE_NAME);
            LanguageRegistry.addName(copperBlock, Strings.COPPER_BLOCK_NAME);
            LanguageRegistry.addName(tinOre, Strings.TIN_ORE_NAME);
            LanguageRegistry.addName(tinBlock,Strings.TIN_BLOCK_NAME);
            
            OreDictionary.registerOre("oreCopper", new ItemStack(copperOre));
            OreDictionary.registerOre("blockCopper", new ItemStack(copperBlock));
        
            OreDictionary.registerOre("blockTin", new ItemStack(tinBlock));
            OreDictionary.registerOre("oreTin", new ItemStack(tinOre));
        
        }
        
        coalBlock = new BlockCoalBlock(BlockIds.COAL_BLOCK).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("blockcoal");
        GameRegistry.registerBlock(coalBlock,Strings.COAL_BLOCK_NAME);
        LanguageRegistry.addName(coalBlock, Strings.COAL_BLOCK_NAME);
        OreDictionary.registerOre("blockCoal", new ItemStack(coalBlock));
        
    }

    @SuppressWarnings("unchecked")
    public static void initBlockRecipes() {
        if (ConfigurationSettings.METALS) {
            CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack (copperBlock,1), new Object[]{"###", "###", "###", Character.valueOf('#'), "ingotCopper"}));
            CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack (tinBlock,1), new Object[]{"###", "###", "###", Character.valueOf('#'), "ingotTin"}));
            
            
            CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack (ModItems.copperIngot,9), "blockCopper"));
            CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack (ModItems.tinIngot,9), "blockTin"));
        }
        GameRegistry.addRecipe(new ItemStack (coalBlock,1), new Object[]{"###", "# #", "###", Character.valueOf('#'), Item.coal});
        GameRegistry.addShapelessRecipe(new ItemStack (Item.coal,8), new Object[]{coalBlock});
        
        GameRegistry.addRecipe(new ItemStack(Block.planks, 1, 0), new Object[] {"#","#", '#', new ItemStack(Block.woodSingleSlab, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(Block.planks, 1, 2), new Object[] {"#","#", '#', new ItemStack(Block.woodSingleSlab, 1, 2)});
        GameRegistry.addRecipe(new ItemStack(Block.planks, 1, 1), new Object[] {"#","#", '#', new ItemStack(Block.woodSingleSlab, 1, 1)});
        GameRegistry.addRecipe(new ItemStack(Block.planks, 1, 3), new Object[] {"#","#", '#', new ItemStack(Block.woodSingleSlab, 1, 3)});
    }

    public static void furnace() {
        GameRegistry.addSmelting(copperOre.blockID, new ItemStack(ModItems.copperIngot), 0.1F);
        GameRegistry.addSmelting(tinOre.blockID, new ItemStack(ModItems.tinIngot), 0.1F);
    }

}
