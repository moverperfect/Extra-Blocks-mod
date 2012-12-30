package extraBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockTinBlock extends Block {

	public BlockTinBlock(int par1, int par2) {
		super(par1, par2, Material.iron);
		setStepSound(soundMetalFootstep);
	}

	public String getTextureFile(){
		return "/textures/Blocks.png";
	}

}
