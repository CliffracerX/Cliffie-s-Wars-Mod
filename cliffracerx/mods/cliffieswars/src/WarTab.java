package cliffracerx.mods.cliffieswars.src;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class WarTab extends CreativeTabs
{
    // Main constructor, nothing to see here.
    public WarTab(String label)
    {
        super(label);
    }
    
    // This sets the item/block seen as the creative tab's icon. :D
    // We set it to our custom block.
    @Override
    public ItemStack getIconItemStack()
    {
        return new ItemStack(CliffiesWars.gWall);
    }
}
