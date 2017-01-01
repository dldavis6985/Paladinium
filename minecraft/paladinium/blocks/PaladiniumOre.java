package paladinium.blocks;

import java.util.Random;

import net.minecraft.block.BlockStone;
import net.minecraft.creativetab.CreativeTabs;

public class PaladiniumOre extends BlockStone{
	
	public PaladiniumOre(int blockId, int textureIndex){
		super(blockId,textureIndex);
		setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	public String getTextureFile()
    {
            return "/PaladiniumTextures.png";
    }
	
	public int idDropped(int par1, Random par2Random, int par3)
    {
        return PaladiniumBlocks.PaladiniumOre.blockID;
    }
}
