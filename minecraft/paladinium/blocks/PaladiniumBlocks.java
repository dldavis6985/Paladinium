package paladinium.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;

public class PaladiniumBlocks {
	
	public static final Block PaladiniumOre = new PaladiniumOre(2000, 0).setHardness(10.0F).setResistance(20.0F).setBlockName("PaladiniumOre");
	public static final Block PaladiniumBlock = new PaladiniumBlock(2001, 7).setHardness(10.0F).setResistance(20.0F).setBlockName("PaladiniumBlock");
	
	public static void addBlocks(){
		GameRegistry.registerBlock(PaladiniumOre, PaladiniumOre.getBlockName());
		GameRegistry.registerBlock(PaladiniumBlock, PaladiniumBlock.getBlockName());
		
		LanguageRegistry.addName(PaladiniumOre, "Paladinium Ore");
		LanguageRegistry.addName(PaladiniumBlock, "Paladinium Block");
	}

}
