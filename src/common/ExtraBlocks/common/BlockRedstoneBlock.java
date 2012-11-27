package ExtraBlocks.common;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;

public class BlockRedstoneBlock extends Block {

	public BlockRedstoneBlock(int par1, int par2) {
		super(par1, par2, Material.iron);
		setStepSound(soundMetalFootstep);
	}

	public String getTextureFile(){
		return "/textures/Blocks.png";
	}
	public boolean canProvidePower() {
		return true;
	}

}
