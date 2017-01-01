package paladinium;

import paladinium.soundhandler.PaladiniumSoundHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void registerPreLoad(){
		MinecraftForge.EVENT_BUS.register(new PaladiniumSoundHandler());
	}
	
	@Override
	public void registerOnLoad(){
		MinecraftForgeClient.preloadTexture("/PaladiniumTextures.png");
		MinecraftForge.EVENT_BUS.register(new PaladiniumSoundHandler());
		
		super.registerOnLoad();
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}
}
