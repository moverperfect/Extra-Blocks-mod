package moverperfect.ExtraBlocks;

import net.minecraft.src.Block;
import net.minecraft.src.Material;

public class BlockTinOre extends Block {

	public BlockTinOre(int par1, int par2) {
		super(par1, par2, Material.rock);
		
		setStepSound(soundStoneFootstep);
	}
	
	public String getTextureFile(){
		return "/textures/Blocks.png";
	}

}
