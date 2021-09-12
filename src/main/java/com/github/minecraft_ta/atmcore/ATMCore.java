package com.github.minecraft_ta.atmcore;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Logger;


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

}