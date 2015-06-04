package com.moverperfect.ebm.core.handlers;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

/**
 * Extra-Blocks-Mod
 * 
 * ExtraBlocksWorldGen
 * 
 * @author Moverperfect
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ExtraBlocksWorldGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		switch(world.provider.dimensionId){
		case -1: generateNether(world, random, chunkX*16, chunkZ*16);
        case 0: generateSurface(world, random, chunkX*16, chunkZ*16);
		}
	}
	
	
	public void generateSurface(World world, Random random, int blockX, int blockZ){
		{/*
			if (ExtraBlocksMain.copperOreBool) {
				for (int i = 1; i < 10;i++) {
					
					int Xcoord = blockX + random.nextInt(16);
					int Ycoord = random.nextInt(60);
					int Zcoord = blockZ + random.nextInt(16);
					(new WorldGenMinable(ExtraBlocksMain.copperOreID, 10)).generate(world, random, Xcoord, Ycoord, Zcoord);
				}
			};
			if (ExtraBlocksMain.copperOreBool) {
				for (int i = 1; i < 10;i++) {
					
					int Xcoord = blockX + random.nextInt(16);
					int Ycoord = random.nextInt(60);
					int Zcoord = blockZ + random.nextInt(16);
					(new WorldGenMinable(ExtraBlocksMain.tinOreID, 10)).generate(world, random, Xcoord, Ycoord, Zcoord);
				}
			}
			*/
		}
}	
	public void generateNether(World world, Random random, int blockX, int blockZ){
        
        
        
    }
}
