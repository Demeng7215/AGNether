package ga.demeng7215.agnether.commands;

import ga.demeng7215.agnether.AGNether;
import ga.demeng7215.agnether.utils.AGNetherUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AGNetherCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        sender.sendMessage(AGNetherUtils.format("&cRunning AGNether v" + AGNether.getInstance()
                .getDescription().getVersion() + " by Demeng7215."));

        return true;
    }
}
