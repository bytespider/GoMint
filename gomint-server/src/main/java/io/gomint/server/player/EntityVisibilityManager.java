/*
 * Copyright (c) 2017, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.player;

import com.koloboke.collect.ObjCursor;
import io.gomint.entity.Entity;
import io.gomint.server.entity.EntityPlayer;
import io.gomint.server.network.packet.PacketDespawnEntity;
import io.gomint.server.util.collection.EntityHashSet;
import io.gomint.server.world.ChunkAdapter;
import io.gomint.server.world.CoordinateUtils;
import io.gomint.world.Chunk;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * @author geNAZt
 * @version 1.0
 */
@RequiredArgsConstructor
public class EntityVisibilityManager {

    private static final Logger LOGGER = LoggerFactory.getLogger( EntityVisibilityManager.class );

    private final EntityPlayer player;
    private EntityHashSet visible = EntityHashSet.withExpectedSize( 10 );

    public void updateAddedChunk( ChunkAdapter chunk ) {
        Collection<Entity> collection = chunk.getEntities();
        if ( collection != null ) {
            for ( Entity entity : collection ) {
                addEntity( entity );
            }
        }
    }

    public void updateEntity( Entity entity, Chunk chunk, boolean sendData ) {
        int currentX = CoordinateUtils.fromBlockToChunk( (int) this.player.getPositionX() );
        int currentZ = CoordinateUtils.fromBlockToChunk( (int) this.player.getPositionZ() );

        if ( Math.abs( chunk.getX() - currentX ) > this.player.getViewDistance() ||
            Math.abs( chunk.getZ() - currentZ ) > this.player.getViewDistance() ) {
            removeEntity( entity, sendData );
        } else {
            addEntity( entity, sendData );
        }
    }

    public void updateRemoveChunk( ChunkAdapter chunk ) {
        // Check for removing entities
        int currentX = CoordinateUtils.fromBlockToChunk( (int) this.player.getPositionX() );
        int currentZ = CoordinateUtils.fromBlockToChunk( (int) this.player.getPositionZ() );

        if ( Math.abs( chunk.getX() - currentX ) > this.player.getViewDistance() ||
            Math.abs( chunk.getZ() - currentZ ) > this.player.getViewDistance() ) {
            Collection<Entity> collection = chunk.getEntities();
            if ( collection != null ) {
                for ( Entity entity : collection ) {
                    removeEntity( entity );
                }
            }
        }
    }

    public void removeEntity( Entity entity ) {
        this.removeEntity( entity, true );
    }

    public void removeEntity( Entity entity, boolean despawn ) {
        if ( this.visible.remove( entity ) && !this.player.equals( entity ) ) {
            io.gomint.server.entity.Entity implEntity = (io.gomint.server.entity.Entity) entity;
            implEntity.detach( this.player );

            if ( despawn ) {
                PacketDespawnEntity despawnEntity = new PacketDespawnEntity();
                despawnEntity.setEntityId( entity.getEntityId() );
                this.player.getConnection().addToSendQueue( despawnEntity );
            }
        }
    }

    public void addEntity( Entity entity ) {
        this.addEntity( entity, true );
    }

    public void addEntity( Entity entity, boolean sendSpawn ) {
        if ( !this.visible.contains( entity ) && !this.player.equals( entity ) ) {
            LOGGER.debug( "Adding entity for " + this.player.getName() + ": " + entity );
            io.gomint.server.entity.Entity implEntity = (io.gomint.server.entity.Entity) entity;

            if ( sendSpawn ) {
                this.player.getConnection().addToSendQueue( implEntity.createSpawnPacket() );
            }

            implEntity.attach( this.player );
            this.visible.add( entity );
        }
    }

    public void clear() {
        ObjCursor<Entity> cursor = this.visible.cursor();
        while ( cursor.moveNext() ) {
            Entity curr = cursor.elem();
            if ( curr instanceof io.gomint.server.entity.Entity ) {
                ( (io.gomint.server.entity.Entity) curr ).detach( this.player );
            }
        }

        this.visible.clear();
    }

    public boolean isVisible( Entity entity ) {
        return this.visible.contains( entity );
    }

}