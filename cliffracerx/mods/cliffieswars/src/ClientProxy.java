package cliffracerx.mods.cliffieswars.src;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy
{
    //@Override
    public static void registerRenderers()
    {
        RenderingRegistry.registerEntityRenderingHandler(LaserEntity.class, new RenderLaser());
        RenderingRegistry.registerEntityRenderingHandler(RPGEntity.class, new RenderRPG());
        MinecraftForgeClient.registerItemRenderer(CliffiesWars.rDeathrayID+256, new DeathrayRenderer());
        MinecraftForgeClient.registerItemRenderer(CliffiesWars.oDeathrayID+256, new DeathrayRenderer());
        MinecraftForgeClient.registerItemRenderer(CliffiesWars.yDeathrayID+256, new DeathrayRenderer());
        MinecraftForgeClient.registerItemRenderer(CliffiesWars.lDeathrayID+256, new DeathrayRenderer());
        MinecraftForgeClient.registerItemRenderer(CliffiesWars.gDeathrayID+256, new DeathrayRenderer());
        MinecraftForgeClient.registerItemRenderer(CliffiesWars.cDeathrayID+256, new DeathrayRenderer());
        MinecraftForgeClient.registerItemRenderer(CliffiesWars.bDeathrayID+256, new DeathrayRenderer());
        MinecraftForgeClient.registerItemRenderer(CliffiesWars.pDeathrayID+256, new DeathrayRenderer());
        MinecraftForgeClient.registerItemRenderer(CliffiesWars.rRPGID+256, new RPGLauncherRender());
        MinecraftForgeClient.registerItemRenderer(CliffiesWars.oRPGID+256, new RPGLauncherRender());
        MinecraftForgeClient.registerItemRenderer(CliffiesWars.yRPGID+256, new RPGLauncherRender());
        MinecraftForgeClient.registerItemRenderer(CliffiesWars.lRPGID+256, new RPGLauncherRender());
        MinecraftForgeClient.registerItemRenderer(CliffiesWars.gRPGID+256, new RPGLauncherRender());
        MinecraftForgeClient.registerItemRenderer(CliffiesWars.cRPGID+256, new RPGLauncherRender());
        MinecraftForgeClient.registerItemRenderer(CliffiesWars.bRPGID+256, new RPGLauncherRender());
        MinecraftForgeClient.registerItemRenderer(CliffiesWars.pRPGID+256, new RPGLauncherRender());
    }

    @SideOnly(Side.CLIENT)
    public static int addArmour(String armour)
    {
         return RenderingRegistry.addNewArmourRendererPrefix(armour);
    }
}
