package io.gomint.server.world.block;

import io.gomint.world.block.BlockType;

import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( sId = "minecraft:invisibleBedrock" )
public class InvisibleBedrock extends Block implements io.gomint.world.block.BlockInvisibleBedrock {

    @Override
    public String getBlockId() {
        return "minecraft:invisibleBedrock";
    }

    @Override
    public long getBreakTime() {
        return -1;
    }

    @Override
    public boolean isTransparent() {
        return true;
    }

    @Override
    public float getBlastResistance() {
        return 1.8E7f;
    }

    @Override
    public BlockType getType() {
        return BlockType.INVISIBLE_BEDROCK;
    }

}
