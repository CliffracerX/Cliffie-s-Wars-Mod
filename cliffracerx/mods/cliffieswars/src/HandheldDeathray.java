package cliffracerx.mods.cliffieswars.src;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class HandheldDeathray extends Item
{
    private String tex;
    private String col;
    private Icon[] icons;

    public HandheldDeathray(int id, String tex, String color)
    {
        super(id);
        this.setUnlocalizedName(tex);
        this.setTextureName("CliffiesWarsMod:"+tex);
        this.tex=tex;
        this.isDamageable();
        this.setMaxDamage(2);
        this.col=color;
    }

    @Override
    public CreativeTabs getCreativeTab()
    {
        return CliffiesWars.tab;
    }
    
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,EntityPlayer par3EntityPlayer) {
        LaserEntity laser = new LaserEntity(par2World, par3EntityPlayer, 1.0f, this.col);
        laser.setColor(this.col);
        //if(par3EntityPlayer.capabilities.isCreativeMode/*||par1ItemStack.getItemDamage()<0*/)
        {
          par2World.playSoundAtEntity(par3EntityPlayer, "cliffieswarsmod:laser", 0.5F, 2.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
          laser.color=this.col;
          if (!par2World.isRemote)
          {
              laser.color=this.col;
            par2World.spawnEntityInWorld(laser);
            par1ItemStack.damageItem(1, par3EntityPlayer);
          }
        }
        return par1ItemStack;
        }
    
    @SideOnly(Side.CLIENT)

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    public boolean isFull3D()
    {
        return true;
    }
}