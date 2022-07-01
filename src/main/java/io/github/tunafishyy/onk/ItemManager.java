package io.github.tunafishyy.onk;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    private final ONK i;

    public ItemManager(ONK i) {
        this.i = i;
    }

    public static ItemStack getStapic() {
        ItemStack item = new ItemStack(Material.STICK);
        item.addUnsafeEnchantment(Enchantment.DURABILITY, Enchantment.DURABILITY.getMaxLevel());

        ItemMeta meta = item.getItemMeta();
        meta.setUnbreakable(true);
        meta.setDisplayName(ChatColor.BLUE + "Stapic");
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);

        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.LIGHT_PURPLE + "Stapic potreban za kraftanje Grom stapica.");

        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getGrom(Plugin plugin) {
        ItemStack item = new ItemStack(Material.STICK);
        item.addUnsafeEnchantment(Enchantment.DURABILITY, Enchantment.DURABILITY.getMaxLevel());

        ItemMeta meta = item.getItemMeta();
        meta.setUnbreakable(true);
        meta.setDisplayName(""+ChatColor.BOLD+""+ChatColor.YELLOW + "Grom Stapic.");
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);

        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.LIGHT_PURPLE + "Grom Stapic! Desni klik. Max udaljenost: " + plugin.getConfig().getInt("max-lightning-distance"));

        item.setItemMeta(meta);

        return item;
    }

}