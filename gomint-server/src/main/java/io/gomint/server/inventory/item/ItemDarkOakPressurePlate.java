/*
 * Copyright (c) 2018, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = -152 )
public class ItemDarkOakPressurePlate extends ItemStack implements io.gomint.inventory.item.ItemDarkOakPressurePlate {

    @Override
    public String getBlockId() {
        return "minecraft:dark_oak_pressure_plate";
    }

    @Override
    public ItemType getType() {
        return ItemType.DARK_OAK_PRESSURE_PLATE;
    }

}
