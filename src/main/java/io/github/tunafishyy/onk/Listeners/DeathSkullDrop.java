package io.github.tunafishyy.onk.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;


public class DeathSkullDrop implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
            Player p = e.getEntity();

            if (p.getKiller() != null) {
                e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', "&f"+p.getKiller().getName() +
                        "&e je silovao &f" + p.getDisplayName() + "&e sto je ishodilo u smrt."));
            }

            ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta meta = (SkullMeta) skull.getItemMeta();

            assert meta != null;
            meta.setOwningPlayer(p);
            skull.setItemMeta(meta);

            p.getWorld().dropItemNaturally(p.getLocation(), skull);


    }

}
