package ExtraBlocks.common;

import net.minecraft.src.Block;
import net.minecraft.src.CraftingManager;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
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
@Mod (modid = "extraBlocksMod", name = "extraBlocksMod", version = "0.4.0")

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
	public static int tinSwordID;
	public static int tinShovelID;
	public static int tinPickaxeID;
	public static int tinAxeID;
	public static int tinHoeID;
	
	public static int blockToolsID;
	
	public static boolean copperOreBool;
	public static boolean tinOreBool;
	public static boolean seedsToBreadBool;
	public static boolean copperToolsBool;
	public static boolean tinToolsBool;
	
	public static boolean blockToolsBool;
		
	// Enum helper: Name, HarvestLevel, Maxuses, Efficiency, Damage, Enchantability
	static EnumToolMaterial EnumToolMaterialCopper = EnumHelper.addToolMaterial("COPPER", 2, 200, 7.0F, 2, 14);
	static EnumToolMaterial EnumToolMaterialTin = EnumHelper.addToolMaterial("TIN", 2, 300, 7.5F, 2, 14);
	static EnumToolMaterial EnumToolMaterialWood = EnumHelper.addToolMaterial("WOOD", 0 , 236 , 2.0F , 0 , 15 );
	static EnumToolMaterial EnumToolMaterialStoneBrick = EnumHelper.addToolMaterial("STONE BRICK", 1 , 524 , 4.0F , 1 , 5);
	static EnumToolMaterial EnumToolMaterialIronBlock = EnumHelper.addToolMaterial("IRON BLOCK", 2 ,2250 , 6.0F , 2 , 14 );
	static EnumToolMaterial EnumToolMaterialDiamondBlock = EnumHelper.addToolMaterial("DIAMOND BLOCK", 3 , 14049 , 8.0F , 3, 10);
	static EnumToolMaterial EnumToolMaterialGoldBlock = EnumHelper.addToolMaterial("GOLD BLOCK", 0 , 288, 12.0F, 0, 22);
	
	
	// Game registry/ Language registry
	@Init
	public void load(FMLInitializationEvent event){
		
		
		
		// Blocks
		if (copperOreBool){	
			final Block copperOre = new BlockCopperOre(copperOreID,0).setHardness(4F).setResistance(10F).setBlockName("Copper Ore").setCreativeTab(CreativeTabs.tabBlock);
			final Block copperBlock = new BlockCopperBlock(copperBlockID,1).setHardness(4F).setResistance(10F).setBlockName("Copper Block").setCreativeTab(CreativeTabs.tabDecorations);
			final Item copperIngot = new ItemCopperIngot(copperIngotID).setCreativeTab(CreativeTabs.tabMaterials).setItemName("Copper Ingot").setIconCoord(0,0);	

			GameRegistry.registerBlock(copperOre);
			GameRegistry.registerBlock(copperBlock);
			
			LanguageRegistry.addName(copperOre, "Copper Ore");
			LanguageRegistry.addName(copperBlock, "Copper Block");
			LanguageRegistry.addName(copperIngot, "Copper Ingot");
			
			OreDictionary.registerOre("ingotCopper", new ItemStack(copperIngot));
			OreDictionary.registerOre("oreCopper", new ItemStack(copperOre));
			OreDictionary.registerOre("blockCopper", new ItemStack(copperBlock));
			
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack (copperBlock,1), new Object[]{"###", "###", "###", Character.valueOf('#'), "ingotCopper"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack (copperIngot,9), new Object[]{"blockCopper"}));
			
			GameRegistry.addSmelting(copperOre.blockID, new ItemStack(copperIngot), 0.1F);
		};

		if (copperToolsBool) {
			final Item copperSword = new ItemSword(copperSwordID, EnumToolMaterialCopper).setCreativeTab(CreativeTabs.tabCombat).setItemName("Copper Sword").setIconCoord(1,0);
			final Item copperShovel = new ItemSpade(copperShovelID, EnumToolMaterialCopper).setCreativeTab(CreativeTabs.tabTools).setItemName("Copper Shovel").setIconCoord(2,0);
			final Item copperPickaxe = new ItemPickaxe(copperPickaxeID, EnumToolMaterialCopper).setCreativeTab(CreativeTabs.tabTools).setItemName("Copper Pickaxe").setIconCoord(3,0);
			final Item copperAxe = new ItemAxe(copperAxeID, EnumToolMaterialCopper).setCreativeTab(CreativeTabs.tabTools).setItemName("Copper Axe").setIconCoord(4,0);
			final Item copperHoe = new ItemHoe(copperHoeID, EnumToolMaterialCopper).setCreativeTab(CreativeTabs.tabTools).setItemName("Copper Hoe").setIconCoord(5,0);
			
			LanguageRegistry.addName(copperSword,"Copper Sword");
			LanguageRegistry.addName(copperShovel,"Copper Shovel");
			LanguageRegistry.addName(copperPickaxe,"Copper Pickaxe");
			LanguageRegistry.addName(copperAxe,"Copper Axe");
			LanguageRegistry.addName(copperHoe,"Copper Hoe");
			
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack (copperSword), new Object[]{"#","#","s",Character.valueOf('#'), "ingotCopper", ('s'),Item.stick}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack (copperShovel), new Object[]{"#","s","s",Character.valueOf('#'), "ingotCopper", ('s'),Item.stick}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack (copperPickaxe), new Object[]{"###"," s "," s ",Character.valueOf('#'), "ingotCopper", ('s'),Item.stick}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack (copperAxe), new Object[]{"##","#s"," s",Character.valueOf('#'), "ingotCopper", ('s'), Item.stick}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack (copperHoe),new Object[]{"##"," s"," s",Character.valueOf('#'), "ingotCopper", ('s'), Item.stick}));
		};
	
		if (tinOreBool){	
			final Block tinOre = new BlockTinOre(tinOreID,2).setHardness(4F).setResistance(10F).setBlockName("Tin Ore").setCreativeTab(CreativeTabs.tabBlock);
			final Block tinBlock = new BlockTinBlock(tinBlockID,3).setHardness(4F).setResistance(10F).setBlockName("Tin Block").setCreativeTab(CreativeTabs.tabDecorations);
			final Item tinIngot = new ItemTinIngot(1510).setCreativeTab(CreativeTabs.tabMaterials).setItemName("Tin Ingot").setIconCoord(0,1);
			
			GameRegistry.registerBlock(tinOre);
			GameRegistry.registerBlock(tinBlock);
			
			LanguageRegistry.addName(tinOre, "Tin Ore");
			LanguageRegistry.addName(tinBlock, "Tin Block");
			LanguageRegistry.addName(tinIngot,"Tin Ingot");
			 
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack (tinBlock,1), new Object[]{"###", "###", "###", Character.valueOf('#'), "ingotTin"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack (tinIngot,9), new Object[]{tinBlock}));
				 
			GameRegistry.addSmelting(tinOre.blockID, new ItemStack(tinIngot), 0.1F);
			 
			OreDictionary.registerOre("blockTin", new ItemStack(tinBlock));
			OreDictionary.registerOre("oreTin", new ItemStack(tinOre));
			OreDictionary.registerOre("ingotTin", new ItemStack(tinIngot));
		};
		
		if (tinToolsBool) {
			final Item tinSword = new ItemSword(tinSwordID, EnumToolMaterialTin).setCreativeTab(CreativeTabs.tabCombat).setItemName("Tin Sword").setIconCoord(1,1);
			final Item tinShovel = new ItemSpade(tinShovelID, EnumToolMaterialTin).setCreativeTab(CreativeTabs.tabTools).setItemName("Tin Shovel").setIconCoord(2,1);
			final Item tinPickaxe = new ItemPickaxe(tinPickaxeID, EnumToolMaterialTin).setCreativeTab(CreativeTabs.tabTools).setItemName("Tin Pickaxe").setIconCoord(3,1);
			final Item tinAxe = new ItemAxe(tinAxeID, EnumToolMaterialTin).setCreativeTab(CreativeTabs.tabTools).setItemName("Tin Axe").setIconCoord(4,1);
			final Item tinHoe = new ItemHoe(tinHoeID, EnumToolMaterialTin).setCreativeTab(CreativeTabs.tabTools).setItemName("Tin Hoe").setIconCoord(5,1);
			
			LanguageRegistry.addName(tinSword,"Tin Sword");
			LanguageRegistry.addName(tinShovel,"Tin Shovel");
			LanguageRegistry.addName(tinPickaxe,"Tin Pickaxe");
			LanguageRegistry.addName(tinAxe,"Tin Axe");
			LanguageRegistry.addName(tinHoe,"Tin Hoe");
			
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack (tinSword), new Object[]{"#","#","s",Character.valueOf('#'), "ingotTin", ('s'),Item.stick}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack (tinShovel), new Object[]{"#","s","s",Character.valueOf('#'), "ingotTin", ('s'),Item.stick}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack (tinPickaxe), new Object[]{"###"," s "," s ",Character.valueOf('#'), "ingotTin", ('s'),Item.stick}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack (tinAxe), new Object[]{"##","#s"," s",Character.valueOf('#'), "ingotTin", ('s'), Item.stick}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack (tinHoe),new Object[]{"##"," s"," s",Character.valueOf('#'), "ingotTin", ('s'), Item.stick}));
		
		}
		
		if (blockToolsBool) {
			// TODO Register the tools, WOOD, STONE, IRON, DIAMOND, GOLD
			
			final Item woodSword = new ItemSword(700, EnumToolMaterialWood).setCreativeTab(CreativeTabs.tabCombat).setItemName("Wood Sword").setIconCoord(0,2);
			final Item woodShovel = new ItemSpade(701, EnumToolMaterialWood).setCreativeTab(CreativeTabs.tabTools).setItemName("Wood Shovel").setIconCoord(1,2);
			final Item woodPickaxe = new ItemPickaxe(702, EnumToolMaterialWood).setCreativeTab(CreativeTabs.tabTools).setItemName("Wood Pickaxe").setIconCoord(2,2);
			final Item woodAxe = new ItemAxe(703, EnumToolMaterialWood).setCreativeTab(CreativeTabs.tabTools).setItemName("Wood Axe").setIconCoord(3,2);
			final Item woodHoe = new ItemHoe(704, EnumToolMaterialWood).setCreativeTab(CreativeTabs.tabTools).setItemName("Wood Hoe").setIconCoord(4,2);
			
			LanguageRegistry.addName(woodSword,"Wood Sword");
			LanguageRegistry.addName(woodShovel,"Wood Shovel");
			LanguageRegistry.addName(woodPickaxe,"Wood Pickaxe");
			LanguageRegistry.addName(woodAxe,"Wood Axe");
			LanguageRegistry.addName(woodHoe,"Wood Hoe");
			
			// TODO Block tools recipies, WOOD, STONE, IRON, DIAMOND, GOLD
			
		}
							
		// Non-metal blocks
		final Block redstoneBlock = new BlockRedstoneBlock(redstoneBlockID,4).setHardness(4F).setResistance(10F).setBlockName("Redstone Block").setCreativeTab(CreativeTabs.tabDecorations);
		final Block coalBlock = new BlockCoalBlock(coalBlockID,5).setHardness(4F).setResistance(10F).setBlockName("Coal Block").setCreativeTab(CreativeTabs.tabDecorations).setLightValue(14);
		
		proxy.registerRenderThings();
		
		GameRegistry.registerBlock(redstoneBlock);
		GameRegistry.registerBlock(coalBlock);
		
		GameRegistry.registerWorldGenerator(new extraBlocksWorldGen());
		
		LanguageRegistry.addName(redstoneBlock, "Redstone Block");
		LanguageRegistry.addName(coalBlock, "Coal Block");
		
		OreDictionary.registerOre("blockRedstone", new ItemStack(redstoneBlock));
		OreDictionary.registerOre("blockCoal", new ItemStack(coalBlock));

		GameRegistry.addRecipe(new ItemStack (redstoneBlock,1), new Object[]{"###", "###", "###", Character.valueOf('#'), Item.redstone});
		GameRegistry.addRecipe(new ItemStack (coalBlock,1), new Object[]{"###", "# #", "###", Character.valueOf('#'), Item.coal});
		
		if(seedsToBreadBool) {GameRegistry.addRecipe(new ItemStack (Item.bread,2),new Object[]{"###","###","###", Character.valueOf('#'), Item.seeds});};
		
		GameRegistry.addShapelessRecipe(new ItemStack (Item.redstone,9), new Object[]{redstoneBlock});
		GameRegistry.addShapelessRecipe(new ItemStack (Item.coal,8), new Object[]{coalBlock});
		
		// Register the fuel handler
		GameRegistry.registerFuelHandler(new ExtraBlocksFuelHandler());
				
	}
	
	// Say i am initialising and sort out config files
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
		tinSwordID = config.getItem("Tin Sword", 1511).getInt();
		tinShovelID = config.getItem("Tin Shovel", 1512).getInt();
		tinPickaxeID = config.getItem("Tin Pickaxe", 1513).getInt();
		tinAxeID = config.getItem("Tin Axe", 1514).getInt();
		tinHoeID = config.getItem("Tin Hoe", 1515).getInt();
		
		blockToolsID = config.getItem("The first ID that it should use(it takes 25 ID's in total", 1550).getInt();
		
		redstoneBlockID = config.getBlock("Redstone Block", 1516).getInt();
		coalBlockID = config.getBlock("Coal Block", 1517).getInt();
		
		copperOreBool = config.get(Configuration.CATEGORY_GENERAL, "Enable_CopperOre/Ingots", true).getBoolean(true);
		tinOreBool = config.get(Configuration.CATEGORY_GENERAL, "Enable_TinOre/Ingots", true).getBoolean(true);
		
		tinToolsBool = config.get(Configuration.CATEGORY_GENERAL, "Enable_TinTools", true).getBoolean(true);
		copperToolsBool = config.get(Configuration.CATEGORY_GENERAL, "Enable_CopperTools", true).getBoolean(true);
		
		seedsToBreadBool = config.get(Configuration.CATEGORY_GENERAL, "SeedsToBreadRecipe", true).getBoolean(true);

		blockToolsBool = config.get(Configuration.CATEGORY_GENERAL, "'Block' Tools", true).getBoolean(true);
		
		config.save();
	}
	
	// Say i have been initialised
	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		System.out.println("ExtraBlocks Initialized");
	}
}

