package paladinium.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.creativetab.CreativeTabs;

public class PaladiniumBlock extends BlockStone{
	
	public PaladiniumBlock(int blockId, int textureIndex){
		super(blockId,textureIndex);
		setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	public String getTextureFile()
    {
            return "/PaladiniumTextures.png";
    }
	
	public int idDropped(int par1, Random par2Random, int par3)
    {
        return PaladiniumBlocks.PaladiniumBlock.blockID;
    }
	
}
