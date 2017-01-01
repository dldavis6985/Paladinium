package paladinium.soundhandler;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.client.audio.SoundManager;
import net.minecraft.client.audio.SoundPoolEntry;
import net.minecraft.world.World;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class PaladiniumSoundHandler {
	
	@ForgeSubscribe
    public void onSound(SoundLoadEvent event){
		SoundManager soundManager = event.manager;
		String[] soundFiles = {
				"crit.wav",
				"life_steal.wav"
		};
		for (int i = 0; i < soundFiles.length; i++)
		{
			try{
				soundManager.soundPoolSounds.addSound(soundFiles[i], this.getClass().getClassLoader().getResource("/" + soundFiles[i]));
	            System.out.printf("Added %s to the sound pool!\n", soundFiles[i]);
			}
			catch (Exception e)
			{
				System.out.println(soundFiles[i] + " failed to load! :(\n");
			}
		}
	}
}