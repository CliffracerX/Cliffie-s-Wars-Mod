package cliffracerx.mods.cliffieswars.src;

import cliffracerx.mods.cliffiestaints.src.NormalBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class WallBlock extends NormalBlock
{
    private String tex;
    
    public WallBlock(int id, Material material, String texture)
    {
        super(id, material, texture);
        this.tex = texture;
        setTextureName("CliffiesWarsMod:" + texture);
    }
}
