package com.chickenmobile.testmod.blocks;

import com.chickenmobile.testmod.util.IHasModel;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;


public class GuilStandBlock extends BlockBase implements IHasModel {

	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	public static final AxisAlignedBB GUIL_STAND_BLOCK_AABB = new AxisAlignedBB(0, 0, 0, 1, 1, 1); // x1, y1, z1, x2, y2, z2
	
	
	public GuilStandBlock(String name) {
		super(name, Material.WOOD);
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state){
		return false;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return GUIL_STAND_BLOCK_AABB;
	}

	
}
