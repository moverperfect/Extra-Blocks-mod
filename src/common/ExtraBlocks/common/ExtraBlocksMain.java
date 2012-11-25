package ExtraBlocks.common;

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
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;

@NetworkMod(clientSideRequired = true, serverSideRequired = false)
@Mod (modid = "extraBlocksMod", name = "extraBlocksMod", version = "0.1.0")

public class ExtraBlocksMain {
	
	@SidedProxy(clientSide = "ExtraBlocks.client.ClientProxyExtraBlocks", serverSide = "ExtraBlocks.common.CommonProxyExtraBlocks")
	public static CommonProxyExtraBlocks proxy;	
	
	@Instance("extrablocks")
	public static ExtraBlocksMain instance;
	
	
	// Blocks
		public static final Block copperOre = new BlockCopperOre(1500,0).setHardness(4F).setResistance(10F).setBlockName("Copper Ore").setCreativeTab(CreativeTabs.tabBlock);
		public static final Block copperBlock = new BlockCopperBlock(1501,1).setHardness(4F).setResistance(10F).setBlockName("Copper Block").setCreativeTab(CreativeTabs.tabDecorations);
		public static final Block tinOre = new BlockTinOre(1508,2).setHardness(4F).setResistance(10F).setBlockName("Tin Ore").setCreativeTab(CreativeTabs.tabBlock);
		public static final Block tinBlock = new BlockCopperBlock(1509,3).setHardness(4F).setResistance(10F).setBlockName("Tin Block").setCreativeTab(CreativeTabs.tabDecorations);
		
		// Copper Items
		public static final Item copperIngot = new ItemCopperIngot(1502).setCreativeTab(CreativeTabs.tabMaterials).setItemName("Copper Ore").setIconCoord(0,0);	
		/** public static final Item copperSword = new ItemSword(1503, EnumToolMaterial.COPPER).setCreativeTab(CreativeTabs.tabCombat).setItemName("Copper Sword").setIconCoord(1,0);
		public static final Item copperShovel = new ItemSpade(1504, EnumToolMaterial.COPPER).setCreativeTab(CreativeTabs.tabTools).setItemName("Copper Shovel").setIconCoord(2,0);
		public static final Item copperPickaxe = new ItemPickaxe(1505, EnumToolMaterial.COPPER).setCreativeTab(CreativeTabs.tabTools).setItemName("Copper Pickaxe").setIconCoord(3,0);
		public static final Item copperAxe = new ItemAxe(1506, EnumToolMaterial.COPPER).setCreativeTab(CreativeTabs.tabTools).setItemName("Copper Axe").setIconCoord(4,0);
		public static final Item copperHoe = new ItemHoe(1507, EnumToolMaterial.COPPER).setCreativeTab(CreativeTabs.tabTools).setItemName("Copper Hoe").setIconCoord(5,0);
		*/
		// Tin Items
		public static final Item tinIngot = new ItemTinIngot(15010).setCreativeTab(CreativeTabs.tabMaterials).setItemName("Tin Ore").setIconCoord(6,0);
		
	@Init
	public void load(FMLInitializationEvent event){
		
		proxy.registerRenderThings();
		
		// Registering the Blocks
		GameRegistry.registerBlock(copperOre);
		GameRegistry.registerBlock(copperBlock);
		GameRegistry.registerBlock(tinOre);
		GameRegistry.registerBlock(tinBlock);
		
		// Registering the custom world generation
		GameRegistry.registerWorldGenerator(new extraBlocksWorldGen());
		
		// Registering the name of the Blocks
		LanguageRegistry.addName(copperOre, "Copper Ore");
		LanguageRegistry.addName(copperBlock, "Copper Block");
		LanguageRegistry.addName(tinOre, "Tin Ore");
		LanguageRegistry.addName(tinBlock, "Tin Block");
		
		// Registering the name of the copper Items
		LanguageRegistry.addName(copperIngot, "Copper Ingot");
		/**LanguageRegistry.addName(copperSword,"Copper Sword");
		LanguageRegistry.addName(copperShovel,"Copper Shovel");
		LanguageRegistry.addName(copperPickaxe,"Copper Pickaxe");
		LanguageRegistry.addName(copperAxe,"Copper Axe");
		LanguageRegistry.addName(copperHoe,"Copper Hoe");
		*/
		// Registering the name of the tin Items
		LanguageRegistry.addName(tinIngot,"Tin Ingot");
		
		// Adding the recipe for making the blocks and 'unmaking' the blocks
		GameRegistry.addRecipe(new ItemStack (copperBlock,1), new Object[]{"###", "###", "###", Character.valueOf('#'), copperIngot});
		GameRegistry.addRecipe(new ItemStack (tinBlock,1), new Object[]{"###", "###", "###", Character.valueOf('#'), tinIngot});
		GameRegistry.addRecipe(new ItemStack (copperIngot), new Object[]{"#","","",Character.valueOf('#'), copperBlock});
		GameRegistry.addRecipe(new ItemStack (tinIngot), new Object[]{"#","","",Character.valueOf('#'), tinBlock});
		
		// Adding the recipe for making the copper tools
		/**GameRegistry.addRecipe(new ItemStack (copperSword), new Object[]{"#","#","s",Character.valueOf('#'), copperIngot, ('s'),Item.stick});
		GameRegistry.addRecipe(new ItemStack (copperShovel), new Object[]{"#","s","s",Character.valueOf('#'), copperIngot, ('s'),Item.stick});
		GameRegistry.addRecipe(new ItemStack (copperPickaxe), new Object[]{"###"," s "," s ",Character.valueOf('#'), copperIngot, ('s'),Item.stick});
		GameRegistry.addRecipe(new ItemStack (copperAxe), new Object[]{"##","#s"," s",Character.valueOf('#'), copperIngot, ('s'), Item.stick});
		GameRegistry.addRecipe(new ItemStack (copperHoe),new Object[]{"##","s","s",Character.valueOf('#'), copperIngot, ('s'), Item.stick});
		*/
		// Registering the smelting to make the ingot
		GameRegistry.addSmelting(copperOre.blockID, new ItemStack(copperIngot), 0.1F);
		GameRegistry.addSmelting(tinOre.blockID, new ItemStack(tinIngot), 0.1F);
		
	}
	@PreInit
	public void init(FMLPreInitializationEvent preEvent) {
		System.out.println("ExtraBlocks Initializing");
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		System.out.println("ExtraBlocks Initialized");
	}
}
