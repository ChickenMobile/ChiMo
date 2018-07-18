package com.chickenmobile.testmod.init;

import com.chickenmobile.testmod.headdrop.MobBeheading;

import net.minecraftforge.common.MinecraftForge;


public class ModEvents {
	public static void init() {
		MinecraftForge.EVENT_BUS.register(new MobBeheading());
	}
}
