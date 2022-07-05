package io.github.tunafishyy.onk.Commands;

import io.github.tunafishyy.onk.ItemManager;
import io.github.tunafishyy.onk.ONK;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Katon implements CommandExecutor {

    Map<UUID, Byte> cooldowns = new HashMap<>();
    FileConfiguration config = ONK.getPlugin().getConfig();
    boolean setPrefix = config.getBoolean("set-prefix");
    String prefix = config.getString("prefix");

    @SuppressWarnings("ConstantConditions")
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (!cooldowns.containsKey(p.getUniqueId())) {
                cooldowns.put(p.getUniqueId(), null);

            /*
                Full inventory
                 */
                if (p.getInventory().firstEmpty() == -1) {
                    p.sendMessage(prefix + "Vas inventory je pun! Bacam " + ChatColor.GOLD + "Katon " + ChatColor.WHITE + "na pod.");
                    p.getWorld().dropItemNaturally(p.getLocation(), ItemManager.getKaton());
                } else {
                    p.getInventory().addItem(ItemManager.getKaton());
                }

                if (setPrefix) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "Dobili ste " + ChatColor.GOLD + "Katon" + ChatColor.GREEN + "!"));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "Mozete ga preuzeti samo jednom, tako da pripazite da se ne izgubi."));
                    return true;
                } else {
                    p.sendMessage("Dobili ste " + ChatColor.GOLD + "Katon" + ChatColor.GREEN + "!");
                    p.sendMessage("Mozete ga preuzeti samo jednom, tako da pripazite da se ne izgubi.");
                }
                return true;
            } else {
                if (setPrefix) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "Vec ste preuzeli " + ChatColor.GOLD + "Katon" + ChatColor.GREEN + "!"));
                    return true;
                } else {
                    p.sendMessage("Vec ste preuzeli " + ChatColor.GOLD + "Katon" + ChatColor.GREEN + "!");
                }
            }
            return true;
        } else System.out.println("Konzolo, ti ne mozes stvoriti vatru!");
        return false;
    }
}
