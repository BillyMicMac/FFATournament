package me.alivesteve.ffatourney.Commands;

import me.alivesteve.ffatourney.FFATourney;
import me.alivesteve.ffatourney.Utilities.Utilities;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;


public class StartEvent implements CommandExecutor {

    // Wow this is a lot of code :O

    Server server = Bukkit.getServer();
    ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
    BukkitScheduler scheduler = Bukkit.getServer().getScheduler();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&l[FFA Tournament] &r&aEvent has been started by &b" + sender.getName() + "&a, and will start soon!"));

        scheduler.scheduleSyncDelayedTask(FFATourney.getInstance(), () -> {

            Location location = new Location(player.getWorld(), 124, 9, 52);
            for (Player p : Bukkit.getServer().getOnlinePlayers()){
                p.teleport(location);
                p.getInventory().clear();
                p.setGameMode(GameMode.ADVENTURE);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&l[FFA Tournament] &r&aPVP will be turned on in &e30 seconds&a. &lSPREAD OUT!&r&a."));
                p.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 0.0f);
                server.dispatchCommand(console, "kit ffa " + p.getName());
            }
            Utilities.event = true;

        }, 100L);

        Utilities.setTimer();


        Utilities.taskID = scheduler.scheduleSyncRepeatingTask(FFATourney.getInstance(), () -> {
            if (Utilities.timer == 20) {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&l[FFA Tournament] &r&aPVP is turning on in 20 seconds!"));
            }
            if (Utilities.timer == 10) {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&l[FFA Tournament] &r&aPVP is turning on in 10 seconds!"));
            }
            if (Utilities.timer == 5) {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&l[FFA Tournament] &r&aPVP is turning on in 5 seconds!"));
                for (Player p : Bukkit.getServer().getOnlinePlayers()){
                    p.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 0.0f);
                }
            }
            if (Utilities.timer == 4) {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&l[FFA Tournament] &r&aPVP is turning on in 4 seconds!"));
                for (Player p : Bukkit.getServer().getOnlinePlayers()){
                    p.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 0.0f);
                }
            }
            if (Utilities.timer == 3) {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&l[FFA Tournament] &r&aPVP is turning on in 3 seconds!"));
                for (Player p : Bukkit.getServer().getOnlinePlayers()){
                    p.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 0.0f);
                }
            }
            if (Utilities.timer == 2) {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&l[FFA Tournament] &r&aPVP is turning on in 2 seconds!"));
                for (Player p : Bukkit.getServer().getOnlinePlayers()){
                    p.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 0.0f);
                }
            }
            if (Utilities.timer == 1) {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&l[FFA Tournament] &r&aPVP is turning on in 1 second!"));
                for (Player p : Bukkit.getServer().getOnlinePlayers()){
                    p.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 0.0f);
                }
            }
            if (Utilities.timer == 0) {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&l[FFA Tournament] &r&aPVP has been turned on! Fight to the death!"));
                for (Player p : Bukkit.getServer().getOnlinePlayers()){
                    p.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 0.0f);
                }
                server.dispatchCommand(console, "rg flag __global__ -w world pvp allow");
                Utilities.stopTimer();

            }

            Utilities.timer = Utilities.timer - 1;
        }, 0L, 20L);


        return true;

    }


}

