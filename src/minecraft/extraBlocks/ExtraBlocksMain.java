package extraBlocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
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
@Mod (modid = "ExtraBlocksMod", name = "ExtraBlocksMod", version = "0.4.0")

public class ExtraBlocksMain {
	
	@SidedProxy(clientSide = "extraBlocks.ClientProxyExtraBlocks", serverSide = "ExtraBlocks.CommonProxyExtraBlocks")
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

			GameRegistry.registerBlock(copperOre,"ExtraBlocks_CopperOre");
			GameRegistry.registerBlock(copperBlock,"ExtraBlocks_CopperBlock");
			
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
			final Item tinIngot = new ItemTinIngot(tinIngotID).setCreativeTab(CreativeTabs.tabMaterials).setItemName("Tin Ingot").setIconCoord(0,1);
			
			GameRegistry.registerBlock(tinOre,"ExtraBlocks_TinOre");
			GameRegistry.registerBlock(tinBlock,"ExtraBlocks_TinBlock");
			
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
			// TODO Register the tools, STONE
			
			final Item woodSword = new ItemSword(blockToolsID, EnumToolMaterialWood).setCreativeTab(CreativeTabs.tabCombat).setItemName("Wood Sword").setIconCoord(0,2);
			final Item woodShovel = new ItemSpade(blockToolsID+1, EnumToolMaterialWood).setCreativeTab(CreativeTabs.tabTools).setItemName("Wood Shovel").setIconCoord(1,2);
			final Item woodPickaxe = new ItemPickaxe(blockToolsID+2, EnumToolMaterialWood).setCreativeTab(CreativeTabs.tabTools).setItemName("Wood Pickaxe").setIconCoord(2,2);
			final Item woodAxe = new ItemAxe(blockToolsID+3, EnumToolMaterialWood).setCreativeTab(CreativeTabs.tabTools).setItemName("Wood Axe").setIconCoord(3,2);
			final Item woodHoe = new ItemHoe(blockToolsID+4, EnumToolMaterialWood).setCreativeTab(CreativeTabs.tabTools).setItemName("Wood Hoe").setIconCoord(4,2);
			/*  TODO Balance issues
			 final Item stoneSword = new ItemSword(blockToolsID+5, EnumToolMaterialWood).setCreativeTab(CreativeTabs.tabCombat).setItemName("Wood Sword").setIconCoord(0,3);
			final Item woodShovel = new ItemSpade(blockToolsID+6, EnumToolMaterialWood).setCreativeTab(CreativeTabs.tabTools).setItemName("Wood Shovel").setIconCoord(1,3);
			final Item woodPickaxe = new ItemPickaxe(blockToolsID+7, EnumToolMaterialWood).setCreativeTab(CreativeTabs.tabTools).setItemName("Wood Pickaxe").setIconCoord(2,3);
			final Item woodAxe = new ItemAxe(blockToolsID+8, EnumToolMaterialWood).setCreativeTab(CreativeTabs.tabTools).setItemName("Wood Axe").setIconCoord(3,3);
			final Item woodHoe = new ItemHoe(blockToolsID+9, EnumToolMaterialWood).setCreativeTab(CreativeTabs.tabTools).setItemName("Wood Hoe").setIconCoord(4,3);
			*/
			final Item ironBlockSword = new ItemSword(blockToolsID+10, EnumToolMaterialIronBlock).setCreativeTab(CreativeTabs.tabCombat).setItemName("Iron Block Sword").setIconCoord(0,4);
			final Item ironBlockShovel = new ItemSpade(blockToolsID+11, EnumToolMaterialIronBlock).setCreativeTab(CreativeTabs.tabTools).setItemName("Iron Block Shovel").setIconCoord(1,4);
			final Item ironBlockPickaxe = new ItemPickaxe(blockToolsID+12, EnumToolMaterialIronBlock).setCreativeTab(CreativeTabs.tabTools).setItemName("Iron Block Pickaxe").setIconCoord(2,4);
			final Item ironBlockAxe = new ItemAxe(blockToolsID+13, EnumToolMaterialIronBlock).setCreativeTab(CreativeTabs.tabTools).setItemName("Iron Block Axe").setIconCoord(3,4);
			final Item ironBlockHoe = new ItemHoe(blockToolsID+14, EnumToolMaterialIronBlock).setCreativeTab(CreativeTabs.tabTools).setItemName("Iron Block Hoe").setIconCoord(4,4);
			
