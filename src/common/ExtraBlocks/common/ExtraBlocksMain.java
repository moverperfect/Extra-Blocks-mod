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
import net.minecraftforge.oredict.OreDictionary;

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
		
		public static final Block redstoneBlock = new BlockCopperBlock(1516,4).setHardness(4F).setResistance(10F).setBlockName("Redstone Block").setCreativeTab(CreativeTabs.tabDecorations);
		public static final Block coalBlock = new BlockCoalBlock(1517,5).setHardness(4F).setResistance(10F).setBlockName("Coal Block").setCreativeTab(CreativeTabs.tabDecorations);
		
		// Copper Ingot
		public static final Item copperIngot = new ItemCopperIngot(1502).setCreativeTab(CreativeTabs.tabMaterials).setItemName("Copper Ore").setIconCoord(0,0);	
		
		// Copper tools
		public static final Item copperSword = new ItemSword(1503, EnumToolMaterial.IRON).setCreativeTab(CreativeTabs.tabCombat).setItemName("Copper Sword").setIconCoord(1,0);
		public static final Item copperShovel = new ItemSpade(1504, EnumToolMaterial.IRON).setCreativeTab(CreativeTabs.tabTools).setItemName("Copper Shovel").setIconCoord(2,0);
		public static final Item copperPickaxe = new ItemPickaxe(1505, EnumToolMaterial.IRON).setCreativeTab(CreativeTabs.tabTools).setItemName("Copper Pickaxe").setIconCoord(3,0);
		public static final Item copperAxe = new ItemAxe(1506, EnumToolMaterial.IRON).setCreativeTab(CreativeTabs.tabTools).setItemName("Copper Axe").setIconCoord(4,0);
		public static final Item copperHoe = new ItemHoe(1507, EnumToolMaterial.IRON).setCreativeTab(CreativeTabs.tabTools).setItemName("Copper Hoe").setIconCoord(5,0);
		
		// Tin Items
		public static final Item tinIngot = new ItemTinIngot(1510).setCreativeTab(CreativeTabs.tabMaterials).setItemName("Tin Ore").setIconCoord(6,0);
		
		
	// Game registry/ Language registry
	@Init
	public void load(FMLInitializationEvent event){
		
		proxy.registerRenderThings();
		
		// Registering the Blocks
		GameRegistry.registerBlock(copperOre);
		GameRegistry.registerBlock(copperBlock);
		GameRegistry.registerBlock(tinOre);
		GameRegistry.registerBlock(tinBlock);
		
		GameRegistry.registerBlock(redstoneBlock);
		GameRegistry.registerBlock(coalBlock);
		
		// Registering the custom world generation
		GameRegistry.registerWorldGenerator(new extraBlocksWorldGen());
		
		// Registering the name of the Blocks
		LanguageRegistry.addName(copperOre, "Copper Ore");
		LanguageRegistry.addName(copperBlock, "Copper Block");
		LanguageRegistry.addName(tinOre, "Tin Ore");
		LanguageRegistry.addName(tinBlock, "Tin Block");
		
		LanguageRegistry.addName(redstoneBlock, "Redstone Block");
		LanguageRegistry.addName(coalBlock, "Coal Block");
		
		// Registering the name of the copper Items
		LanguageRegistry.addName(copperIngot, "Copper Ingot");
		LanguageRegistry.addName(copperSword,"Copper Sword");
		LanguageRegistry.addName(copperShovel,"Copper Shovel");
		LanguageRegistry.addName(copperPickaxe,"Copper Pickaxe");
		LanguageRegistry.addName(copperAxe,"Copper Axe");
		LanguageRegistry.addName(copperHoe,"Copper Hoe");
		
		// Registering the name of the tin Items
		LanguageRegistry.addName(tinIngot,"Tin Ingot");
		
		// Adding the recipe for making the blocks and 'unmaking' the blocks
		// Metal Blocks
		GameRegistry.addRecipe(new ItemStack (copperBlock,1), new Object[]{"###", "###", "###", Character.valueOf('#'), copperIngot});
		GameRegistry.addRecipe(new ItemStack (tinBlock,1), new Object[]{"###", "###", "###", Character.valueOf('#'), tinIngot});
		
		// Non-metal blocks
		GameRegistry.addRecipe(new ItemStack (redstoneBlock,1), new Object[]{"###", "###", "###", Character.valueOf('#'), Item.redstone});
		GameRegistry.addRecipe(new ItemStack (coalBlock,1), new Object[]{"###", "# #", "###", Character.valueOf('#'), Item.coal});
		// This may seem a bit OP but it fits in with EE's EMC value's
		GameRegistry.addRecipe(new ItemStack (Item.bread,2),new Object[]{"###","###","###", Character.valueOf('#'), Item.seeds});
		
		// Uncrafting metal blocks
		GameRegistry.addShapelessRecipe(new ItemStack (copperIngot,9), new Object[]{copperBlock});
		GameRegistry.addShapelessRecipe(new ItemStack (tinIngot,9), new Object[]{tinBlock});
		
		// Uncrafting no-metal blocks
		GameRegistry.addShapelessRecipe(new ItemStack (Item.redstone,9), new Object[]{redstoneBlock});
		GameRegistry.addShapelessRecipe(new ItemStack (Item.coal,8), new Object[]{coalBlock});
		
		// Adding the recipe for making the copper tools
		GameRegistry.addRecipe(new ItemStack (copperSword), new Object[]{"#","#","s",Character.valueOf('#'), copperIngot, ('s'),Item.stick});
		GameRegistry.addRecipe(new ItemStack (copperShovel), new Object[]{"#","s","s",Character.valueOf('#'), copperIngot, ('s'),Item.stick});
		GameRegistry.addRecipe(new ItemStack (copperPickaxe), new Object[]{"###"," s "," s ",Character.valueOf('#'), copperIngot, ('s'),Item.stick});
		GameRegistry.addRecipe(new ItemStack (copperAxe), new Object[]{"##","#s"," s",Character.valueOf('#'), copperIngot, ('s'), Item.stick});
		GameRegistry.addRecipe(new ItemStack (copperHoe),new Object[]{"##","s","s",Character.valueOf('#'), copperIngot, ('s'), Item.stick});
		
		// Registering the smelting to make the ingot
		GameRegistry.addSmelting(copperOre.blockID, new ItemStack(copperIngot), 0.1F);
		GameRegistry.addSmelting(tinOre.blockID, new ItemStack(tinIngot), 0.1F);
		
		
		/* TODO Add ores to ore dictionary
		OreDictionary.registerOre("ingotCopper", new ItemStack(copperIngot));
		OreDictionary.registerOre("ingotTin", new ItemStack(tinIngot));
		OreDictionary.registerOre("oreCopper", new ItemStack(copperOre));
		OreDictionary.registerOre("oreTin", new ItemStack(tinOre));
		OreDictionary.registerOre("blockRedstone", new ItemStack(redstoneBlock));
		OreDictionary.registerOre("blockCopper", new ItemStack(copperBlock));
		OreDictionary.registerOre("blockTin", new ItemStack(tinBlock));
		*/
		
		
		
	}
	
	/* TODO add coal block as fuel
	public int addFuel(int par1, int par2)
	{
		System.out.println("Im here!!!!!!!!");
	if(par1 == coalBlock.blockID)
	{
	return 12800;
	}
	         return 0;
	}
	*/
	
	// Say i am initialising
	@PreInit
	public void init(FMLPreInitializationEvent preEvent) {
		System.out.println("ExtraBlocks Initializing");
	}
	
	// Say i have been initialised
	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		System.out.println("ExtraBlocks Initialized");
	}
}
