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

    // Mod Block Instances
    public static Block copperOre;
    public static Block copperBlock;
    public static Block tinOre;
    public static Block tinBlock;
    public static Block flintBlock;

    /**
     * Initialisation of the blocks and registering them
     */
    public static void init() {
        
        // Checking to see if we are still going to initialise the Metal blocks
        if (ConfigurationSettings.METALS = true) {
            
            // Set properties for the ore/storage blocks
            copperOre = new BlockCopperOre(BlockIds.COPPER_ORE).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("orecopper");
            copperBlock = new BlockCopperBlock(BlockIds.COPPER_BLOCK).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("blockcopper");
            tinOre = new BlockTinOre(BlockIds.TIN_ORE).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("oretin");
            tinBlock = new BlockTinBlock(BlockIds.TIN_BLOCK).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("blocktin");
            
            // Register ore/storage blocks to the game
            GameRegistry.registerBlock(copperOre, Strings.COPPER_ORE_NAME);
            GameRegistry.registerBlock(copperBlock, Strings.COPPER_BLOCK_NAME);
            GameRegistry.registerBlock(tinOre,Strings.TIN_ORE_NAME);
            GameRegistry.registerBlock(tinBlock,Strings.TIN_BLOCK_NAME);
            
            // Register the name for the ore/storage blocks
            LanguageRegistry.addName(copperOre, Strings.COPPER_ORE_NAME);
            LanguageRegistry.addName(copperBlock, Strings.COPPER_BLOCK_NAME);
            LanguageRegistry.addName(tinOre, Strings.TIN_ORE_NAME);
            LanguageRegistry.addName(tinBlock,Strings.TIN_BLOCK_NAME);
            
            // Register the ores with the forge ore dictionary
            OreDictionary.registerOre("oreCopper", new ItemStack(copperOre));
            OreDictionary.registerOre("blockCopper", new ItemStack(copperBlock));
            OreDictionary.registerOre("blockTin", new ItemStack(tinBlock));
            OreDictionary.registerOre("oreTin", new ItemStack(tinOre));
        
        }
        
        // Initialise flint block
        flintBlock = new BlockFlintBlock(BlockIds.FLINT_BLOCK).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("blockflint");
        GameRegistry.registerBlock(flintBlock, Strings.FLINT_BLOCK_NAME);
        LanguageRegistry.addName(flintBlock, Strings.FLINT_BLOCK_NAME);
        OreDictionary.registerOre("blockFlint", new ItemStack(flintBlock));
    }

    /**
     * Register the ore/storage block recipes
     */
    @SuppressWarnings("unchecked")
    public static void initBlockRecipes() {
        
        // Quick check if we are still initialising the metal blocks
        if (ConfigurationSettings.METALS) {
            // Recipe for the storage blocks
            CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack (copperBlock,1), new Object[]{"###", "###", "###", Character.valueOf('#'), "ingotCopper"}));
            CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack (tinBlock,1), new Object[]{"###", "###", "###", Character.valueOf('#'), "ingotTin"}));
            
            // Recipe for the ingots
            CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack (ModItems.copperIngot,9), "blockCopper"));
            CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack (ModItems.tinIngot,9), "blockTin"));
        }
        
        // Recipe for the flint block
        GameRegistry.addRecipe(new ItemStack (flintBlock,1), new Object[]{"###", "###", "###", Character.valueOf('#'), Item.flint});
        GameRegistry.addShapelessRecipe(new ItemStack (Item.flint,8), new Object[]{flintBlock});
        
        // Recipe for converting the wood slabs back into planks TODO Make a config option
        GameRegistry.addRecipe(new ItemStack(Block.planks, 1, 0), new Object[] {"#","#", '#', new ItemStack(Block.woodSingleSlab, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(Block.planks, 1, 2), new Object[] {"#","#", '#', new ItemStack(Block.woodSingleSlab, 1, 2)});
        GameRegistry.addRecipe(new ItemStack(Block.planks, 1, 1), new Object[] {"#","#", '#', new ItemStack(Block.woodSingleSlab, 1, 1)});
        GameRegistry.addRecipe(new ItemStack(Block.planks, 1, 3), new Object[] {"#","#", '#', new ItemStack(Block.woodSingleSlab, 1, 3)});
    }

    /**
     * Register the furnace recpies for the copper and tin ingots
     */
    public static void furnace() {
        GameRegistry.addSmelting(copperOre.blockID, new ItemStack(ModItems.copperIngot), 0.1F);
        GameRegistry.addSmelting(tinOre.blockID, new ItemStack(ModItems.tinIngot), 0.1F);
    }

}
