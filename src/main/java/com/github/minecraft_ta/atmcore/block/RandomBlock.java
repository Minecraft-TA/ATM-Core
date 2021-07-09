package com.github.minecraft_ta.atmcore.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class RandomBlock extends Block {

    public RandomBlock() {
        super(Material.IRON);
        setCreativeTab(CreativeTabs.REDSTONE);
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new RandomBlockTile();
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }
}
