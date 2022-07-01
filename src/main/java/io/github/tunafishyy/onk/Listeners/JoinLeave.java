package io.github.tunafishyy.onk.Listeners;

import io.github.tunafishyy.onk.ONK;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Objects;

public class JoinLeave implements Listener {

    private final ONK instance;

    public JoinLeave(ONK instance) {
        this.instance = instance;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        //Ako igrac prvi put ulazi na server.
        if (!e.getPlayer().hasPlayedBefore()) {
            //Ako je prefix ukljucen
        if (instance.getConfig().getBoolean("set-prefix")) {
            e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(instance.getConfig().getString("first-join-message".replaceAll("%prefix%",
                    Objects.requireNonNull(instance.getConfig().getString("prefix"))).replaceAll("%player%",
                    e.getPlayer().getDisplayName())))));

            //Ako je prefix iskljucen
            } else {
                e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', instance.getConfig().getString("first-join-message").replaceAll("%prefix%",
                        "").replaceAll("%player%", e.getPlayer().getDisplayName())));
            }
        } else {
            //Kad igrac udje
            //Ako je prefix ukljucen
            if (instance.getConfig().getBoolean("set-prefix")) {
                e.setJoinMessage(ChatColor.translateAlternateColorCodes('&',Objects.requireNonNull(instance.getConfig().getString("join-message")).replaceAll("%prefix%",
                        Objects.requireNonNull(instance.getConfig().getString("prefix"))).replaceAll("%player%",
                        e.getPlayer().getDisplayName())));

                //Ako je prefix iskljucen
            } else {
                e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', instance.getConfig().getString("join-message").replaceAll("%prefix%",
                        "").replaceAll("%player%", e.getPlayer().getDisplayName())));
            }
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();

        //Ako je prefix ukljucen
        if (instance.getConfig().getBoolean("set-prefix")) {
            e.setQuitMessage(ChatColor.translateAlternateColorCodes('&',Objects.requireNonNull(instance.getConfig().getString("quit-message")).replaceAll("%prefix%",
                    Objects.requireNonNull(instance.getConfig().getString("prefix"))).replaceAll("%player%",
                    e.getPlayer().getDisplayName())));

            //Ako je prefix iskljucen
        } else {
            e.setQuitMessage(ChatColor.translateAlternateColorCodes('&',Objects.requireNonNull(instance.getConfig().getString("quit-message")).replaceAll("%prefix%",
                    "").replaceAll("%player%",
                    e.getPlayer().getDisplayName())));
        }
    }

}
