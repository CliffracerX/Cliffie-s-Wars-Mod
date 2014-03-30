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

public class RocketItem extends Item
{
    private String texture;

    public RocketItem(int id, String tex)
    {
        super(id);
        this.setUnlocalizedName(tex);
        this.setTextureName("CliffiesWarsMod:"+tex);
        this.texture=tex;
    }

    @Override
    public CreativeTabs getCreativeTab()
    {
        return CliffiesWars.tab;
    }
}