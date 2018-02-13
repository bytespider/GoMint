package io.gomint.plugin;

import io.gomint.GoMint;
import io.gomint.entity.passive.EntityHuman;
import io.gomint.entity.passive.EntityVillager;
import io.gomint.entity.passive.EntityXPOrb;
import io.gomint.inventory.item.ItemClock;
import io.gomint.inventory.item.ItemDirt;
import io.gomint.inventory.item.ItemLog;
import io.gomint.inventory.item.ItemStack;
import io.gomint.math.Location;
import io.gomint.player.PlayerSkin;
import io.gomint.plugin.listener.PlayerJoinListener;
import io.gomint.plugin.listener.PlayerMoveListener;
import io.gomint.world.World;
import io.gomint.world.block.BlockChest;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * @author geNAZt
 * @version 1.0
 */
@PluginName( "TestPlugin" )
@Version( major = 1, minor = 0 )
public class TestPlugin extends Plugin {

    @Getter
    private EntityXPOrb bossBarOrb;

    @Override
    public void onStartup() {
        getLogger().info( "Started " + this.getName() + " " + this.getVersion() );
    }

    @Override
    public void onInstall() {
        // Load world skywars
        /*World skywars = GoMint.instance().getWorld( "Skywars" );

        // Generate boss bar orb
        this.bossBarOrb = EntityXPOrb.create();
        this.bossBarOrb.setPickupDelay( 3650, TimeUnit.DAYS );
        this.bossBarOrb.setTicking( false );
        this.bossBarOrb.setNameTagAlwaysVisible( false );
        this.bossBarOrb.setNameTagVisible( true );
        this.bossBarOrb.setNameTag( "GoMint Bossbar Test" );
        this.bossBarOrb.spawn( new Location( skywars, 0, -10, 0 ) );

        // Spawn NPC
        EntityHuman npc = EntityHuman.create();
        npc.setSkin( PlayerSkin.fromURL( "http://puu.sh/yHz9d/1dee829ba6.png" ) );
        npc.setDisplayName( "Test" );
        npc.spawn( new Location( skywars, 5, 65, 2 ) );

        // Switch item in hand every second
        this.getScheduler().schedule( new Runnable() {
            private List<ItemStack> itemsToRandomWith = new ArrayList<ItemStack>() {{
                add( ItemClock.create( 1 ) );
                add( ItemDirt.create( 3 ) );
                add( ItemLog.create( 2 ) );
            }};

            @Override
            public void run() {
                Collections.shuffle( itemsToRandomWith );
                npc.getInventory().setItem( npc.getInventory().getItemInHandSlot(), itemsToRandomWith.get( 0 ) );
            }
        }, 1, 1, TimeUnit.SECONDS );

        // Spawn floating text
        EntityHuman floatingText = EntityHuman.create();
        floatingText.setSkin( PlayerSkin.empty() );
        floatingText.setScale( 0f );
        floatingText.setTicking( false );
        floatingText.setNameTag( "Test floating text" );
        floatingText.spawn( new Location( skywars, 5, 71, 2 ) );

        // Spawn villager
        EntityVillager villager = EntityVillager.create();
        villager.spawn( new Location( skywars, 3, 67, 2 ) );*/

        // Register listener
        registerListener( new PlayerMoveListener() );
        registerListener( new PlayerJoinListener( this ) );

        // Test iteration for world "Skywars"
        /*skywars.iterateBlocks( BlockChest.class, new Consumer<BlockChest>() {
            @Override
            public void accept( BlockChest blockChest ) {
                getLogger().info( "Found chest @ {}", blockChest.getLocation() );
            }
        } );*/
    }

    @Override
    public void onUninstall() {
        // This is like Bukkits onDisable();
    }

}