			final Item diamondBlockSword = new ItemSword(blockToolsID+15, EnumToolMaterialDiamondBlock).setCreativeTab(CreativeTabs.tabCombat).setItemName("Diamond Block Sword").setIconCoord(0,5);
			final Item diamondBlockShovel = new ItemSpade(blockToolsID+16, EnumToolMaterialDiamondBlock).setCreativeTab(CreativeTabs.tabTools).setItemName("Diamond Block Shovel").setIconCoord(1,5);
			final Item diamondBlockPickaxe = new ItemPickaxe(blockToolsID+17, EnumToolMaterialDiamondBlock).setCreativeTab(CreativeTabs.tabTools).setItemName("Diamond Block Pickaxe").setIconCoord(2,5);
			final Item diamondBlockAxe = new ItemAxe(blockToolsID+18, EnumToolMaterialDiamondBlock).setCreativeTab(CreativeTabs.tabTools).setItemName("Diamond Block Axe").setIconCoord(3,5);
			final Item diamondBlockHoe = new ItemHoe(blockToolsID+19, EnumToolMaterialDiamondBlock).setCreativeTab(CreativeTabs.tabTools).setItemName("Diamond Block Hoe").setIconCoord(4,5);
			
			final Item goldBlockSword = new ItemSword(blockToolsID+20, EnumToolMaterialGoldBlock).setCreativeTab(CreativeTabs.tabCombat).setItemName("Gold Block Sword").setIconCoord(0,6);
			final Item goldBlockShovel = new ItemSpade(blockToolsID+21, EnumToolMaterialGoldBlock).setCreativeTab(CreativeTabs.tabTools).setItemName("Gold Block Shovel").setIconCoord(1,6);
			final Item goldBlockPickaxe = new ItemPickaxe(blockToolsID+22, EnumToolMaterialGoldBlock).setCreativeTab(CreativeTabs.tabTools).setItemName("Gold Block Pickaxe").setIconCoord(2,6);
			final Item goldBlockAxe = new ItemAxe(blockToolsID+23, EnumToolMaterialGoldBlock).setCreativeTab(CreativeTabs.tabTools).setItemName("Gold Block Axe").setIconCoord(3,6);
			final Item goldBlockHoe = new ItemHoe(blockToolsID+24, EnumToolMaterialGoldBlock).setCreativeTab(CreativeTabs.tabTools).setItemName("Gold Block Hoe").setIconCoord(4,6);
			
			LanguageRegistry.addName(woodSword,"Wood Sword");
			LanguageRegistry.addName(woodShovel,"Wood Shovel");
			LanguageRegistry.addName(woodPickaxe,"Wood Pickaxe");
			LanguageRegistry.addName(woodAxe,"Wood Axe");
			LanguageRegistry.addName(woodHoe,"Wood Hoe");
			
			/*
			LanguageRegistry.addName(stoneSword,"Stone Sword");
			LanguageRegistry.addName(stoneShovel,"Stone Shovel");
			LanguageRegistry.addName(stonePickaxe,"Stone Pickaxe");
			LanguageRegistry.addName(stoneAxe,"Stone Axe");
			LanguageRegistry.addName(stoneHoe,"Stone Hoe");
			 */
			
			LanguageRegistry.addName(ironBlockSword,"Iron Block Sword");
			LanguageRegistry.addName(ironBlockShovel,"Iron Block Shovel");
			LanguageRegistry.addName(ironBlockPickaxe,"Iron Block Pickaxe");
			LanguageRegistry.addName(ironBlockAxe,"Iron Block Axe");
			LanguageRegistry.addName(ironBlockHoe,"Iron Block Hoe");
			
