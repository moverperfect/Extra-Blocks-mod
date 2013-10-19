package com.moverperfect.ebm;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;

import com.moverperfect.ebm.block.ModBlocks;
import com.moverperfect.ebm.configuration.ConfigurationHandler;
import com.moverperfect.ebm.core.handlers.ExtraBlocksFuelHandler;
import com.moverperfect.ebm.core.handlers.ExtraBlocksWorldGen;
import com.moverperfect.ebm.core.handlers.VersionCheckTickHandler;
import com.moverperfect.ebm.core.helper.LogHelper;
import com.moverperfect.ebm.core.helper.VersionHelper;
import com.moverperfect.ebm.core.proxy.ClientProxy;
import com.moverperfect.ebm.core.proxy.CommonProxy;
import com.moverperfect.ebm.creativetab.CreativeTabEBM;
import com.moverperfect.ebm.item.ModItems;
import com.moverperfect.ebm.lib.Reference;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

/**
 * ExtraBlocksMain
 * 
 * @project Extra-Blocks-Mod
 * 
 * @author Moverperfect
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

@NetworkMod(clientSideRequired = true, serverSideRequired = false)
@Mod (modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION_NUMBER)

public class ExtraBlocksMain {
	
    // Declaring and referencing proxies
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static ClientProxy cproxy;
	
	// Declaring the mod
	@Instance(Reference.MOD_ID)
	public static ExtraBlocksMain instance;
	
	// Declaring the creative tab
	public static final CreativeTabs tabsEBM = new CreativeTabEBM(CreativeTabs.getNextID(), Reference.MOD_ID);
	
	/**
	 * The initialisation stage(middle) of the fml loading
	 * 
	 * @param event
	 */
	@EventHandler
	public void load(FMLInitializationEvent event){
		// Giving the creative tab the correct name
		LanguageRegistry.instance().addStringLocalization("itemGroup.EBM", "en_US", "Extra Blocks");
		
		// Register the world generator for the ores
		GameRegistry.registerWorldGenerator(new ExtraBlocksWorldGen());
		
		// Register the fuel handler(No longer used)
		GameRegistry.registerFuelHandler(new ExtraBlocksFuelHandler());
	};
	
	/**
	 * The first initialisation stage for fml loading
	 * 
	 * @param event
	 */
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
	    // Say that i am actually doing something
		System.out.println("ExtraBlocks Loading config file");
		
		// Create the config file
		ConfigurationHandler.init(new File(event.getModConfigurationDirectory().getAbsolutePath() + "\\" + Reference.MOD_ID + ".cfg"));
		
		// Initialise the loghelper for easier logging
		LogHelper.init();
	    
		// Initialise the declaration of the ebm block collection
        ModBlocks.init();
        
        // Initialise the declaration of the ebm item collection
        ModItems.init();
        
        // Initialise the declaration of the furnace recipes
        ModBlocks.furnace();
        
        // Initialise the declaration of the block recipes
        ModBlocks.initBlockRecipes();
		
        // Initialise the declaration of the mic junk items
        ModItems.micJunk();
        
        // Initialise the check for the latest version of ebm
        VersionHelper.execute();
        
        // Initialise the tick handler for the version checking
        TickRegistry.registerTickHandler(new VersionCheckTickHandler(), Side.CLIENT);
	}

	/**
	 * The final stage of initialisation by fml
	 * @param event
	 */
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	    // Say that i am all done and ready
		System.out.println("ExtraBlocks Initialized");
	}
}