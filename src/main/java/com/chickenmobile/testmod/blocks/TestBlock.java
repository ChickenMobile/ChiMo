package com.chickenmobile.testmod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class TestBlock extends BlockBase {

	public TestBlock(String name, Material material) {
		super(name, material); // Material sound when placed
		
		setSoundType(SoundType.CLOTH); // Sound makes while walking on
		setHardness(3.0F); // How long it takes to mine with tool
		setResistance(10.0F); // Blast resistance
		setHarvestLevel("pickaxe", 1); // Tool type and mining level
		setLightLevel(1.0F); // Emits light
		//setLightOpacity(1); // Light can go through this block (1/0)
		//setBlockUnbreakable(); // Block can never be destroyed
	}

}
