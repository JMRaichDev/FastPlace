package me.mimosa.fastplace;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.lang.reflect.Field;

@Mod(modid = FastPlace.MODID, version = FastPlace.VERSION, name = FastPlace.NAME)
public class FastPlace
{
    public static final String MODID = "fastplace";
    public static final String VERSION = "1.0";
    public static final String NAME = "FastPlace";
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }
    @SubscribeEvent
    public void onTick(TickEvent event) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
        try {
            Field f = Minecraft.getMinecraft().getClass().getDeclaredField("rightClickDelayTimer");
            f.setAccessible(true);
            f.set(Minecraft.getMinecraft(), 0);
        } catch(Exception e) {
            try {
                Field f = Minecraft.getMinecraft().getClass().getDeclaredField("field_71467_ac");
                f.setAccessible(true);
                f.set(Minecraft.getMinecraft(), 0);
            } catch(Exception ee) {
                e.printStackTrace();
                ee.printStackTrace();
            }
        }
    }
}
