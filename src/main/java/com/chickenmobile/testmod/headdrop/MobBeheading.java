package com.chickenmobile.testmod.headdrop;

import java.util.ArrayList;
import java.util.ListIterator;

import com.mojang.authlib.GameProfile;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerList;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayerMP;


public class MobBeheading {
		
	/*
	 * When a creature dies and drops fall
	 */
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onEntityLivingDeath(LivingDeathEvent event) {
		EntityLivingBase entityLiving = event.getEntityLiving();
		World world = entityLiving.getEntityWorld();
		
		ItemStack head = getHeadDrop(entityLiving); // The head to drop
		EntityItem entityitem = new EntityItem(world, entityLiving.posX, entityLiving.posY, entityLiving.posZ, head); // entity and position in world
        //entityitem.setDefaultPickupDelay(); // 10 delay
        world.spawnEntity(entityitem); // Spawn entity in world
	}
	
	/*
	 * Check if a head has already dropped ????
	 */
	private boolean alreadyContainsDrop(LivingDropsEvent event, ItemStack head) {
	    return event.getDrops().stream().map(EntityItem::getItem).anyMatch(drop -> ItemStack.areItemStacksEqual(drop, head));
	}
	
	/*
	 * Get the type of item to drop. Only works for vanilla heads
	 */
	private ItemStack getHeadDrop(EntityLivingBase entity) {
	    // meta 0: skeleton
	    if(entity instanceof EntitySkeleton) {
	    	return new ItemStack(Items.SKULL, 1, 0);
	    }
	    // meta 1: wither skeleton
	    else if(entity instanceof EntityWitherSkeleton) {
	    	return new ItemStack(Items.SKULL, 1, 1);
	    }
	    // meta 2: zombie
	    else if(entity instanceof EntityZombie) {
	    	return new ItemStack(Items.SKULL, 1, 2);
	    }
	    // meta 4: creeper
	    else if(entity instanceof EntityCreeper) {
	    	return new ItemStack(Items.SKULL, 1, 4);
	    }
	    // meta 3: player
	    else if(entity instanceof EntityPlayer) {
	    	ItemStack head = new ItemStack(Items.SKULL, 1, 3);
	    	NBTUtil.writeGameProfile(head.getOrCreateSubCompound("SkullOwner"), ((EntityPlayer)entity).getGameProfile());
	    	//NBTUtil.writeGameProfile(head.getOrCreateSubCompound("SkullOwner"), getPlayer(entity.getEntityWorld(), "ChickenMobile"));
	    	return head;
	    }
	    else {
	    	return new ItemStack(Items.SKULL, 1, 5);
	    }

	    // no head
	    //return null;
	}
	
	public GameProfile getPlayer(World world, String name) {
		PlayerList playerList = world.getMinecraftServer().getPlayerList();
		EntityPlayerMP player = playerList.getPlayerByUsername(name);
		
		if(player.getGameProfile().getName().equals(name)) {
			return player.getGameProfile();
		}
		
		return null;
	}
	
}
