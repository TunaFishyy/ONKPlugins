package io.github.tunafishyy.onk;

import io.github.tunafishyy.onk.Commands.gromtest;
import io.github.tunafishyy.onk.Listeners.DeathSkullDrop;
import io.github.tunafishyy.onk.Listeners.Drops.GromStap;
import io.github.tunafishyy.onk.Listeners.JoinLeave;
import io.github.tunafishyy.onk.Listeners.LightningBolt;
import io.github.tunafishyy.onk.Recipes.Grom.GromStapic;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ONK extends JavaPlugin {

    private static ONK plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        getServer().getPluginManager().registerEvents(new JoinLeave(this), this);
        getServer().getPluginManager().registerEvents(new DeathSkullDrop(), this);
        getServer().getPluginManager().registerEvents(new GromStap(), this);
        getServer().getPluginManager().registerEvents(new LightningBolt(), this);

        Bukkit.addRecipe(GromStapic.getGrom());

        getCommand("aaustralija").setExecutor(new gromtest());

    }

    public static ONK getPlugin() {
        return plugin;
    }
}
