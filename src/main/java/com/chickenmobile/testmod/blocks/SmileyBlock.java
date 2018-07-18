package com.chickenmobile.testmod.blocks;

import com.chickenmobile.testmod.util.IHasModel;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;


public class SmileyBlock extends BlockDirectional implements IHasModel {
	
	public static final String name = "smiley_block";
	
	public SmileyBlock() {
		super(name, Material.SPONGE); // Material sound when placed
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
}