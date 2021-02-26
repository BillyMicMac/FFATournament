package me.alivesteve.ffatourney;

import me.alivesteve.ffatourney.Commands.ResetEvent;
import me.alivesteve.ffatourney.Commands.StartEvent;
import me.alivesteve.ffatourney.Listeners.PlayerDeath;
import me.alivesteve.ffatourney.Listeners.PlayerJoin;
import me.alivesteve.ffatourney.Utilities.Utilities;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public final class FFATourney extends JavaPlugin implements Listener {

    private static FFATourney instance;

    public static FFATourney getInstance() {
        // Instance Management
        return instance;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        Utilities.init();
        instance = this;


        this.getCommand("startevent").setExecutor(new StartEvent());
        this.getCommand("resetevent").setExecutor(new ResetEvent());

        this.getServer().getPluginManager().registerEvents(new PlayerDeath(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerJoin(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
