package com.chickenmobile.testmod.init;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import com.chickenmobile.testmod.items.ItemBase;
import com.chickenmobile.testmod.items.armor.ArmorBase;
import com.chickenmobile.testmod.items.tools.ToolSpade;
import com.chickenmobile.testmod.items.tools.ToolSword;
import com.chickenmobile.testmod.util.Reference;

public class ModItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	// Materials
	public static final ToolMaterial MATERIAL_TEST = EnumHelper.addToolMaterial("material_test", 2, 250, 6.0F, 1.0F, 10);
	
	public static final ArmorMaterial ARMOR_MATERIAL_TEST = EnumHelper.addArmorMaterial(
			"armor_material_test", Reference.MOD_ID + ":test", 10, new int[] {2, 4, 3, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	
	// Items
	public static final Item TEST_ITEM = new ItemBase("test_item");
	
	// Tools
	public static final ItemSword TEST_SWORD = new ToolSword("test_sword", MATERIAL_TEST);
	public static final ItemSpade TEST_SPADE = new ToolSpade("test_spade", MATERIAL_TEST);
	
	// Armor
	public static final Item TEST_HELMET = new ArmorBase("test_helmet", ARMOR_MATERIAL_TEST, 1, EntityEquipmentSlot.HEAD);
	public static final Item TEST_CHESTPLATE = new ArmorBase("test_chestplate", ARMOR_MATERIAL_TEST, 1, EntityEquipmentSlot.CHEST);
	public static final Item TEST_LEGGINGS = new ArmorBase("test_leggings", ARMOR_MATERIAL_TEST, 2, EntityEquipmentSlot.LEGS);
	public static final Item TEST_BOOTS = new ArmorBase("test_boots", ARMOR_MATERIAL_TEST, 1, EntityEquipmentSlot.FEET);
	
}
