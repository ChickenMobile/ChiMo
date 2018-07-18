package com.chickenmobile.testmod.init;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

	public static void init() {
		GameRegistry.addSmelting(ModItems.TEST_ITEM, new ItemStack(ModBlocks.TEST_BLOCK, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.TEST_BLOCK, new ItemStack(Blocks.DIAMOND_BLOCK, 1), 1.0F);
	}
}
