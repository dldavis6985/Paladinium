package paladiniumWorldgen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class Worldgen implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		int depth = 32;
		int[] coords = {chunkX, depth, chunkZ};
		
		if(random.nextInt(15) == 1){
			
			coords[0] *= 16; coords[0] += random.nextInt(16);
			coords[2] *= 16; coords[1] += random.nextInt(16);
			coords[1] += random.nextInt(12);
			
			int randomInt = random.nextInt(3);
			int i = 0;
			for(i = 0; i < randomInt; i += 1){
				if(world.getBlockId(coords[0], coords[1], coords[2]) != 0){
					
		        	world.setBlockWithNotify(coords[0], coords[1], coords[2], 2000);
		        	System.out.println("coords: " + coords[0] + ", " + coords[1] + ", " + coords[2]); 
		        	
				}
				coords[random.nextInt(2)] += 1;
			}
		}
		
	}

}
