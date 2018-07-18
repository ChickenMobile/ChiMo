package com.chickenmobile.testmod.util.handlers;

import com.chickenmobile.testmod.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class LootTableHandler {
	public static final ResourceLocation CENTAUR = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "centaur"));
}
