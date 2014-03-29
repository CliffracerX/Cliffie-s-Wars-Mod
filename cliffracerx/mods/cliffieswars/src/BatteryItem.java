package cliffracerx.mods.cliffieswars.src;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BatteryItem extends Item
{
    private String texture;
    private Icon[] icons;

    public BatteryItem(int id, String tex)
    {
        super(id);
        this.setUnlocalizedName(tex);
        this.setTextureName("CliffiesWarsMod:"+tex);
        this.texture=tex;
        this.isDamageable();
        this.setMaxDamage(2);
    }

    @Override
    public CreativeTabs getCreativeTab()
    {
        return CliffiesWars.tab;
    }
    
    public Icon getIconFromDamage(int par1)
    {
        if(par1>=0 || par1>=-500)
        {
            return this.icons[0];
        }
        else if(par1>=-1000 && par1<-500)
        {
            return this.icons[1];
        }
        else if(par1>=-1500 && par1<-1000)
        {
            return this.icons[2];
        }
        else if(par1>=-2000 && par1<-1500)
        {
            return this.icons[3];
        }
        else if(par1>=-2500 && par1<-2000)
        {
            return this.icons[4];
        }
        else
        return this.icons[5];
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.icons = new Icon[6];
        this.icons[0] = par1IconRegister.registerIcon("CliffiesWarsMod:bat1");
        this.icons[1] = par1IconRegister.registerIcon("CliffiesWarsMod:bat2");
        this.icons[2] = par1IconRegister.registerIcon("CliffiesWarsMod:bat3");
        this.icons[3] = par1IconRegister.registerIcon("CliffiesWarsMod:bat4");
        this.icons[4] = par1IconRegister.registerIcon("CliffiesWarsMod:bat5");
        this.icons[5] = par1IconRegister.registerIcon("CliffiesWarsMod:emptyBattery");
    }
}