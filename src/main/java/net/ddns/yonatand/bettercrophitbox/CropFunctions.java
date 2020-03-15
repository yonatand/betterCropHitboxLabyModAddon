package net.ddns.yonatand.bettercrophitbox;

import net.minecraft.block.Block;

public class CropFunctions {

    private boolean active;

    private float regY = (float)0.25;
    private Crop[] crops = {new Crop(Block.getBlockFromName("wheat"),(float)0.9),new Crop(Block.getBlockFromName("nether_wart"),(float)0.85),new Crop(Block.getBlockFromName("carrots"),(float)0.7),new Crop(Block.getBlockFromName("potatoes"),(float)0.5)};

    private static CropFunctions ourInstance;

    protected static void createInstance(boolean active) {
        ourInstance = new CropFunctions(active);
        ourInstance.update(active);
    }

    public static CropFunctions getInstance() {
        try {
            return ourInstance;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    private CropFunctions(Boolean active) {
        this.active = active;
    }

    protected void update(boolean active){
        this.active = active;

        if(!this.active){
            for(Crop cur : crops){
                cur.block.setBlockBounds((float)cur.block.getBlockBoundsMinX(),(float)cur.block.getBlockBoundsMinY(),(float)cur.block.getBlockBoundsMinZ(),(float)cur.block.getBlockBoundsMaxX(),regY,(float)cur.block.getBlockBoundsMaxZ());
            }
        }
        else{
            for(Crop cur : crops){
                cur.block.setBlockBounds((float)cur.block.getBlockBoundsMinX(),(float)cur.block.getBlockBoundsMinY(),(float)cur.block.getBlockBoundsMinZ(),(float)cur.block.getBlockBoundsMaxX(),cur.height,(float)cur.block.getBlockBoundsMaxZ());
            }
        }
    }
}
