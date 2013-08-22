package com.moverperfect.ebm;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
import com.moverperfect.ebm.block.ModBlocks;
import com.moverperfect.ebm.configuration.ConfigurationHandler;
import com.moverperfect.ebm.core.handlers.ExtraBlocksFuelHandler;
import com.moverperfect.ebm.core.handlers.ExtraBlocksWorldGen;
import com.moverperfect.ebm.core.helper.LogHelper;
import com.moverperfect.ebm.core.helper.VersionHelper;
import com.moverperfect.ebm.core.proxy.ClientProxy;
import com.moverperfect.ebm.core.proxy.CommonProxy;
import com.moverperfect.ebm.creativetab.CreativeTabEBM;
import com.moverperfect.ebm.item.ModItems;
import com.moverperfect.ebm.lib.Reference;
import com.moverperfect.ebm.core.handlers.VersionCheckTickHandler;

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
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

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
@Mod (modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION_NUMBER)

public class ExtraBlocksMain {
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static ClientProxy cproxy;
	
	@Instance(Reference.MOD_ID)
	public static ExtraBlocksMain instance;
	
	public static final CreativeTabs tabsEBM = new CreativeTabEBM(CreativeTabs.getNextID(), "chicken");
	
	@Init
	public void load(FMLInitializationEvent event){
		
		LanguageRegistry.instance().addStringLocalization("itemGroup.EBM", "en_US", "Extra Blocks");

		GameRegistry.registerWorldGenerator(new ExtraBlocksWorldGen());
		
		// Register the fuel handler
		GameRegistry.registerFuelHandler(new ExtraBlocksFuelHandler());
	};
	
	// Say i am initialising and sort out config files
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println("ExtraBlocks Loading config file");
		
		ConfigurationHandler.init(new File(event.getModConfigurationDirectory().getAbsolutePath() + "\\" + Reference.MOD_ID + ".cfg"));
		
		LogHelper.init();
	      
        ModBlocks.init();
        
        ModItems.init();
        
        ModBlocks.furnace();
        
        ModBlocks.initBlockRecipes();
		
        ModItems.micJunk();
        
        VersionHelper.execute();
        
        TickRegistry.registerTickHandler(new VersionCheckTickHandler(), Side.CLIENT);
	}
	
	// Say i have been initialised
	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		System.out.println("ExtraBlocks Initialized");
	}
}

