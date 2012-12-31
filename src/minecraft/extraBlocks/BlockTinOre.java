package extraBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockTinOre extends Block {

	public BlockTinOre(int par1, int par2) {
		super(par1, par2, Material.rock);
		
		setStepSound(soundStoneFootstep);
	}
	
	public String getTextureFile(){
		return "/textures/Blocks.png";
	}

}
