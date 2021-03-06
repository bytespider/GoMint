package io.gomint.server.inventory.item;
import io.gomint.inventory.item.ItemType;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.taglib.NBTTagCompound;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = 85 )
 public class ItemFence extends ItemStack implements io.gomint.inventory.item.ItemFence {



    @Override
    public String getBlockId() {
        return "minecraft:fence";
    }

    @Override
    public ItemType getType() {
        return ItemType.FENCE;
    }

}
