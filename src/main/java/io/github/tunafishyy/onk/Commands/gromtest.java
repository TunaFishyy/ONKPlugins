package io.github.tunafishyy.onk.Commands;

import io.github.tunafishyy.onk.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gromtest implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (p.hasPermission("grom.use")) {
                p.getInventory().addItem(ItemManager.getGrom());
                p.getInventory().addItem(ItemManager.getStapic());
                return true;
            } else p.sendMessage(ChatColor.RED + "JSON ERROR: file_get_contents(/sites/all/modules/ckeditor/ckeditor/ckeditor.java) [function.file-get-contents]: failed to open stream: No such file or directory in _locale_parse_js_file()");
            return true;
        }
        return false;
    }
}
