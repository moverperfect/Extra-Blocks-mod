package com.moverperfect.ebm;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;

import com.moverperfect.ebm.block.ModBlocks;
import com.moverperfect.ebm.configuration.ConfigurationHandler;
import com.moverperfect.ebm.core.handlers.ExtraBlocksFuelHandler;
import com.moverperfect.ebm.core.handlers.ExtraBlocksWorldGen;
import com.moverperfect.ebm.core.helper.LogHelper;
import com.moverperfect.ebm.core.helper.VersionHelper;
import com.moverperfect.ebm.core.proxy.CommonProxy;
import com.moverperfect.ebm.creativetab.CreativeTabEBM;
import com.moverperfect.ebm.item.ModItems;
import com.moverperfect.ebm.lib.Reference;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * Extra-Blocks-Mod
 * 
 * ExtraBlocksMain
 * 
 * @author Moverperfect
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

@NetworkMod(clientSideRequired = true, serverSideRequired = false)
@Mod (modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)

public class ExtraBlocksMain {
	
    // TODO Single file for ingots
    
    
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;	
	
	@Instance(Reference.MOD_ID)
	public static ExtraBlocksMain instance;
	
	public static CreativeTabs tabsEBM = new CreativeTabEBM(CreativeTabs.getNextID(), Reference.MOD_ID);
	
	@Init
	public void load(FMLInitializationEvent event){
		
		LanguageRegistry.instance().addStringLocalization("itemGroup.EBM", "en_US", "Extra Blocks");

							
		// Non-metal blocks
		proxy.registerRenderThings();
		
		GameRegistry.registerWorldGenerator(new ExtraBlocksWorldGen());
		
		
		//if(seedsToBreadBool) {GameRegistry.addRecipe(new ItemStack (Item.bread,2),new Object[]{"###","###","###", Character.valueOf('#'), Item.seeds});};
		
		
		// Register the fuel handler
		GameRegistry.registerFuelHandler(new ExtraBlocksFuelHandler());
	};
	
	// Say i am initialising and sort out config files
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println("ExtraBlocks Loading config file");
		
		ConfigurationHandler.init(new File(event.getModConfigurationDirectory().getAbsolutePath()  + "\\config\\" + Reference.MOD_ID + ".cfg"));
		
		LogHelper.init();
	      
        ModBlocks.init();
        
        ModItems.init();
        
        ModBlocks.furnace();
        
        ModBlocks.initBlockRecipes();
		
		// TODO Version helper Needs Work 
		VersionHelper.execute();
	}
	
	// Say i have been initialised
	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		System.out.println("ExtraBlocks Initialized");
	}
}

