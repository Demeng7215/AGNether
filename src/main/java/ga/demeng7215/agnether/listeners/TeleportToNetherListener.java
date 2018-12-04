package ga.demeng7215.agnether.listeners;

import ga.demeng7215.agnether.AGNether;
import ga.demeng7215.agnether.utils.AGNetherUtils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class TeleportToNetherListener implements Listener {

    @EventHandler
    public void onTeleportToNetherEvent(PlayerChangedWorldEvent e) {

        System.out.println("world changed");

        if (e.getPlayer().getWorld().getName().equalsIgnoreCase(
                AGNether.getInstance().getConfig().getString("nether-world"))) {

            System.out.println("in nether");

            Location l1 = new Location(e.getPlayer().getWorld(),
                    AGNether.getInstance().getConfig().getInt("corner-1.x"),
                    AGNether.getInstance().getConfig().getInt("corner-1.y"),
                    AGNether.getInstance().getConfig().getInt("corner-1.z"));

            Location l2 = new Location(e.getPlayer().getWorld(),
                    AGNether.getInstance().getConfig().getInt("corner-2.x"),
                    AGNether.getInstance().getConfig().getInt("corner-2.y"),
                    AGNether.getInstance().getConfig().getInt("corner-2.z"));

            Location random = AGNetherUtils.randomLocation(l1, l2);

            System.out.println("meets requirements");

            random.setY(random.getY() - 1);

            random.getBlock().setType(Material.valueOf(AGNether.getInstance().getConfig().getString("material")));

            random.setY(random.getY() + 1);
            e.getPlayer().teleport(random);

            AGNetherUtils.giveElytra(e.getPlayer());

            System.out.println("done");
        }
    }
}