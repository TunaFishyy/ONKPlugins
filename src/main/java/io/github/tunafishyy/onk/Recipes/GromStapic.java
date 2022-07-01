package io.github.tunafishyy.onk.Recipes;

import io.github.tunafishyy.onk.ItemManager;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;

public class GromStapic {

    public static ShapedRecipe getGrom(Plugin plugin) {

        NamespacedKey key = new NamespacedKey(plugin, "grom_stapic");
        ShapedRecipe recipe = new ShapedRecipe(key, ItemManager.getGrom(plugin));

        recipe.shape(" S ", " S ", " B ");
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(ItemManager.getStapic()));
        recipe.setIngredient('B', Material.BLAZE_POWDER);

        return recipe;
    }

}
