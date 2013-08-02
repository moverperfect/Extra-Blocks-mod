package com.moverperfect.ebm.configuration;

import static net.minecraftforge.common.Configuration.CATEGORY_GENERAL;

import java.io.File;
import java.util.logging.Level;

import com.moverperfect.ebm.lib.BlockIds;
import com.moverperfect.ebm.lib.ItemIds;
import com.moverperfect.ebm.lib.Reference;
import com.moverperfect.ebm.lib.Strings;

import net.minecraftforge.common.Configuration;

import cpw.mods.fml.common.FMLLog;

/**
 * Extra-Blocks-Mod
 * 
 * ConfigurationHandler
 * 
 * @author Moverperfect
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ConfigurationHandler {

    public static Configuration configuration;
    
    public static final String CATEGORY_RECIPES ="recipes"; 
	
	public static void init(File configFile) {
		configuration = new Configuration(configFile);

        try {
            configuration.load();

            /* General configs */
            ConfigurationSettings.DISPLAY_VERSION_RESULT = configuration.get(CATEGORY_GENERAL, ConfigurationSettings.DISPLAY_VERSION_RESULT_CONFIGNAME, ConfigurationSettings.DISPLAY_VERSION_RESULT_DEFAULT).getBoolean(ConfigurationSettings.DISPLAY_VERSION_RESULT_DEFAULT);
            ConfigurationSettings.LAST_DISCOVERED_VERSION = configuration.get(CATEGORY_GENERAL, ConfigurationSettings.LAST_DISCOVERED_VERSION_CONFIGNAME, ConfigurationSettings.LAST_DISCOVERED_VERSION_DEFAULT).getString();

    		ConfigurationSettings.METALS = configuration.get(Configuration.CATEGORY_GENERAL, ConfigurationSettings.METALS_CONFIGNAME, ConfigurationSettings.METALS_DEFAULT).getBoolean(ConfigurationSettings.METALS_DEFAULT);
    		ConfigurationSettings.METAL_TOOLS = configuration.get(Configuration.CATEGORY_GENERAL, ConfigurationSettings.METAL_TOOLS_CONFIGNAME, ConfigurationSettings.METAL_TOOLS_DEFAULT).getBoolean(ConfigurationSettings.METAL_TOOLS_DEFAULT);
    		
    		configuration.addCustomCategoryComment(CATEGORY_RECIPES, "Boolean values for custom recepies added");
    		ConfigurationSettings.SEEDS_BREAD = configuration.get(CATEGORY_RECIPES,ConfigurationSettings.SEEDS_BREAD_CONFIGNAME, ConfigurationSettings.SEEDS_BREAD_DEFAULT).getBoolean(ConfigurationSettings.SEEDS_BREAD_DEFAULT);

            ConfigurationSettings.BLOCK_TOOLS = configuration.get(Configuration.CATEGORY_GENERAL, ConfigurationSettings.BLOCK_TOOLS_CONFIGNAME, ConfigurationSettings.BLOCK_TOOLS_DEFAULT).getBoolean(ConfigurationSettings.BLOCK_TOOLS_DEFAULT);
            
            /* Block configs */
            BlockIds.COPPER_ORE = configuration.getBlock(Strings.COPPER_ORE_NAME, BlockIds.COPPER_ORE_DEFAULT).getInt(BlockIds.COPPER_ORE_DEFAULT);
            BlockIds.COPPER_BLOCK = configuration.getBlock(Strings.COPPER_BLOCK_NAME, BlockIds.COPPER_BLOCK_DEFAULT).getInt(BlockIds.COPPER_BLOCK_DEFAULT);
            BlockIds.TIN_ORE = configuration.getBlock(Strings.TIN_ORE_NAME, BlockIds.TIN_ORE_DEFAULT).getInt(BlockIds.TIN_ORE_DEFAULT);
            BlockIds.TIN_BLOCK = configuration.getBlock(Strings.TIN_BLOCK_NAME, BlockIds.TIN_BLOCK_DEFAULT).getInt(BlockIds.TIN_BLOCK_DEFAULT);
            BlockIds.COAL_BLOCK = configuration.getBlock(Strings.COAL_BLOCK_NAME, BlockIds.COAL_BLOCK_DEFAULT).getInt(BlockIds.COAL_BLOCK_DEFAULT);
            
            BlockIds.FLINT_BLOCK = configuration.getBlock(Strings.FLINT_BLOCK_NAME, BlockIds.FLINT_BLOCK_DEFAULT).getInt(BlockIds.FLINT_BLOCK_DEFAULT);
            
            /* Item configs */
            ItemIds.FLINT_AND_STEEL = configuration.getItem(Strings.FLINT_AND_STEEL_NAME,ItemIds.FLINT_AND_STEEL_DEFAULT).getInt(ItemIds.FLINT_AND_STEEL_DEFAULT);
            
            ItemIds.COPPER_INGOT = configuration.getItem(Strings.COPPER_INGOT_NAME, ItemIds.COPPER_INGOT_DEFAULT).getInt(ItemIds.COPPER_INGOT_DEFAULT);
            ItemIds.COPPER_SWORD = configuration.getItem(Strings.COPPER_SWORD_NAME, ItemIds.COPPER_SWORD_DEFAULT).getInt(ItemIds.COPPER_SWORD_DEFAULT);
            ItemIds.COPPER_SHOVEL = configuration.getItem(Strings.COPPER_SHOVEL_NAME, ItemIds.COPPER_SHOVEL_DEFAULT).getInt(ItemIds.COPPER_SHOVEL_DEFAULT);
            ItemIds.COPPER_PICKAXE = configuration.getItem(Strings.COPPER_PICKAXE_NAME, ItemIds.COPPER_PICKAXE_DEFAULT).getInt(ItemIds.COPPER_PICKAXE_DEFAULT);
            ItemIds.COPPER_AXE = configuration.getItem(Strings.COPPER_AXE_NAME, ItemIds.COPPER_AXE_DEFAULT).getInt(ItemIds.COPPER_AXE_DEFAULT);
            ItemIds.COPPER_HOE = configuration.getItem(Strings.COPPER_HOE_NAME, ItemIds.COPPER_HOE_DEFAULT).getInt(ItemIds.COPPER_HOE_DEFAULT);

            ItemIds.TIN_INGOT = configuration.getItem(Strings.TIN_INGOT_NAME, ItemIds.TIN_INGOT_DEFAULT).getInt(ItemIds.TIN_INGOT_DEFAULT);
            ItemIds.TIN_SWORD = configuration.getItem(Strings.TIN_SWORD_NAME, ItemIds.TIN_SWORD_DEFAULT).getInt(ItemIds.TIN_SWORD_DEFAULT);
            ItemIds.TIN_SHOVEL = configuration.getItem(Strings.TIN_SHOVEL_NAME, ItemIds.TIN_SHOVEL_DEFAULT).getInt(ItemIds.TIN_SHOVEL_DEFAULT);
            ItemIds.TIN_PICKAXE = configuration.getItem(Strings.TIN_PICKAXE_NAME, ItemIds.TIN_PICKAXE_DEFAULT).getInt(ItemIds.TIN_PICKAXE_DEFAULT);
            ItemIds.TIN_AXE = configuration.getItem(Strings.TIN_AXE_NAME, ItemIds.TIN_AXE_DEFAULT).getInt(ItemIds.TIN_AXE_DEFAULT);
            ItemIds.TIN_HOE = configuration.getItem(Strings.TIN_HOE_NAME, ItemIds.TIN_HOE_DEFAULT).getInt(ItemIds.TIN_HOE_DEFAULT);
            
            ItemIds.BLOCK_TOOLS = configuration.getItem("Block Tools starting id (Takes 25 ids)", ItemIds.BLOCK_TOOLS_DEFAULT).getInt(ItemIds.BLOCK_TOOLS_DEFAULT);
            
            ItemIds.BALL_SAP = configuration.getItem(Strings.BALL_SAP_NAME,ItemIds.BALL_SAP_DEFAULT).getInt(ItemIds.BALL_SAP_DEFAULT);
            ItemIds.DROP_SAP = configuration.getItem(Strings.DROP_SAP_NAME, ItemIds.DROP_SAP_DEFAULT).getInt(ItemIds.DROP_SAP_DEFAULT);
            configuration.save();
        }
        catch (Exception e) {
            FMLLog.log(Level.SEVERE, e, Reference.MOD_NAME + " has had a problem loading its configuration");
        }
        finally {
            configuration.save();
        }
	}
	
	public static void set(String categoryName, String propertyName, String newValue) {

        configuration.load();
        if (configuration.getCategoryNames().contains(categoryName)) {
            if (configuration.getCategory(categoryName).containsKey(propertyName)) {
                configuration.getCategory(categoryName).get(propertyName).set(newValue);
            }
        }
        configuration.save();
    }

}
