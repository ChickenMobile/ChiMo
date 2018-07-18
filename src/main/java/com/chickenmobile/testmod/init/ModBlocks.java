package com.chickenmobile.testmod.init;

import java.util.ArrayList;
import java.util.List;
import com.chickenmobile.testmod.blocks.BlockBase;
import com.chickenmobile.testmod.blocks.GuilStandBlock;
import com.chickenmobile.testmod.blocks.SmileyBlock;
import com.chickenmobile.testmod.blocks.TestBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;


public class ModBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block TEST_BLOCK = new TestBlock("test_block", Material.CLOTH);
	
	public static final Block GUIL_STAND_BLOCK = new GuilStandBlock("guil_stand_block");
	
	public static final Block SMILEY_BLOCK = new SmileyBlock();
	
}
