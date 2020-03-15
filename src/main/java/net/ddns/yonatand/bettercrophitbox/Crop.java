package net.ddns.yonatand.bettercrophitbox;

import net.minecraft.block.Block;

public class Crop {
    public Block block;
    public float height;

    public Crop(Block block, float height){
        this.block=block;
        this.height=height;
    }
}
