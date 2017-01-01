package paladinium.items;

import net.minecraft.item.Item;

public class PaladiniumIngot extends Item{

	public PaladiniumIngot(int par1, int index) {
		super(par1);
		this.setIconIndex(index);
	}

	@Override
	public String getTextureFile()
    {
            return "/PaladiniumTextures.png";
    }
	
}
