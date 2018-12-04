package ga.demeng7215.agnether.listeners;

import ga.demeng7215.agnether.AGNether;
import ga.demeng7215.agnether.utils.AGNetherUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class GroundHitDetectionListener implements Listener {

    @EventHandler
    public void GroundHitDetectionEvent(PlayerMoveEvent e) {

        if (AGNetherUtils.armorStorage.containsKey(e.getPlayer()) &&
                e.getPlayer().getLocation().getWorld().getName()
                        .equalsIgnoreCase(AGNether.getInstance().getConfig().getString("nether-world"))) {

            AGNetherUtils.armorStorage.remove(e.getPlayer());

            if ((e.getFrom().getBlock().getType() == Material.AIR || e.getFrom().getBlock().getType() == null) &&
                    (e.getTo().getBlock().getType() != Material.AIR || e.getTo().getBlock().getType() != null)) {

                System.out.println("meets requirement 2");
                AGNetherUtils.takeElytra(e.getPlayer());
                System.out.println("took elytra");

                for (String cmd : AGNether.getInstance().getConfig().getStringList("commands.console")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd.replace("%player%", e.getPlayer().getName()));
                }

                for (String cmd : AGNether.getInstance().getConfig().getStringList("commands.player")) {
                    Bukkit.dispatchCommand(e.getPlayer(), cmd.replace("%player%", e.getPlayer().getName()));
                }
            }
            System.out.println("done_move");
        }
    }
}