package io.github.tunafishyy.onk;

import io.github.tunafishyy.onk.Listeners.DeathSkullDrop;
import io.github.tunafishyy.onk.Listeners.Drops.GromStap;
import io.github.tunafishyy.onk.Listeners.JoinLeave;
import io.github.tunafishyy.onk.Recipes.GromStapic;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ONK extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getServer().getPluginManager().registerEvents(new JoinLeave(this), this);
        getServer().getPluginManager().registerEvents(new DeathSkullDrop(), this);
        getServer().getPluginManager().registerEvents(new GromStap(this), this);

        Bukkit.addRecipe(GromStapic.getGrom(this));

    }
}
