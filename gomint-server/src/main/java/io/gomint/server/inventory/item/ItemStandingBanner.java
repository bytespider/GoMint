package io.gomint.server.inventory.item;
import io.gomint.inventory.item.ItemBanner;
import io.gomint.inventory.item.ItemType;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.taglib.NBTTagCompound;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = 176 )
public class ItemStandingBanner extends ItemStack implements ItemBanner {

    @Override
    public long getBurnTime() {
        return 15000;
    }

    @Override
    public String getBlockId() {
        return "minecraft:standing_banner";
    }

    @Override
    public ItemType getType() {
        return ItemType.STANDING_BANNER;
    }

}
