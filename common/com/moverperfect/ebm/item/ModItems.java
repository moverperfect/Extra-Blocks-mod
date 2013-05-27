package com.moverperfect.ebm.item;

import com.moverperfect.ebm.ExtraBlocksMain;
import com.moverperfect.ebm.block.ModBlocks;
import com.moverperfect.ebm.configuration.ConfigurationSettings;
import com.moverperfect.ebm.lib.ItemIds;
import com.moverperfect.ebm.lib.Strings;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * Extra-Blocks-Mod
 * 
 * ModItems
 * 
 * @author Moverperfect
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ModItems {
    
    static EnumToolMaterial EnumToolMaterialCopper = EnumHelper.addToolMaterial("COPPER", 2, 200, 7.0F, 2, 14);
    static EnumToolMaterial EnumToolMaterialTin = EnumHelper.addToolMaterial("TIN", 2, 300, 7.5F, 2, 14);
    static EnumToolMaterial EnumToolMaterialWood = EnumHelper.addToolMaterial("WOOD", 0 , 236 , 2.0F , 0 , 15 );
    static EnumToolMaterial EnumToolMaterialStoneBrick = EnumHelper.addToolMaterial("STONE BRICK", 1 , 524 , 4.0F , 1 , 5);
    static EnumToolMaterial EnumToolMaterialIronBlock = EnumHelper.addToolMaterial("IRON BLOCK", 2 ,2250 , 6.0F , 2 , 14 );
    static EnumToolMaterial EnumToolMaterialDiamondBlock = EnumHelper.addToolMaterial("DIAMOND BLOCK", 3 , 14049 , 8.0F , 3, 10);
    static EnumToolMaterial EnumToolMaterialGoldBlock = EnumHelper.addToolMaterial("GOLD BLOCK", 0 , 288, 12.0F, 0, 22);
    
    public static Item copperIngot;
    public static Item tinIngot;
    
    public static Item copperSword;
    public static Item copperShovel;
    public static Item copperPickaxe;
    public static Item copperAxe;
    public static Item copperHoe;
    
    public static Item tinSword;
    public static Item tinShovel;
    public static Item tinPickaxe;
    public static Item tinAxe;
    public static Item tinHoe;
    
    public static Item woodBlockSword;
    public static Item woodBlockShovel;
    public static Item woodBlockPickaxe;
    public static Item woodBlockAxe;
    public static Item woodBlockHoe;
    
    public static Item stoneBlockSword;
    public static Item stoneBlockShovel;
    public static Item stoneBlockPickaxe;
    public static Item stoneBlockAxe;
    public static Item stoneBlockHoe;
    
    public static Item ironBlockSword;
    public static Item ironBlockShovel;
    public static Item ironBlockPickaxe;
    public static Item ironBlockAxe;
    public static Item ironBlockHoe;
    
    public static Item diamondBlockSword;
    public static Item diamondBlockShovel;
    public static Item diamondBlockPickaxe;
    public static Item diamondBlockAxe;
    public static Item diamondBlockHoe;
    
    public static Item goldBlockSword;
    public static Item goldBlockShovel;
    public static Item goldBlockPickaxe;
    public static Item goldBlockAxe;
    public static Item goldBlockHoe;
    
    public static Item flintAndSteelBlock;

	public static void init() {
		metals();
	    metalTools();
		blockTools();
	}

    public static void micJunk() {
        flintAndSteelBlock = new ItemFlintAndSteel(ItemIds.FLINT_AND_STEEL).setUnlocalizedName("flintandsteelblock");
        
        LanguageRegistry.addName(flintAndSteelBlock, Strings.FLINT_AND_STEEL_NAME);
        
        GameRegistry.registerItem(flintAndSteelBlock, Strings.FLINT_AND_STEEL_NAME);
        
        GameRegistry.addRecipe(new ItemStack(flintAndSteelBlock, 1), new Object[] {"A ", " B", 'A', Block.blockIron, 'B', ModBlocks.flintBlock});
    }

    private static void blockTools() {
        if (ConfigurationSettings.BLOCK_TOOLS) {
            woodBlockSword = new ItemSword(ItemIds.BLOCK_TOOLS, EnumToolMaterialWood).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("swordwoodblock");
            woodBlockShovel = new ItemSpade(ItemIds.BLOCK_TOOLS+1, EnumToolMaterialWood).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("shovelwoodblock");
            woodBlockPickaxe = new ItemPickaxe(ItemIds.BLOCK_TOOLS+2, EnumToolMaterialWood).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("pickaxewoodblock");
            woodBlockAxe = new ItemAxe(ItemIds.BLOCK_TOOLS+3, EnumToolMaterialWood).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("axewoodblock");
            woodBlockHoe = new ItemHoe(ItemIds.BLOCK_TOOLS+4, EnumToolMaterialWood).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("hoewoodblock");
            
            stoneBlockSword = new ItemSword(ItemIds.BLOCK_TOOLS+5, EnumToolMaterialWood).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("swordstonebrick");
            stoneBlockShovel = new ItemSpade(ItemIds.BLOCK_TOOLS+6, EnumToolMaterialWood).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("shovelstonebrick");
            stoneBlockPickaxe = new ItemPickaxe(ItemIds.BLOCK_TOOLS+7, EnumToolMaterialWood).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("pickaxestonebrick");
            stoneBlockAxe = new ItemAxe(ItemIds.BLOCK_TOOLS+8, EnumToolMaterialWood).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("axestonebrick");
            stoneBlockHoe = new ItemHoe(ItemIds.BLOCK_TOOLS+9, EnumToolMaterialWood).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("hoestonebrick");
            
            ironBlockSword = new ItemSword(ItemIds.BLOCK_TOOLS+10, EnumToolMaterialIronBlock).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("swordironblock");
            ironBlockShovel = new ItemSpade(ItemIds.BLOCK_TOOLS+11, EnumToolMaterialIronBlock).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("shovelironblock");
            ironBlockPickaxe = new ItemPickaxe(ItemIds.BLOCK_TOOLS+12, EnumToolMaterialIronBlock).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("pickaxeironblock");
            ironBlockAxe = new ItemAxe(ItemIds.BLOCK_TOOLS+13, EnumToolMaterialIronBlock).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("axeironblock");
            ironBlockHoe = new ItemHoe(ItemIds.BLOCK_TOOLS+14, EnumToolMaterialIronBlock).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("hoeironblock");
            
            diamondBlockSword = new ItemSword(ItemIds.BLOCK_TOOLS+15, EnumToolMaterialDiamondBlock).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("sworddiamondblock");
            diamondBlockShovel = new ItemSpade(ItemIds.BLOCK_TOOLS+16, EnumToolMaterialDiamondBlock).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("shoveldiamondblock");
            diamondBlockPickaxe = new ItemPickaxe(ItemIds.BLOCK_TOOLS+17, EnumToolMaterialDiamondBlock).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("pickaxediamondblock");
            diamondBlockAxe = new ItemAxe(ItemIds.BLOCK_TOOLS+18, EnumToolMaterialDiamondBlock).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("axediamondblock");
            diamondBlockHoe = new ItemHoe(ItemIds.BLOCK_TOOLS+19, EnumToolMaterialDiamondBlock).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("hoediamondblock");
            
            goldBlockSword = new ItemSword(ItemIds.BLOCK_TOOLS+20, EnumToolMaterialGoldBlock).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("swordgoldblock");
            goldBlockShovel = new ItemSpade(ItemIds.BLOCK_TOOLS+21, EnumToolMaterialGoldBlock).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("shovelgoldblock");
            goldBlockPickaxe = new ItemPickaxe(ItemIds.BLOCK_TOOLS+22, EnumToolMaterialGoldBlock).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("pickaxegoldblock");
            goldBlockAxe = new ItemAxe(ItemIds.BLOCK_TOOLS+23, EnumToolMaterialGoldBlock).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("axegoldblock");
            goldBlockHoe = new ItemHoe(ItemIds.BLOCK_TOOLS+24, EnumToolMaterialGoldBlock).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("hoegoldblock");
            
            LanguageRegistry.addName(woodBlockSword,Strings.WOOD_SWORD_NAME);
            LanguageRegistry.addName(woodBlockShovel,Strings.WOOD_SHOVEL_NAME);
            LanguageRegistry.addName(woodBlockPickaxe,Strings.WOOD_PICKAXE_NAME);
            LanguageRegistry.addName(woodBlockAxe,Strings.WOOD_AXE_NAME);
            LanguageRegistry.addName(woodBlockHoe,Strings.WOOD_HOE_NAME);
            
            LanguageRegistry.addName(stoneBlockSword,Strings.STONE_BRICK_SWORD_NAME);
            LanguageRegistry.addName(stoneBlockShovel,Strings.STONE_BRICK_SHOVEL_NAME);
            LanguageRegistry.addName(stoneBlockPickaxe,Strings.STONE_BRICK_PICKAXE_NAME);
            LanguageRegistry.addName(stoneBlockAxe,Strings.STONE_BRICK_AXE_NAME);
            LanguageRegistry.addName(stoneBlockHoe,Strings.STONE_BRICK_HOE_NAME);
            
            LanguageRegistry.addName(ironBlockSword,Strings.IRON_BLOCK_SWORD_NAME);
            LanguageRegistry.addName(ironBlockShovel,Strings.IRON_BLOCK_SHOVEL_NAME);
            LanguageRegistry.addName(ironBlockPickaxe,Strings.IRON_BLOCK_PICKAXE_NAME);
            LanguageRegistry.addName(ironBlockAxe,Strings.IRON_BLOCK_AXE_NAME);
            LanguageRegistry.addName(ironBlockHoe,Strings.IRON_BLOCK_HOE_NAME);
            
            LanguageRegistry.addName(goldBlockSword,Strings.GOLD_BLOCK_SWORD_NAME);
            LanguageRegistry.addName(goldBlockShovel,Strings.GOLD_BLOCK_SHOVEL_NAME);
            LanguageRegistry.addName(goldBlockPickaxe,Strings.GOLD_BLOCK_PICKAXE_NAME);
            LanguageRegistry.addName(goldBlockAxe,Strings.GOLD_BLOCK_AXE_NAME);
            LanguageRegistry.addName(goldBlockHoe,Strings.GOLD_BLOCK_HOE_NAME);
            
            LanguageRegistry.addName(diamondBlockSword,Strings.DIAMOND_BLOCK_SWORD_NAME);
            LanguageRegistry.addName(diamondBlockShovel,Strings.DIAMOND_BLOCK_SHOVEL_NAME);
            LanguageRegistry.addName(diamondBlockPickaxe,Strings.DIAMOND_BLOCK_PICKAXE_NAME);
            LanguageRegistry.addName(diamondBlockAxe,Strings.DIAMOND_BLOCK_AXE_NAME);
            LanguageRegistry.addName(diamondBlockHoe,Strings.DIAMOND_BLOCK_HOE_NAME);
            
            GameRegistry.registerItem(woodBlockSword,Strings.WOOD_SWORD_NAME);
            GameRegistry.registerItem(woodBlockShovel,Strings.WOOD_SHOVEL_NAME);
            GameRegistry.registerItem(woodBlockPickaxe,Strings.WOOD_PICKAXE_NAME);
            GameRegistry.registerItem(woodBlockAxe,Strings.WOOD_AXE_NAME);
            GameRegistry.registerItem(woodBlockHoe,Strings.WOOD_HOE_NAME);
            
            GameRegistry.registerItem(stoneBlockSword,Strings.STONE_BRICK_SWORD_NAME);
            GameRegistry.registerItem(stoneBlockShovel,Strings.STONE_BRICK_SHOVEL_NAME);
            GameRegistry.registerItem(stoneBlockPickaxe,Strings.STONE_BRICK_PICKAXE_NAME);
            GameRegistry.registerItem(stoneBlockAxe,Strings.STONE_BRICK_AXE_NAME);
            GameRegistry.registerItem(stoneBlockHoe,Strings.STONE_BRICK_HOE_NAME);
            
            GameRegistry.registerItem(ironBlockSword,Strings.IRON_BLOCK_SWORD_NAME);
            GameRegistry.registerItem(ironBlockShovel,Strings.IRON_BLOCK_SHOVEL_NAME);
            GameRegistry.registerItem(ironBlockPickaxe,Strings.IRON_BLOCK_PICKAXE_NAME);
            GameRegistry.registerItem(ironBlockAxe,Strings.IRON_BLOCK_AXE_NAME);
            GameRegistry.registerItem(ironBlockHoe,Strings.IRON_BLOCK_HOE_NAME);
            
            GameRegistry.registerItem(goldBlockSword,Strings.GOLD_BLOCK_SWORD_NAME);
            GameRegistry.registerItem(goldBlockShovel,Strings.GOLD_BLOCK_SHOVEL_NAME);
            GameRegistry.registerItem(goldBlockPickaxe,Strings.GOLD_BLOCK_PICKAXE_NAME);
            GameRegistry.registerItem(goldBlockAxe,Strings.GOLD_BLOCK_AXE_NAME);
            GameRegistry.registerItem(goldBlockHoe,Strings.GOLD_BLOCK_HOE_NAME);
            
            GameRegistry.registerItem(diamondBlockSword,Strings.DIAMOND_BLOCK_SWORD_NAME);
            GameRegistry.registerItem(diamondBlockShovel,Strings.DIAMOND_BLOCK_SHOVEL_NAME);
            GameRegistry.registerItem(diamondBlockPickaxe,Strings.DIAMOND_BLOCK_PICKAXE_NAME);
            GameRegistry.registerItem(diamondBlockAxe,Strings.DIAMOND_BLOCK_AXE_NAME);
            GameRegistry.registerItem(diamondBlockHoe,Strings.DIAMOND_BLOCK_HOE_NAME);
            
            GameRegistry.addRecipe(new ItemStack(woodBlockSword), new Object[]{"#","#","s",Character.valueOf('#'), Block.wood, ('s'),Item.stick});
            GameRegistry.addRecipe(new ItemStack(woodBlockShovel),new Object[]{"#","s","s",Character.valueOf('#'), Block.wood, ('s'),Item.stick});
            GameRegistry.addRecipe(new ItemStack(woodBlockPickaxe), new Object[]{"###"," s "," s ",Character.valueOf('#'), Block.wood, ('s'),Item.stick});
            GameRegistry.addRecipe(new ItemStack(woodBlockAxe),new Object[]{"##","#s"," s",Character.valueOf('#'), Block.wood, ('s'), Item.stick});
            GameRegistry.addRecipe(new ItemStack(woodBlockHoe), new Object[]{"##"," s"," s",Character.valueOf('#'), Block.wood, ('s'), Item.stick});
            
            GameRegistry.addRecipe(new ItemStack(stoneBlockSword), new Object[]{"#","#","s",Character.valueOf('#'), Block.stoneBrick, ('s'),Item.stick});
            GameRegistry.addRecipe(new ItemStack(stoneBlockShovel),new Object[]{"#","s","s",Character.valueOf('#'), Block.stoneBrick, ('s'),Item.stick});
            GameRegistry.addRecipe(new ItemStack(stoneBlockPickaxe), new Object[]{"###"," s "," s ",Character.valueOf('#'), Block.stoneBrick, ('s'),Item.stick});
            GameRegistry.addRecipe(new ItemStack(stoneBlockAxe),new Object[]{"##","#s"," s",Character.valueOf('#'), Block.stoneBrick, ('s'), Item.stick});
            GameRegistry.addRecipe(new ItemStack(stoneBlockHoe), new Object[]{"##"," s"," s",Character.valueOf('#'), Block.stoneBrick, ('s'), Item.stick});
            
            GameRegistry.addRecipe(new ItemStack(ironBlockSword), new Object[]{"#","#","s",Character.valueOf('#'), Block.blockIron, ('s'),Item.stick});
            GameRegistry.addRecipe(new ItemStack(ironBlockShovel),new Object[]{"#","s","s",Character.valueOf('#'), Block.blockIron, ('s'),Item.stick});
            GameRegistry.addRecipe(new ItemStack(ironBlockPickaxe), new Object[]{"###"," s "," s ",Character.valueOf('#'), Block.blockIron, ('s'),Item.stick});
            GameRegistry.addRecipe(new ItemStack(ironBlockAxe),new Object[]{"##","#s"," s",Character.valueOf('#'), Block.blockIron, ('s'), Item.stick});
            GameRegistry.addRecipe(new ItemStack(ironBlockHoe), new Object[]{"##"," s"," s",Character.valueOf('#'), Block.blockIron, ('s'), Item.stick});
            
            GameRegistry.addRecipe(new ItemStack(goldBlockSword), new Object[]{"#","#","s",Character.valueOf('#'), Block.blockGold, ('s'),Item.stick});
            GameRegistry.addRecipe(new ItemStack(goldBlockShovel),new Object[]{"#","s","s",Character.valueOf('#'), Block.blockGold, ('s'),Item.stick});
            GameRegistry.addRecipe(new ItemStack(goldBlockPickaxe), new Object[]{"###"," s "," s ",Character.valueOf('#'), Block.blockGold, ('s'),Item.stick});
            GameRegistry.addRecipe(new ItemStack(goldBlockAxe),new Object[]{"##","#s"," s",Character.valueOf('#'), Block.blockGold, ('s'), Item.stick});
            GameRegistry.addRecipe(new ItemStack(goldBlockHoe), new Object[]{"##"," s"," s",Character.valueOf('#'), Block.blockGold, ('s'), Item.stick});
            
            GameRegistry.addRecipe(new ItemStack(diamondBlockSword), new Object[]{"#","#","s",Character.valueOf('#'), Block.blockDiamond, ('s'),Item.stick});
            GameRegistry.addRecipe(new ItemStack(diamondBlockShovel),new Object[]{"#","s","s",Character.valueOf('#'), Block.blockDiamond, ('s'),Item.stick});
            GameRegistry.addRecipe(new ItemStack(diamondBlockPickaxe), new Object[]{"###"," s "," s ",Character.valueOf('#'), Block.blockDiamond, ('s'),Item.stick});
            GameRegistry.addRecipe(new ItemStack(diamondBlockAxe),new Object[]{"##","#s"," s",Character.valueOf('#'), Block.blockDiamond, ('s'), Item.stick});
            GameRegistry.addRecipe(new ItemStack(diamondBlockHoe), new Object[]{"##"," s"," s",Character.valueOf('#'), Block.blockDiamond, ('s'), Item.stick});
        }
    }
    
    private static void metals() {
        if (ConfigurationSettings.METALS) {
            tinIngot = new ItemIngot(ItemIds.TIN_INGOT).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("ingottin");
            copperIngot = new ItemIngot(ItemIds.COPPER_INGOT).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("ingotcopper");
            
            LanguageRegistry.addName(tinIngot,Strings.TIN_INGOT_NAME);
            LanguageRegistry.addName(copperIngot, Strings.COPPER_INGOT_NAME);
            
            GameRegistry.registerItem(tinIngot, Strings.TIN_INGOT_NAME);
            GameRegistry.registerItem(copperIngot, Strings.COPPER_INGOT_NAME);
            
            OreDictionary.registerOre("ingotTin", new ItemStack(tinIngot));
            OreDictionary.registerOre("ingotCopper", new ItemStack(copperIngot));
        }
    }

    @SuppressWarnings("unchecked")
    private static void metalTools() {
		if (ConfigurationSettings.METAL_TOOLS) {
		    copperSword = new ItemSword(ItemIds.COPPER_SWORD, EnumToolMaterialCopper).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("swordcopper");
            copperShovel = new ItemSpade(ItemIds.COPPER_SHOVEL, EnumToolMaterialCopper).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("shovelcopper");
            copperPickaxe = new ItemPickaxe(ItemIds.COPPER_PICKAXE, EnumToolMaterialCopper).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("pickaxecopper");
            copperAxe = new ItemAxe(ItemIds.COPPER_AXE, EnumToolMaterialCopper).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("axecopper");
            copperHoe = new ItemHoe(ItemIds.COPPER_HOE, EnumToolMaterialCopper).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("hoecopper");
            
            tinSword = new ItemSword(ItemIds.TIN_SWORD, EnumToolMaterialTin).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("swordtin");
            tinShovel = new ItemSpade(ItemIds.TIN_SHOVEL, EnumToolMaterialTin).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("shoveltin");
            tinPickaxe = new ItemPickaxe(ItemIds.TIN_PICKAXE, EnumToolMaterialTin).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("pickaxetin");
            tinAxe = new ItemAxe(ItemIds.TIN_AXE, EnumToolMaterialTin).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("axetin");
            tinHoe = new ItemHoe(ItemIds.TIN_HOE, EnumToolMaterialTin).setCreativeTab(ExtraBlocksMain.tabsEBM).setUnlocalizedName("hoetin");

            LanguageRegistry.addName(copperSword, Strings.COPPER_SWORD_NAME);
            LanguageRegistry.addName(copperShovel, Strings.COPPER_SHOVEL_NAME);
            LanguageRegistry.addName(copperPickaxe, Strings.COPPER_PICKAXE_NAME);
            LanguageRegistry.addName(copperAxe, Strings.COPPER_AXE_NAME);
            LanguageRegistry.addName(copperHoe, Strings.COPPER_HOE_NAME);
            
            LanguageRegistry.addName(tinSword, Strings.TIN_SWORD_NAME);
            LanguageRegistry.addName(tinShovel, Strings.TIN_SHOVEL_NAME);
            LanguageRegistry.addName(tinPickaxe, Strings.TIN_PICKAXE_NAME);
            LanguageRegistry.addName(tinAxe, Strings.TIN_AXE_NAME);
            LanguageRegistry.addName(tinHoe, Strings.TIN_HOE_NAME);
            
            GameRegistry.registerItem(copperSword, Strings.COPPER_SWORD_NAME);
            GameRegistry.registerItem(copperShovel, Strings.COPPER_SHOVEL_NAME);
            GameRegistry.registerItem(copperPickaxe, Strings.COPPER_PICKAXE_NAME);
            GameRegistry.registerItem(copperAxe, Strings.COPPER_AXE_NAME);
            GameRegistry.registerItem(copperHoe, Strings.COPPER_HOE_NAME);
            
            GameRegistry.registerItem(copperSword, Strings.TIN_SWORD_NAME);
            GameRegistry.registerItem(copperShovel, Strings.TIN_SHOVEL_NAME);
            GameRegistry.registerItem(copperPickaxe, Strings.TIN_PICKAXE_NAME);
            GameRegistry.registerItem(copperAxe, Strings.TIN_AXE_NAME);
            GameRegistry.registerItem(copperHoe, Strings.TIN_HOE_NAME);
            
            CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack (copperSword,1), new Object[]{"#","#","s",Character.valueOf('#'), "ingotCopper", ('s'),Item.stick}));
            CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack (copperShovel), new Object[]{"#","s","s",Character.valueOf('#'), "ingotCopper", ('s'),Item.stick}));
            CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack (copperPickaxe), new Object[]{"###"," s "," s ",Character.valueOf('#'), "ingotCopper", ('s'),Item.stick}));
            CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack (copperAxe), new Object[]{"##","#s"," s",Character.valueOf('#'), "ingotCopper", ('s'), Item.stick}));
            CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack (copperHoe),new Object[]{"##"," s"," s",Character.valueOf('#'), "ingotCopper", ('s'), Item.stick}));
            
            CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack (tinSword), new Object[]{"#","#","s",Character.valueOf('#'), "ingotTin", ('s'),Item.stick}));
            CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack (tinShovel), new Object[]{"#","s","s",Character.valueOf('#'), "ingotTin", ('s'),Item.stick}));
            CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack (tinPickaxe), new Object[]{"###"," s "," s ",Character.valueOf('#'), "ingotTin", ('s'),Item.stick}));
            CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack (tinAxe), new Object[]{"##","#s"," s",Character.valueOf('#'), "ingotTin", ('s'), Item.stick}));
            CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack (tinHoe),new Object[]{"##"," s"," s",Character.valueOf('#'), "ingotTin", ('s'), Item.stick}));

		}
	}

}
