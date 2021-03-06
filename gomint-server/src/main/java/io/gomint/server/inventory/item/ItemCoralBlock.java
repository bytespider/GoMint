package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author Kaooot
 * @version 1.0
 */
@RegisterInfo( id = -132 )
public class ItemCoralBlock extends ItemStack implements io.gomint.inventory.item.ItemCoralBlock {

    @Override
    public String getBlockId() {
        return "minecraft:coral_block";
    }

    @Override
    public ItemType getType() {
        return ItemType.CORAL_BLOCK;
    }

}
