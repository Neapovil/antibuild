package com.github.neapovil.antibuild;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class AntiBuild extends JavaPlugin implements Listener
{
    private static AntiBuild instance;

    @Override
    public void onEnable()
    {
        instance = this;

        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable()
    {
    }

    public static AntiBuild instance()
    {
        return instance;
    }

    @EventHandler
    private void playerJoin(PlayerJoinEvent event)
    {
        if (event.getPlayer().hasPermission("antibuild.block"))
        {
            event.getPlayer().setGameMode(GameMode.SURVIVAL);
        }
        else
        {
            event.getPlayer().setGameMode(GameMode.ADVENTURE);
        }
    }

    @EventHandler
    private void blockBreak(BlockBreakEvent event)
    {
        if (!event.getPlayer().hasPermission("antibuild.block"))
        {
            event.setCancelled(true);
        }
    }

    @EventHandler
    private void blockPlace(BlockPlaceEvent event)
    {
        if (!event.getPlayer().hasPermission("antibuild.block"))
        {
            event.setCancelled(true);
        }
    }
}
