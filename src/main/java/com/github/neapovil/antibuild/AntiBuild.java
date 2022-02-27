package com.github.neapovil.antibuild;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

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

    public static AntiBuild getInstance()
    {
        return instance;
    }

    @EventHandler
    private void blockBreak(BlockBreakEvent event)
    {
        if (!event.getPlayer().hasPermission("antibuild.break"))
        {
            final String message = this.getMessage("break");

            event.getPlayer().sendMessage(message);
            event.setCancelled(true);
        }
    }

    @EventHandler
    private void blockPlace(BlockPlaceEvent event)
    {
        if (!event.getPlayer().hasPermission("antibuild.place"))
        {
            final String message = this.getMessage("place");

            event.getPlayer().sendMessage(message);
            event.setCancelled(true);
        }
    }

    @EventHandler
    private void playerInteract(PlayerInteractEvent event)
    {
        if (!event.getPlayer().hasPermission("antibuild.interact"))
        {
            final String message = this.getMessage("interact");

            event.getPlayer().sendMessage(message);
            event.setCancelled(true);
        }
    }

    private String getMessage(String message)
    {
        return ChatColor.translateAlternateColorCodes('&', "&4&lERROR! &r&7You do not have permissions to " + message + " here!");
    }
}
