package ExtraBlocks.common;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
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


@NetworkMod(clientSideRequired = true, serverSideRequired = false)
@Mod (modid = "extraBlocksMod", name = "extraBlocksMod", version = "0.1.0")

public class ExtraBlocksMain {
	
	@SidedProxy(clientSide = "ExtraBlocks.client.ClientProxyExtraBlocks", serverSide = "ExtraBlocks.common.CommonProxyExtraBlocks")
	public static CommonProxyExtraBlocks proxy;	
	
	@Instance("extrablocks")
	public static ExtraBlocksMain instance;
	
	public static int copperOreID;
	public static int copperBlockID;
	public static int tinOreID;
	public static int tinBlockID;
	public static int redstoneBlockID;
	public static int coalBlockID;
	public static int copperIngotID;
	public static int copperSwordID;
	public static int copperShovelID;
	public static int copperPickaxeID;
	public static int copperAxeID;
	public static int copperHoeID;
	public static int tinIngotID;
		
	static EnumToolMaterial EnumToolMaterialCopper = EnumHelper.addToolMaterial("COPPER", 2, 200, 7.0F, 2, 14);
	// TODO Add tin tools and Enum
	
	// Game registry/ Language registry
	@Init
	public void load(FMLInitializationEvent event){
		
		// Blocks
		final Block copperOre = new BlockCopperOre(copperOreID,0).setHardness(4F).setResistance(10F).setBlockName("Copper Ore").setCreativeTab(CreativeTabs.tabBlock);
		final Block copperBlock = new BlockCopperBlock(copperBlockID,1).setHardness(4F).setResistance(10F).setBlockName("Copper Block").setCreativeTab(CreativeTabs.tabDecorations);
		final Block tinOre = new BlockTinOre(tinOreID,2).setHardness(4F).setResistance(10F).setBlockName("Tin Ore").setCreativeTab(CreativeTabs.tabBlock);
		final Block tinBlock = new BlockTinBlock(tinBlockID,3).setHardness(4F).setResistance(10F).setBlockName("Tin Block").setCreativeTab(CreativeTabs.tabDecorations);

		// Non-metal blocks
		final Block redstoneBlock = new BlockRedstoneBlock(redstoneBlockID,4).setHardness(4F).setResistance(10F).setBlockName("Redstone Block").setCreativeTab(CreativeTabs.tabDecorations);
		final Block coalBlock = new BlockCoalBlock(coalBlockID,5).setHardness(4F).setResistance(10F).setBlockName("Coal Block").setCreativeTab(CreativeTabs.tabDecorations);
		
		// Copper Ingot
		final Item copperIngot = new ItemCopperIngot(copperIngotID).setCreativeTab(CreativeTabs.tabMaterials).setItemName("Copper Ore").setIconCoord(0,0);	
		
		// Copper tools
		final Item copperSword = new ItemSword(copperSwordID, EnumToolMaterialCopper).setCreativeTab(CreativeTabs.tabCombat).setItemName("Copper Sword").setIconCoord(1,0);
		final Item copperShovel = new ItemSpade(copperShovelID, EnumToolMaterialCopper).setCreativeTab(CreativeTabs.tabTools).setItemName("Copper Shovel").setIconCoord(2,0);
		final Item copperPickaxe = new ItemPickaxe(copperPickaxeID, EnumToolMaterialCopper).setCreativeTab(CreativeTabs.tabTools).setItemName("Copper Pickaxe").setIconCoord(3,0);
		final Item copperAxe = new ItemAxe(copperAxeID, EnumToolMaterialCopper).setCreativeTab(CreativeTabs.tabTools).setItemName("Copper Axe").setIconCoord(4,0);
		final Item copperHoe = new ItemHoe(copperHoeID, EnumToolMaterialCopper).setCreativeTab(CreativeTabs.tabTools).setItemName("Copper Hoe").setIconCoord(5,0);
			
		// Tin Items
		final Item tinIngot = new ItemTinIngot(1510).setCreativeTab(CreativeTabs.tabMaterials).setItemName("Tin Ore").setIconCoord(6,0);
		System.out.println("Now here");

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
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println("ExtraBlocks Loading config file");
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		
		copperOreID = config.getBlock("Copper Ore", 1500).getInt();
		copperBlockID = config.getBlock("Copper Block", 1501).getInt();
		copperIngotID = config.getItem("Copper Ingot", 1502).getInt();
		copperSwordID = config.getItem("Copper Sword", 1503).getInt();
		copperShovelID = config.getItem("Copper Shovel", 1504).getInt();
		copperPickaxeID = config.getItem("Copper Pickaxe", 1505).getInt();
		copperAxeID = config.getItem("Copper Axe", 1506).getInt();
		copperHoeID = config.getItem("Copper Hoe", 1507).getInt();
		tinOreID = config.getBlock("Tin Ore", 1508).getInt();
		tinBlockID = config.getBlock("Tin Block", 1509).getInt();
		tinIngotID = config.getItem("Tin Ingot", 1510).getInt();
		// TODO All tin tools
		redstoneBlockID = config.getBlock("Redstone Block", 1516).getInt();
		coalBlockID = config.getBlock("Coal Block", 1517).getInt();
		
		// TODO Add ability to not have the ores/blocks whatever
		
		config.save();
	}
	
	// Say i have been initialised
	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		System.out.println("ExtraBlocks Initialized");
	}
}
