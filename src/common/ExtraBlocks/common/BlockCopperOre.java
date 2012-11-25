package ExtraBlocks.common;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;

public class BlockCopperOre extends Block {

	public BlockCopperOre(int par1, int par2) {
		super(par1, par2, Material.rock);
		setStepSound(stepSound);
	};
	
	public String getTextureFile(){
		return "/textures/Blocks.png";
	}

};
