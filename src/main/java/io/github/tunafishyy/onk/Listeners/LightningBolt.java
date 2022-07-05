package io.github.tunafishyy.onk.Listeners;

import io.github.tunafishyy.onk.ItemManager;
import io.github.tunafishyy.onk.ONK;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.Objects;

public class LightningBolt implements Listener {

    private int value = 100;

    @EventHandler
    public void onGrom(final PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
            Player p = e.getPlayer();

            if (!p.getInventory().getItemInMainHand().hasItemMeta()) return;
            if (!p.getInventory().getItemInMainHand().getItemMeta().hasLore()) return;
            if (!(e.getHand() == EquipmentSlot.OFF_HAND)) return;

            if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ItemManager.getGrom().getItemMeta().getDisplayName())) {

                int var = value--;

                if (!(var <= 0)) {
                    ItemManager.updateLore(p.getInventory().getItemInMainHand(), var);
                } else {
                    if (p.getInventory().getItemInMainHand().getAmount() == 1) {
                        p.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                        p.playSound(p.getLocation(), Sound.ENTITY_ITEM_BREAK, 5, 5);
                    } else {
                        p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount() - 1);
                        p.playSound(p.getLocation(), Sound.ENTITY_ITEM_BREAK, 5, 5);
                    }
                }

                p.getWorld().strikeLightning(p.getTargetBlock(null, ONK.getPlugin().getConfig().getInt("max-lightning-distance")).getLocation());


            }
        }
    }
}
