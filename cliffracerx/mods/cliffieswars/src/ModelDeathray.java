package cliffracerx.mods.cliffieswars.src;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class ModelDeathray extends ModelBase
{
  //fields
    ModelRenderer Handle;
    ModelRenderer Barrel;
    ModelRenderer SightOrScope;
    ModelRenderer TriggerSpot;
    ModelRenderer Battery;
  
  public ModelDeathray()
  {
    textureWidth = 32;
    textureHeight = 32;
    
    Handle = new ModelRenderer(this, 0, 0);
    Handle.addBox(-1F, 0F, -1F, 2, 8, 2);
    Handle.setRotationPoint(0F, 0F, 0F);
    Handle.setTextureSize(64, 32);
    Handle.mirror = true;
    setRotation(Handle, 0F, 0F, 0F);
    Barrel = new ModelRenderer(this, 8, 0);
    Barrel.addBox(-1F, 0F, -1F, 2, 14, 2);
    Barrel.setRotationPoint(0F, 0F, 0F);
    Barrel.setTextureSize(64, 32);
    Barrel.mirror = true;
    setRotation(Barrel, -1.570796F, 1.570796F, 0F);
    SightOrScope = new ModelRenderer(this, 0, 15);
    SightOrScope.addBox(0F, -2F, -2F, 3, 3, 2);
    SightOrScope.setRotationPoint(0F, 0F, 0F);
    SightOrScope.setTextureSize(64, 32);
    SightOrScope.mirror = true;
    setRotation(SightOrScope, 0F, 1.570796F, 0F);
    TriggerSpot = new ModelRenderer(this, 0, 10);
    TriggerSpot.addBox(-0.5F, 0F, -0.5F, 1, 4, 1);
    TriggerSpot.setRotationPoint(-4F, 1F, 0F);
    TriggerSpot.setTextureSize(64, 32);
    TriggerSpot.mirror = true;
    setRotation(TriggerSpot, 0.7853982F, 1.570796F, 0F);
    Battery = new ModelRenderer(this, 16, 0);
    Battery.addBox(-1.5F, 0F, -1.5F, 3, 4, 3);
    Battery.setRotationPoint(0F, 6F, 0F);
    Battery.setTextureSize(64, 32);
    Battery.mirror = true;
    setRotation(Battery, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, Minecraft mc, HandheldDeathray item)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    mc.renderEngine.bindTexture(new ResourceLocation(
            "cliffieswarsmod:textures/models/items/"+item.col+"Deathray.png"));
    Handle.render(f5);
    Barrel.render(f5);
    SightOrScope.render(f5);
    TriggerSpot.render(f5);
    Battery.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
  }

}
