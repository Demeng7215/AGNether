package ga.demeng7215.agnether;

import ga.demeng7215.agnether.commands.AGNetherCmd;
import ga.demeng7215.agnether.listeners.GroundHitDetectionListener;
import ga.demeng7215.agnether.listeners.TeleportToNetherListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class AGNether extends JavaPlugin {

    private static AGNether instance;

    public static String prefix;

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();
        prefix = getConfig().getString("prefix");

        getCommand("agnether").setExecutor(new AGNetherCmd());

        Bukkit.getPluginManager().registerEvents(new TeleportToNetherListener(), this);
        Bukkit.getPluginManager().registerEvents(new GroundHitDetectionListener(), this);

        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "AGNether v" + getDescription().getVersion() +
                " by Demeng7215 has been successfully enabled!");

    }

    @Override
    public void onDisable() {

        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "AGNether v" + getDescription().getVersion() +
                " by Demeng7215 has been successfully disabled.");
    }

    public static AGNether getInstance() {
        return instance;
    }

}