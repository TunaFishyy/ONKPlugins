package io.github.tunafishyy.onk.Listeners.Drops;

import io.github.tunafishyy.onk.ItemManager;
import io.github.tunafishyy.onk.ONK;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Creeper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.Random;

public class GromStap implements Listener {

    private final ONK in;

    private final Random random = new Random();

    public GromStap(ONK in) {
        this.in = in;
    }

    @EventHandler
    public void onCreeperKill(EntityDeathEvent e) {
        double r = random.nextDouble();

        // 1%
        if (e instanceof Creeper) {
            Creeper c = (Creeper) e.getEntity();

            if (r <= 0.01) {
                c.getLocation().getWorld().dropItemNaturally(c.getLocation(), ItemManager.getStapic());
            }
        }

    }

}