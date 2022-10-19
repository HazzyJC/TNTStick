package me.hazzy.myfirstplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class MyFirstPlugin extends JavaPlugin {

    @Override
    public void onEnable()
    {
        getServer().getPluginManager().registerEvents(new PunchListener(), this);
        this.getCommand("tntammount").setExecutor(new CommandTntAmm());
    }

    @Override
    public void onDisable()
    {
        // Plugin shutdown logic
    }
}
