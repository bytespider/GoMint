/*
 * Copyright (c) 2017, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.entity.potion.effect;

import io.gomint.server.entity.EntityLiving;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = 22 )
public class Absorption extends Effect {

    @Override
    public byte getId() {
        return 22;
    }

    @Override
    public void apply( EntityLiving player ) {
        player.setAbsorptionHearts( player.getAbsorptionHearts() + 4 * ( this.amplifier + 1 ) );
    }

    /**
     * This method does nothing, absorption is handled in the damage calculation
     *
     * @param currentTimeMillis milliseconds of the tick start
     * @param dT                percentage of a whole second done
     */
    @Override
    public void update( long currentTimeMillis, float dT ) {

    }

    @Override
    public void remove( EntityLiving player ) {
        player.setAbsorptionHearts( player.getAbsorptionHearts() - ( 4 * ( this.amplifier + 1 ) ) );
    }

}
