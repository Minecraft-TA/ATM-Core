package com.github.minecraft_ta.atmcore;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

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

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        System.out.println("Hello world!");
    }
}
