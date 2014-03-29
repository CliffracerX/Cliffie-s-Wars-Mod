package cliffracerx.mods.cliffieswars.src;

import cliffracerx.mods.cliffiestaints.src.NormalBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class FakeTurf extends NormalBlock
{
    private String tex;
    
    public FakeTurf(int id, Material material, String texture)
    {
        super(id, material, texture);
        this.tex = texture;
        setTextureName("CliffiesWarsMod:" + texture);
    }
    
    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }
}