			LanguageRegistry.addName(diamondBlockSword,"Diamond Block Sword");
			LanguageRegistry.addName(diamondBlockShovel,"Diamond Block Shovel");
			LanguageRegistry.addName(diamondBlockPickaxe,"Diamond Block Pickaxe");
			LanguageRegistry.addName(diamondBlockAxe,"Diamond Block Axe");
			LanguageRegistry.addName(diamondBlockHoe,"Diamond Block Hoe");
			
			LanguageRegistry.addName(goldBlockSword,"Gold Block Sword");
			LanguageRegistry.addName(goldBlockShovel,"Gold Block Shovel");
			LanguageRegistry.addName(goldBlockPickaxe,"Gold Block Pickaxe");
			LanguageRegistry.addName(goldBlockAxe,"Gold Block Axe");
			LanguageRegistry.addName(goldBlockHoe,"Gold Block Hoe");
			
			// TODO Block tools recipies, STONE
			
			GameRegistry.addRecipe(new ItemStack(woodSword), new Object[]{"#","#","s",Character.valueOf('#'), Block.wood, ('s'),Item.stick});
			GameRegistry.addRecipe(new ItemStack(woodShovel),new Object[]{"#","s","s",Character.valueOf('#'), Block.wood, ('s'),Item.stick});
			GameRegistry.addRecipe(new ItemStack(woodPickaxe), new Object[]{"###"," s "," s ",Character.valueOf('#'), Block.wood, ('s'),Item.stick});
			GameRegistry.addRecipe(new ItemStack(woodAxe),new Object[]{"##","#s"," s",Character.valueOf('#'), Block.wood, ('s'), Item.stick});
			GameRegistry.addRecipe(new ItemStack(woodHoe), new Object[]{"##"," s"," s",Character.valueOf('#'), Block.wood, ('s'), Item.stick});
			
			GameRegistry.addRecipe(new ItemStack(ironBlockSword), new Object[]{"#","#","s",Character.valueOf('#'), Block.blockSteel, ('s'),Item.stick});
			GameRegistry.addRecipe(new ItemStack(ironBlockShovel),new Object[]{"#","s","s",Character.valueOf('#'), Block.blockSteel, ('s'),Item.stick});
			GameRegistry.addRecipe(new ItemStack(ironBlockPickaxe), new Object[]{"###"," s "," s ",Character.valueOf('#'), Block.blockSteel, ('s'),Item.stick});
			GameRegistry.addRecipe(new ItemStack(ironBlockAxe),new Object[]{"##","#s"," s",Character.valueOf('#'), Block.blockSteel, ('s'), Item.stick});
			GameRegistry.addRecipe(new ItemStack(ironBlockHoe), new Object[]{"##"," s"," s",Character.valueOf('#'), Block.blockSteel, ('s'), Item.stick});
			
			GameRegistry.addRecipe(new ItemStack(diamondBlockSword), new Object[]{"#","#","s",Character.valueOf('#'), Block.blockDiamond, ('s'),Item.stick});
			GameRegistry.addRecipe(new ItemStack(diamondBlockShovel),new Object[]{"#","s","s",Character.valueOf('#'), Block.blockDiamond, ('s'),Item.stick});
			GameRegistry.addRecipe(new ItemStack(diamondBlockPickaxe), new Object[]{"###"," s "," s ",Character.valueOf('#'), Block.blockDiamond, ('s'),Item.stick});
			GameRegistry.addRecipe(new ItemStack(diamondBlockAxe),new Object[]{"##","#s"," s",Character.valueOf('#'), Block.blockDiamond, ('s'), Item.stick});
			GameRegistry.addRecipe(new ItemStack(diamondBlockHoe), new Object[]{"##"," s"," s",Character.valueOf('#'), Block.blockDiamond, ('s'), Item.stick});
			
