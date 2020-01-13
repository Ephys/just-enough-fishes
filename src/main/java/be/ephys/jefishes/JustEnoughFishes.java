package be.ephys.jefishes;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = JustEnoughFishes.MODID, name = JustEnoughFishes.NAME, version = JustEnoughFishes.VERSION)
public class JustEnoughFishes
{
    public static final String MODID = "jefishes";
    public static final String NAME = "Just Enough Fishes";
    public static final String VERSION = "1.0.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }
}
