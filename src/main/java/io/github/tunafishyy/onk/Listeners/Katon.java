package io.github.tunafishyy.onk.Listeners;

import io.github.tunafishyy.onk.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class Katon implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Location block;
        Location org;

        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
        if (e.getHand() == EquipmentSlot.OFF_HAND) return;

        if (p.getInventory().getItemInMainHand().getType() == Material.BLAZE_POWDER) {
        if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ItemManager.getKaton().getItemMeta().getDisplayName())) {
            p.sendMessage(ChatColor.GOLD + "KATOON");

            if (p.getFacing() == BlockFace.NORTH) {
                block = p.getEyeLocation().add(0, 0, -3);

                block.getWorld().spawnParticle(Particle.EXPLOSION_LARGE, block, 10 );
            } else if (p.getFacing() == BlockFace.SOUTH) {
                block = p.getEyeLocation().add(0, 0, 3);

                block.getWorld().spawnParticle(Particle.EXPLOSION_LARGE, block, 10 );
            } else if (p.getFacing() == BlockFace.EAST) {
                block = p.getEyeLocation().add(3, 0, 0);

                block.getWorld().spawnParticle(Particle.EXPLOSION_LARGE, block, 10 );
            } else if (p.getFacing() == BlockFace.WEST) {
                block = p.getEyeLocation().add(-3, 0, 0);

                block.getWorld().spawnParticle(Particle.EXPLOSION_LARGE, block, 10 );
            }
                }
            }
        }
    }
}
