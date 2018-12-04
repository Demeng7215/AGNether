package ga.demeng7215.agnether.utils;

import ga.demeng7215.agnether.AGNether;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.HashMap;

public class AGNetherUtils {

    public static HashMap<Player, ItemStack> armorStorage = new HashMap<>();

    public static String format(String message) {
        return ChatColor.translateAlternateColorCodes('&', AGNether.prefix + message);
    }

    public static Location randomLocation(Location min, Location max) {
        Location range = new Location(min.getWorld(), Math.abs(max.getX() - min.getX()), min.getY(), Math.abs(max.getZ() - min.getZ()));
        return new Location(min.getWorld(), (Math.random() * range.getX()) + (min.getX() <= max.getX() ? min.getX() : max.getX()), range.getY(), (Math.random() * range.getZ()) + (min.getZ() <= max.getZ() ? min.getZ() : max.getZ()));
    }

    public static void giveElytra(Player player) {

        PlayerInventory inv = player.getInventory();

        armorStorage.put(player, inv.getChestplate());

        inv.setChestplate(new ItemStack(Material.ELYTRA));
    }

    public static void takeElytra(Player player) {

        ItemStack chestplate = armorStorage.get(player);

        PlayerInventory inv = player.getInventory();

        inv.setChestplate(chestplate);
    }
}