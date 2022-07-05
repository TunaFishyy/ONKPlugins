package io.github.tunafishyy.onk.Recipes.Grom;

import io.github.tunafishyy.onk.ItemManager;
import io.github.tunafishyy.onk.ONK;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;

public class GromStapic {

    public static ShapedRecipe getGrom() {

        NamespacedKey key = new NamespacedKey(ONK.getPlugin(), "grom_stapic");
        ShapedRecipe recipe = new ShapedRecipe(key, ItemManager.getGrom());

        recipe.shape("S", "S", "B");
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(ItemManager.getStapic()));
        recipe.setIngredient('B', Material.BLAZE_POWDER);

        return recipe;
    }

}
