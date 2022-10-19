package me.hazzy.myfirstplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTntAmm implements CommandExecutor
{
    // This method is called, when somebody uses our command
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (!(sender instanceof Player))
        {
            sender.sendMessage("Ony players can use that command!");
            return true;
        }
        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("tntammount"))
        {
            if (args.length == 1)
            {
                int amountInput = Integer.parseInt(args[0]);
                PunchListener.tntAmount = amountInput;
                player.sendMessage("§a Your TNTStick(tm) will now summon " + amountInput + " tnt!");
            } else {
                player.sendMessage("Too many arguments!! Please only enter one int value");
            }
        }

        return true;
    }
}