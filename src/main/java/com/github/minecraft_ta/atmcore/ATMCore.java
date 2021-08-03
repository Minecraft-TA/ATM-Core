package com.github.minecraft_ta.atmcore;

import com.github.minecraft_ta.atmcore.block.RandomBlock;
import com.github.minecraft_ta.atmcore.block.RandomBlockTile;
import com.github.minecraft_ta.atmcore.implementation.RandomCounter;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Logger;

import java.util.Objects;
import java.util.Random;


@Mod(
        modid = ATMCore.MOD_ID,
        name = ATMCore.MOD_NAME,
        version = ATMCore.VERSION

)
public class ATMCore {

    public static final String MOD_ID = "atm_core";
    public static final String MOD_NAME = "ATM Core";
    public static final String VERSION = "1.0.0";

    @Mod.Instance
    public static ATMCore INSTANCE;

    public static Logger LOGGER;
    private long timeStamp;

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        LOGGER = event.getModLog();
        GameRegistry.registerTileEntity(RandomBlockTile.class, new ResourceLocation(MOD_ID, "random_block_tile"));
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onServerTick(TickEvent.WorldTickEvent event) {
  /*      if (event.side.isServer()) {
            World world = event.world;
            Random rand = world.rand;
            if ((System.currentTimeMillis() - timeStamp) >= 1000) {
                if (rand instanceof RandomCounter) {
                  *//*  int counter = ((RandomCounter) rand).getCounter();
                    world.playerEntities.forEach(entityPlayer ->
                            entityPlayer.sendMessage(new TextComponentString("Random calls in " + world.provider.getDimensionType().getName() + ": ").setStyle(new Style().setColor(TextFormatting.AQUA))
                                    .appendSibling(new TextComponentString(counter + "").setStyle(new Style().setColor(TextFormatting.GOLD)))));
                    LOGGER.info("Random calls: " + counter);
                    ((RandomCounter) rand).setCounter(0);*//*

                    for (WorldServer worldServer : Objects.requireNonNull(world.getMinecraftServer()).worlds) {
                        LOGGER.info(worldServer.provider.getDimensionType().getName() + " " + worldServer.provider.getDimensionType().getId());

                    }
                }
                timeStamp = System.currentTimeMillis();
            }
        }*/
    }

    @GameRegistry.ObjectHolder(MOD_ID)
    public static class Blocks {
        public static final RandomBlock RANDOM_BLOCK = null;
    }

    @GameRegistry.ObjectHolder(MOD_ID)
    public static class Items {
        public static final ItemBlock RANDOM_BLOCK_ITEM = null;
    }

    @Mod.EventBusSubscriber
    public static class ObjectRegistryHandler {

        @SubscribeEvent
        public static void addItems(RegistryEvent.Register<Item> event) {
            event.getRegistry().register(new ItemBlock(Blocks.RANDOM_BLOCK).setRegistryName(Blocks.RANDOM_BLOCK.getRegistryName()));
        }

        @SubscribeEvent
        public static void addBlocks(RegistryEvent.Register<Block> event) {
            event.getRegistry().register(new RandomBlock().setRegistryName(new ResourceLocation(MOD_ID, "random_block")));
        }

        @SubscribeEvent
        public static void registerRenders(ModelRegistryEvent event) {
            registerRender(Item.getItemFromBlock(Blocks.RANDOM_BLOCK));
        }

        public static void registerRender(Item item) {
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        }
    }
}