			GameRegistry.addRecipe(new ItemStack(goldBlockSword), new Object[]{"#","#","s",Character.valueOf('#'), Block.blockGold, ('s'),Item.stick});
			GameRegistry.addRecipe(new ItemStack(goldBlockShovel),new Object[]{"#","s","s",Character.valueOf('#'), Block.blockGold, ('s'),Item.stick});
			GameRegistry.addRecipe(new ItemStack(goldBlockPickaxe), new Object[]{"###"," s "," s ",Character.valueOf('#'), Block.blockGold, ('s'),Item.stick});
			GameRegistry.addRecipe(new ItemStack(goldBlockAxe),new Object[]{"##","#s"," s",Character.valueOf('#'), Block.blockGold, ('s'), Item.stick});
			GameRegistry.addRecipe(new ItemStack(goldBlockHoe), new Object[]{"##"," s"," s",Character.valueOf('#'), Block.blockGold, ('s'), Item.stick});

		}
							
		// Non-metal blocks
		final Block redstoneBlock = new BlockRedstoneBlock(redstoneBlockID,4).setHardness(4F).setResistance(10F).setBlockName("Redstone Block").setCreativeTab(CreativeTabs.tabDecorations);
		final Block coalBlock = new BlockCoalBlock(coalBlockID,5).setHardness(4F).setResistance(10F).setBlockName("Coal Block").setCreativeTab(CreativeTabs.tabDecorations).setLightValue(14);
		
		proxy.registerRenderThings();
		
		GameRegistry.registerBlock(redstoneBlock,"ExtraBlocks_RedstoneBlock");
		GameRegistry.registerBlock(coalBlock,"ExtraBlocks_CoalBlock");
		
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
			
		GameRegistry.addRecipe(new ItemStack(Block.planks, 1, 0), new Object[] {"#","#", '#', new ItemStack(Block.woodSingleSlab, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(Block.planks, 1, 2), new Object[] {"#","#", '#', new ItemStack(Block.woodSingleSlab, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(Block.planks, 1, 1), new Object[] {"#","#", '#', new ItemStack(Block.woodSingleSlab, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(Block.planks, 1, 3), new Object[] {"#","#", '#', new ItemStack(Block.woodSingleSlab, 1, 3)});
	};
	// Say i am initialising and sort out config files
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println("ExtraBlocks Loading config file");
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		
		copperOreID = config.getBlock("Copper Ore", 700).getInt(700);
		copperBlockID = config.getBlock("Copper Block", 701).getInt(701);
		
		copperIngotID = config.getItem("Copper Ingot", 7000).getInt(6746);
		copperSwordID = config.getItem("Copper Sword", 7001).getInt(7001);
		copperShovelID = config.getItem("Copper Shovel", 7002).getInt(7002);
		copperPickaxeID = config.getItem("Copper Pickaxe", 7003).getInt(7003);
		copperAxeID = config.getItem("Copper Axe", 7004).getInt(7004);
		copperHoeID = config.getItem("Copper Hoe", 7005).getInt(7005);
		
		tinOreID = config.getBlock("Tin Ore", 702).getInt(702);
		tinBlockID = config.getBlock("Tin Block", 703).getInt(703);
		
		tinIngotID = config.getItem("Tin Ingot", 7006).getInt(7006);
		tinSwordID = config.getItem("Tin Sword", 7007).getInt(7007);
		tinShovelID = config.getItem("Tin Shovel", 7008).getInt(7008);
		tinPickaxeID = config.getItem("Tin Pickaxe", 7009).getInt(7009);
		tinAxeID = config.getItem("Tin Axe", 7010).getInt(7010);
		tinHoeID = config.getItem("Tin Hoe", 7011).getInt(7011);
		
		blockToolsID = config.getItem("The first ID that 'Block' tools should use(it takes 25 ID's in total)", 7012).getInt(7012);
		
		redstoneBlockID = config.getBlock("Redstone Block", 704).getInt(704);
		coalBlockID = config.getBlock("Coal Block", 705).getInt(705);
		
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

