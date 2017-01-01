package paladinium.items;


import net.minecraft.block.Block;
import paladinium.blocks.PaladiniumBlocks;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;


public class PaladiniumItems {
	
	public static Item basicSword = (new PaladinSword(938, EnumToolMaterial.IRON, 1, 0, false, 4, false)).setItemName("basicSword");
	public static Item critSword = (new PaladinSword(939, EnumToolMaterial.IRON, 3, 10, false, 6, false)).setItemName("critSword");
	public static Item lifeStealer = (new PaladinSword(940, EnumToolMaterial.IRON, 4, 0, true, 6, false)).setItemName("lifeStealer");
	public static Item scalingSword = (new PaladinSword(941, EnumToolMaterial.IRON, 5, 0, false, 4, true)).setItemName("scalingSword");
	public static Item paladinSword = (new PaladinSword(942, EnumToolMaterial.IRON, 6, 5, true, 2, true)).setItemName("PaladinSword");
	public static Item ingotPaladinium = (new PaladiniumIngot(945, 2)).setIconIndex(2).setItemName("paladiniumIngot").setCreativeTab(CreativeTabs.tabMaterials);
	
	public static void addItems(){
		GameRegistry.registerItem(basicSword, basicSword.getItemName());
		GameRegistry.registerItem(critSword, critSword.getItemName());
		GameRegistry.registerItem(lifeStealer, lifeStealer.getItemName());
		GameRegistry.registerItem(scalingSword, scalingSword.getItemName());
		GameRegistry.registerItem(paladinSword, paladinSword.getItemName());
		GameRegistry.registerItem(ingotPaladinium, ingotPaladinium.getItemName());
		
		
		LanguageRegistry.addName(basicSword, "Paladin Training Sword");
		LanguageRegistry.addName(critSword, "Precise Paladin Sword");
		LanguageRegistry.addName(lifeStealer, "Leeching Paladin Sword");
		LanguageRegistry.addName(scalingSword, "Harnessed Paladin Sword");
		LanguageRegistry.addName(paladinSword, "Paladin Sword of Blinding Light");
		LanguageRegistry.addName(ingotPaladinium, "Paladinium Ingot");
		
		
		GameRegistry.addSmelting(PaladiniumBlocks.PaladiniumOre.blockID, new ItemStack(ingotPaladinium, 1),1F);
		
		GameRegistry.addRecipe(new ItemStack(PaladiniumBlocks.PaladiniumBlock, 1), new Object[]{"PPP", "PPP", "PPP", Character.valueOf('P'), ingotPaladinium});
		GameRegistry.addRecipe(new ItemStack(basicSword, 1), new Object[] { "XPX", "XPX", "XSX", Character.valueOf('P'), ingotPaladinium, Character.valueOf('S'), Item.stick});
		GameRegistry.addRecipe(new ItemStack(critSword, 1), new Object[] { "SSS", "SBS", "SSS", Character.valueOf('S'), Block.sandStone , Character.valueOf('B'), basicSword});
		GameRegistry.addRecipe(new ItemStack(lifeStealer, 1), new Object[] { "RPR", "RPR", "RBR", Character.valueOf('R'), Item.redstone , Character.valueOf('B'), basicSword, Character.valueOf('P'), PaladiniumBlocks.PaladiniumBlock});
		GameRegistry.addRecipe(new ItemStack(scalingSword, 1), new Object[] { "LPL", "LPL", "LBL", Character.valueOf('L'), new ItemStack(Item.dyePowder,1,4) , Character.valueOf('B'), basicSword, Character.valueOf('P'), PaladiniumBlocks.PaladiniumBlock});
		GameRegistry.addRecipe(new ItemStack(paladinSword, 1), new Object[] { "PLP", "PSP", "PCP", Character.valueOf('S'), scalingSword , Character.valueOf('L'), lifeStealer, Character.valueOf('P'), PaladiniumBlocks.PaladiniumBlock, Character.valueOf('C'), critSword});
		GameRegistry.addShapelessRecipe(new ItemStack(ingotPaladinium,1), new Object[]{Item.ingotIron, Item.bone, Item.ingotGold});
	}
}
