package com.chickenmobile.testmod.blocks;

import java.util.HashMap;
import java.util.Map;

import com.chickenmobile.testmod.Main;
import com.chickenmobile.testmod.init.ModBlocks;
import com.chickenmobile.testmod.init.ModItems;
import com.chickenmobile.testmod.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBase extends Block implements IHasModel {

	public static final String TILE_DATA_TAG = "BCTileData";
    protected boolean isFullCube = true;
    private boolean ifcSet = false;
    protected boolean canProvidePower = false;
    protected boolean hasSubItemTypes = false;
    public Map<Integer, String> nameOverrides = new HashMap<>();
    
	
	public BlockBase(Material material) {
		super(material);
	}
	
	public BlockBase(String name, Material material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	
	
	//region Setters & Getters

    public BlockBase setHarvestTool(String toolClass, int level) {
        this.setHarvestLevel(toolClass, level);
        return this;
    }
	
    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        ItemStack stack = super.getPickBlock(state, target, world, pos, player);

        if (stack.getItem() == Item.getItemFromBlock(this) && stack.getItem().getHasSubtypes()) {
            stack.setItemDamage(getMetaFromState(state));
        }

        return stack;
    }
	
    
    public boolean uberIsBlockFullCube() {
        return !ifcSet || isFullCube;
    }
    
    @Override
    public boolean isFullCube(IBlockState state) {
        return uberIsBlockFullCube();
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return uberIsBlockFullCube();
    }
    
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
