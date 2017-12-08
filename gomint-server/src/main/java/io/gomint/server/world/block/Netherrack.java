package io.gomint.server.world.block;

import io.gomint.world.block.BlockType;

import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = 87 )
public class Netherrack extends Block implements io.gomint.world.block.BlockNetherrack {

    @Override
    public int getBlockId() {
        return 87;
    }

    @Override
    public long getBreakTime() {
        return 600;
    }

    @Override
    public float getBlastResistance() {
        return 2.0f;
    }

    @Override
    public BlockType getType() {
        return BlockType.NETHERRACK;
    }

}