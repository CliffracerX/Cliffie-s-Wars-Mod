package cliffracerx.mods.cliffieswars.src;

import java.util.ArrayList;
import java.util.List;
import cliffracerx.mods.cliffiesdecor.src.EntityMiniDude;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = "CliffiesWarsMod", name = "Cliffie's War mod",
        version = "Alpha 0.01a")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class CliffiesWars
{
    public static CreativeTabs tab = new WarTab("warTab");
    public static StepSound soundMetalFootstep = new StepSound("cliffieswarsmod:clang", 1, 1);
    public static StepSound soundSwooshFootstep = new StepSound("cliffieswarsmod:swoosh", 1, 1);
    public static int dWallID = 3000;
    public static int rWallID = 3001;
    public static int oWallID = 3002;
    public static int yWallID = 3003;
    public static int lWallID = 3004;
    public static int gWallID = 3005;
    public static int cWallID = 3006;
    public static int bWallID = 3007;
    public static int pWallID = 3008;
    public static int fakeTurfID = 3009;
    public static int batteryID = 5009;
    public static int rDeathrayID = 5010;
    public static int oDeathrayID = 5011;
    public static int yDeathrayID = 5012;
    public static int lDeathrayID = 5013;
    public static int gDeathrayID = 5014;
    public static int cDeathrayID = 5015;
    public static int bDeathrayID = 5016;
    public static int pDeathrayID = 5017;
    public static int rRPGID = 5018;
    public static int oRPGID = 5019;
    public static int yRPGID = 5020;
    public static int lRPGID = 5021;
    public static int gRPGID = 5022;
    public static int cRPGID = 5023;
    public static int bRPGID = 5024;
    public static int pRPGID = 5025;
    public static int rocketID = 5026;
    public static Block dWall;
    public static Block rWall;
    public static Block oWall;
    public static Block yWall;
    public static Block lWall;
    public static Block gWall;
    public static Block cWall;
    public static Block bWall;
    public static Block pWall;
    public static Block fakeTurf;
    public static Item battery;
    public static Item rDeathray;
    public static Item oDeathray;
    public static Item yDeathray;
    public static Item lDeathray;
    public static Item gDeathray;
    public static Item cDeathray;
    public static Item bDeathray;
    public static Item pDeathray;
    public static Item rRPG;
    public static Item oRPG;
    public static Item yRPG;
    public static Item lRPG;
    public static Item gRPG;
    public static Item cRPG;
    public static Item bRPG;
    public static Item pRPG;
    public static Item rocket;
    
    @Instance("WarsMod")
    public static CliffiesWars instance = new CliffiesWars();
    
    @SidedProxy(clientSide = "cliffracerx.mods.cliffieswars.src.ClientProxy",
            serverSide = "cliffracerx.mods.cliffieswars.src.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        //Openblocks donation station support.  Support the modders, without them needing to resort to adfly!  =D
        FMLInterModComms.sendMessage("WarsMod", "donateUrl", "http://cliffracerx.github.io/Cliffie-s-Wars-Mod/donate.html");
        //Entities
        EntityRegistry.registerModEntity(LaserEntity.class,
                "EntityLaserOfWars", 0, this, 64, 1, true);
        EntityRegistry.registerModEntity(RPGEntity.class,
                "EntityRPGOfWars", 1, this, 64, 1, true);
        //Config.
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        dWallID = config.get(Configuration.CATEGORY_BLOCK, "Default wall BlockID", 3000).getInt(3000);
        rWallID = config.get(Configuration.CATEGORY_BLOCK, "Red wall BlockID", 3001).getInt(3001);
        oWallID = config.get(Configuration.CATEGORY_BLOCK, "Orange wall BlockID", 3002).getInt(3002);
        yWallID = config.get(Configuration.CATEGORY_BLOCK, "Yellow wall BlockID", 3003).getInt(3003);
        lWallID = config.get(Configuration.CATEGORY_BLOCK, "Lime wall BlockID", 3004).getInt(3004);
        gWallID = config.get(Configuration.CATEGORY_BLOCK, "Green wall BlockID", 3005).getInt(3005);
        cWallID = config.get(Configuration.CATEGORY_BLOCK, "Cyan wall BlockID", 3006).getInt(3006);
        bWallID = config.get(Configuration.CATEGORY_BLOCK, "Blue wall BlockID", 3007).getInt(3007);
        pWallID = config.get(Configuration.CATEGORY_BLOCK, "Purple wall BlockID", 3008).getInt(3008);
        fakeTurfID = config.get(Configuration.CATEGORY_BLOCK, "Fake turf BlockID", 3009).getInt(3009);
        batteryID = config.get(Configuration.CATEGORY_ITEM, "Battery ItemID", 5009).getInt(5009);
        rDeathrayID = config.get(Configuration.CATEGORY_ITEM, "Red deathray ItemID", 5010).getInt(5010);
        oDeathrayID = config.get(Configuration.CATEGORY_ITEM, "Orange deathray ItemID", 5011).getInt(5011);
        yDeathrayID = config.get(Configuration.CATEGORY_ITEM, "Yellow deathray ItemID", 5012).getInt(5012);
        lDeathrayID = config.get(Configuration.CATEGORY_ITEM, "Lime deathray ItemID", 5013).getInt(5013);
        gDeathrayID = config.get(Configuration.CATEGORY_ITEM, "Green deathray ItemID", 5014).getInt(5014);
        cDeathrayID = config.get(Configuration.CATEGORY_ITEM, "Cyan deathray ItemID", 5015).getInt(5015);
        bDeathrayID = config.get(Configuration.CATEGORY_ITEM, "Blue deathray ItemID", 5016).getInt(5016);
        pDeathrayID = config.get(Configuration.CATEGORY_ITEM, "Purple deathray ItemID", 5017).getInt(5017);
        rRPGID = config.get(Configuration.CATEGORY_ITEM, "Red rpg ItemID", 5018).getInt(5018);
        oRPGID = config.get(Configuration.CATEGORY_ITEM, "Orange rpg ItemID", 5019).getInt(5019);
        yRPGID = config.get(Configuration.CATEGORY_ITEM, "Yellow rpg ItemID", 5020).getInt(5020);
        lRPGID = config.get(Configuration.CATEGORY_ITEM, "Lime rpg ItemID", 5021).getInt(5021);
        gRPGID = config.get(Configuration.CATEGORY_ITEM, "Green rpg ItemID", 5022).getInt(5022);
        cRPGID = config.get(Configuration.CATEGORY_ITEM, "Cyan rpg ItemID", 5023).getInt(5023);
        bRPGID = config.get(Configuration.CATEGORY_ITEM, "Blue rpg ItemID", 5024).getInt(5024);
        pRPGID = config.get(Configuration.CATEGORY_ITEM, "Purple rpg ItemID", 5025).getInt(5025);
        rocketID = config.get(Configuration.CATEGORY_ITEM, "RPG/rocket ItemID", 5026).getInt(5026);
        // saving the configuration to its file
        config.save();
    }
    
    @EventHandler
    @SideOnly(Side.CLIENT)
    public void load(FMLInitializationEvent event)
    {
        ClientProxy.registerRenderers();
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        //Block naming and registering
        dWall = new WallBlock(dWallID,
                Material.ground, "defaultPlating").setHardness(15.0F)
                .setStepSound(soundMetalFootstep).setResistance(100.0F)
                .setUnlocalizedName("dWall").setCreativeTab(tab);
        LanguageRegistry.addName(dWall, "Default colored armored wall");
        GameRegistry.registerBlock(dWall, "dWall");
        rWall = new WallBlock(rWallID,
                Material.ground, "rPlating").setHardness(15.0F)
                .setStepSound(soundMetalFootstep).setResistance(100.0F)
                .setUnlocalizedName("rWall").setCreativeTab(tab);
        LanguageRegistry.addName(rWall, "Red colored armored wall");
        GameRegistry.registerBlock(rWall, "rWall");
        oWall = new WallBlock(oWallID,
                Material.ground, "oPlating").setHardness(15.0F)
                .setStepSound(soundMetalFootstep).setResistance(100.0F)
                .setUnlocalizedName("oWall").setCreativeTab(tab);
        LanguageRegistry.addName(oWall, "Orange colored armored wall");
        GameRegistry.registerBlock(oWall, "oWall");
        yWall = new WallBlock(yWallID,
                Material.ground, "yPlating").setHardness(15.0F)
                .setStepSound(soundMetalFootstep).setResistance(100.0F)
                .setUnlocalizedName("yWall").setCreativeTab(tab);
        LanguageRegistry.addName(yWall, "Yellow colored armored wall");
        GameRegistry.registerBlock(yWall, "yWall");
        lWall = new WallBlock(lWallID,
                Material.ground, "lPlating").setHardness(15.0F)
                .setStepSound(soundMetalFootstep).setResistance(100.0F)
                .setUnlocalizedName("lWall").setCreativeTab(tab);
        LanguageRegistry.addName(lWall, "Lime colored armored wall");
        GameRegistry.registerBlock(lWall, "lWall");
        gWall = new WallBlock(gWallID,
                Material.ground, "gPlating").setHardness(15.0F)
                .setStepSound(soundMetalFootstep).setResistance(100.0F)
                .setUnlocalizedName("gWall").setCreativeTab(tab);
        LanguageRegistry.addName(gWall, "Green colored armored wall");
        GameRegistry.registerBlock(gWall, "gWall");
        cWall = new WallBlock(cWallID,
                Material.ground, "cPlating").setHardness(15.0F)
                .setStepSound(soundMetalFootstep).setResistance(100.0F)
                .setUnlocalizedName("cWall").setCreativeTab(tab);
        LanguageRegistry.addName(cWall, "Cyan colored armored wall");
        GameRegistry.registerBlock(cWall, "cWall");
        bWall = new WallBlock(bWallID,
                Material.ground, "bPlating").setHardness(15.0F)
                .setStepSound(soundMetalFootstep).setResistance(100.0F)
                .setUnlocalizedName("bWall").setCreativeTab(tab);
        LanguageRegistry.addName(bWall, "Blue colored armored wall");
        GameRegistry.registerBlock(bWall, "bWall");
        pWall = new WallBlock(pWallID,
                Material.ground, "pPlating").setHardness(15.0F)
                .setStepSound(soundMetalFootstep).setResistance(100.0F)
                .setUnlocalizedName("pWall").setCreativeTab(tab);
        LanguageRegistry.addName(pWall, "Purple colored armored wall");
        GameRegistry.registerBlock(pWall, "pWall");
        fakeTurf = new FakeTurf(fakeTurfID,
                Material.ground, "fakeTurf").setHardness(15.0F)
                .setStepSound(soundSwooshFootstep).setResistance(100.0F)
                .setUnlocalizedName("fakeTurf").setCreativeTab(tab);
        LanguageRegistry.addName(fakeTurf, "Fake turf");
        GameRegistry.registerBlock(fakeTurf, "fakeTurf");
        //Event handler
        MinecraftForge.EVENT_BUS.register(new EventsHandlers());
        //Items
        battery = new BatteryItem(batteryID, "emptyBattery").setUnlocalizedName("emptyBat");
        LanguageRegistry.addName(battery, "Battery");
        rDeathray = new HandheldDeathray(rDeathrayID, "rDeathray", "r").setUnlocalizedName("rDeathray");
        LanguageRegistry.addName(rDeathray, "Red handheld deathray");
        oDeathray = new HandheldDeathray(oDeathrayID, "oDeathray", "o").setUnlocalizedName("oDeathray");
        LanguageRegistry.addName(oDeathray, "Orange handheld deathray");
        yDeathray = new HandheldDeathray(yDeathrayID, "yDeathray", "y").setUnlocalizedName("yDeathray");
        LanguageRegistry.addName(yDeathray, "Yellow handheld deathray");
        lDeathray = new HandheldDeathray(lDeathrayID, "lDeathray", "l").setUnlocalizedName("lDeathray");
        LanguageRegistry.addName(lDeathray, "Lime handheld deathray");
        gDeathray = new HandheldDeathray(gDeathrayID, "gDeathray", "g").setUnlocalizedName("gDeathray");
        LanguageRegistry.addName(gDeathray, "Green handheld deathray");
        cDeathray = new HandheldDeathray(cDeathrayID, "cDeathray", "c").setUnlocalizedName("cDeathray");
        LanguageRegistry.addName(cDeathray, "Cyan handheld deathray");
        bDeathray = new HandheldDeathray(bDeathrayID, "bDeathray", "b").setUnlocalizedName("bDeathray");
        LanguageRegistry.addName(bDeathray, "Blue handheld deathray");
        pDeathray = new HandheldDeathray(pDeathrayID, "pDeathray", "p").setUnlocalizedName("pDeathray");
        LanguageRegistry.addName(pDeathray, "Purple handheld deathray");
        rRPG = new HandheldRocketLauncher(rRPGID, "rRPG", "r").setUnlocalizedName("rRPG");
        LanguageRegistry.addName(rRPG, "Red RPG");
        oRPG = new HandheldRocketLauncher(oRPGID, "oRPG", "o").setUnlocalizedName("oRPG");
        LanguageRegistry.addName(oRPG, "Orange RPG");
        yRPG = new HandheldRocketLauncher(yRPGID, "yRPG", "y").setUnlocalizedName("yRPG");
        LanguageRegistry.addName(yRPG, "Yellow RPG");
        lRPG = new HandheldRocketLauncher(lRPGID, "lRPG", "l").setUnlocalizedName("lRPG");
        LanguageRegistry.addName(lRPG, "Lime RPG");
        gRPG = new HandheldRocketLauncher(gRPGID, "gRPG", "g").setUnlocalizedName("gRPG");
        LanguageRegistry.addName(gRPG, "Green RPG");
        cRPG = new HandheldRocketLauncher(cRPGID, "cRPG", "c").setUnlocalizedName("cRPG");
        LanguageRegistry.addName(cRPG, "Cyan RPG");
        bRPG = new HandheldRocketLauncher(bRPGID, "bRPG", "b").setUnlocalizedName("bRPG");
        LanguageRegistry.addName(bRPG, "Blue RPG");
        pRPG = new HandheldRocketLauncher(pRPGID, "pRPG", "p").setUnlocalizedName("pRPG");
        LanguageRegistry.addName(pRPG, "Purple RPG");
        rocket = new RocketItem(rocketID, "rocket").setUnlocalizedName("RPGAmmo");
        LanguageRegistry.addName(rocket, "RPG ammo");
        //Crafting
        GameRegistry.addRecipe(new ItemStack(rDeathray, 1), "#$", '$', battery, '#', rWall);
        GameRegistry.addRecipe(new ItemStack(oDeathray, 1), "#$", '$', battery, '#', oWall);
        GameRegistry.addRecipe(new ItemStack(yDeathray, 1), "#$", '$', battery, '#', yWall);
        GameRegistry.addRecipe(new ItemStack(lDeathray, 1), "#$", '$', battery, '#', lWall);
        GameRegistry.addRecipe(new ItemStack(gDeathray, 1), "#$", '$', battery, '#', gWall);
        GameRegistry.addRecipe(new ItemStack(cDeathray, 1), "#$", '$', battery, '#', cWall);
        GameRegistry.addRecipe(new ItemStack(bDeathray, 1), "#$", '$', battery, '#', bWall);
        GameRegistry.addRecipe(new ItemStack(pDeathray, 1), "#$", '$', battery, '#', pWall);
        GameRegistry.addRecipe(new ItemStack(rRPG, 1), "#$", '$', dWall, '#', rDeathray);
        GameRegistry.addRecipe(new ItemStack(oRPG, 1), "#$", '$', dWall, '#', oDeathray);
        GameRegistry.addRecipe(new ItemStack(yRPG, 1), "#$", '$', dWall, '#', yDeathray);
        GameRegistry.addRecipe(new ItemStack(lRPG, 1), "#$", '$', dWall, '#', lDeathray);
        GameRegistry.addRecipe(new ItemStack(gRPG, 1), "#$", '$', dWall, '#', gDeathray);
        GameRegistry.addRecipe(new ItemStack(cRPG, 1), "#$", '$', dWall, '#', cDeathray);
        GameRegistry.addRecipe(new ItemStack(bRPG, 1), "#$", '$', dWall, '#', bDeathray);
        GameRegistry.addRecipe(new ItemStack(pRPG, 1), "#$", '$', dWall, '#', pDeathray);
        GameRegistry.addRecipe(new ItemStack(rWall, 8), "###", "#$#", "###", '$', new ItemStack(Item.dyePowder, 1, 1), '#', dWall);
        GameRegistry.addRecipe(new ItemStack(oWall, 8), "###", "#$#", "###", '$', new ItemStack(Item.dyePowder, 1, 14), '#', dWall);
        GameRegistry.addRecipe(new ItemStack(yWall, 8), "###", "#$#", "###", '$', new ItemStack(Item.dyePowder, 1, 11), '#', dWall);
        GameRegistry.addRecipe(new ItemStack(lWall, 8), "###", "#$#", "###", '$', new ItemStack(Item.dyePowder, 1, 10), '#', dWall);
        GameRegistry.addRecipe(new ItemStack(gWall, 8), "###", "#$#", "###", '$', new ItemStack(Item.dyePowder, 1, 2), '#', dWall);
        GameRegistry.addRecipe(new ItemStack(cWall, 8), "###", "#$#", "###", '$', new ItemStack(Item.dyePowder, 1, 12), '#', dWall);
        GameRegistry.addRecipe(new ItemStack(bWall, 8), "###", "#$#", "###", '$', new ItemStack(Item.dyePowder, 1, 4), '#', dWall);
        GameRegistry.addRecipe(new ItemStack(pWall, 8), "###", "#$#", "###", '$', new ItemStack(Item.dyePowder, 1, 5), '#', dWall);
        GameRegistry.addRecipe(new ItemStack(dWall, 32), "###", "#$#", "###", '$', Block.blockIron, '#', Block.stone);
        GameRegistry.addRecipe(new ItemStack(battery, 8), " # ", "#$#", " # ", '$', Item.redstone, '#', Item.ingotIron);
        GameRegistry.addRecipe(new ItemStack(rocket, 8), " # ", "#$#", " # ", '$', Item.gunpowder, '#', Block.stone);
    }
}
