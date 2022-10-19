package me.hazzy.myfirstplugin;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;
import sun.security.util.Debug;

import java.util.Random;

public class PunchListener implements Listener
{
    public static Integer tntAmount;

    Random rnd = new Random();
    @EventHandler
    public void OnEventHandled(PlayerInteractEvent event)
    {
        if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.STICK))
        {
            if (event.hasBlock())
            {

                Block block = event.getClickedBlock();
                Location location = block.getRelative(event.getBlockFace()).getLocation();

                Player player = event.getPlayer();
                player.sendMessage(tntAmount.toString());
                for (int i = 0; i < tntAmount; i++)
                {
                    TNTPrimed tnt = (TNTPrimed) location.getWorld().spawnEntity(location.clone().add(0.5, 0.5, 0.5), EntityType.PRIMED_TNT);
                    tnt.setVelocity(new Vector(rnd.nextDouble() * 8 - 4, rnd.nextDouble() * 2 - 1, rnd.nextDouble() * 2 - 1));
                }
            }
        }
    }
}
