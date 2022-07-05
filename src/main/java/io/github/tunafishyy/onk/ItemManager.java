package io.github.tunafishyy.onk;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.ArrayList;
import java.util.List;

public class ItemManager {

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

        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getGrom() {
        ItemStack item = new ItemStack(Material.BLAZE_ROD);
        item.addUnsafeEnchantment(Enchantment.DURABILITY, Enchantment.DURABILITY.getMaxLevel());

        ItemMeta meta = item.getItemMeta();
        assert meta != null;

        meta.setUnbreakable(true);
        meta.setDisplayName("" + ChatColor.BOLD + "" + ChatColor.YELLOW + "Grom Stapic");
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);

        List<String> lore = new ArrayList<>();
        lore.add("");
        // This is my native language so ignore that
        lore.add(ChatColor.LIGHT_PURPLE + "Grom Stapic! Desni klik. Max udaljenost: " + ChatColor.WHITE + "" + /*Instance of main class -->*/ ONK.getPlugin().getConfig().getInt("max-lightning-distance"));

        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public static void updateLore(ItemStack item, int itemValue) {
        List<String> lore = item.getItemMeta().getLore();
        assert lore != null;

        lore.clear();
        lore.add("");
        lore.add(ChatColor.LIGHT_PURPLE + "Grom Stapic! Desni klik. Max udaljenost: " + ChatColor.WHITE + "" + /*Instance of main class -->*/ ONK.getPlugin().getConfig().getInt("max-lightning-distance"));
        lore.add(ChatColor.LIGHT_PURPLE + "Preostalo koristenja: " + ChatColor.WHITE + "" + itemValue);

        ItemMeta meta = item.getItemMeta();
        assert meta != null;

        meta.setLore(lore);
        item.setItemMeta(meta);
    }

}