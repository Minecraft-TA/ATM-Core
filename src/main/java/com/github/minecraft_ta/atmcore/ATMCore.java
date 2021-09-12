package com.github.minecraft_ta.atmcore;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.util.*;


@Mod(
        modid = ATMCore.MOD_ID,
        name = ATMCore.MOD_NAME,
        version = ATMCore.VERSION

)
public class ATMCore {

    static {
        try {
            Field methodsField = HttpURLConnection.class.getDeclaredField("methods");

            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(methodsField, methodsField.getModifiers() & ~Modifier.FINAL);

            methodsField.setAccessible(true);

            String[] oldMethods = (String[]) methodsField.get(null);
            Set<String> methodsSet = new LinkedHashSet<>(Arrays.asList(oldMethods));
            methodsSet.addAll(Arrays.asList("CONNECT", "PATCH"));
            String[] newMethods = methodsSet.toArray(new String[0]);

            methodsField.set(null, newMethods);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }

    public static final String MOD_ID = "atm_core";
    public static final String MOD_NAME = "ATM Core";
    public static final String VERSION = "1.0.0";

    @Mod.Instance
    public static ATMCore INSTANCE;

    public static Logger LOGGER;

}