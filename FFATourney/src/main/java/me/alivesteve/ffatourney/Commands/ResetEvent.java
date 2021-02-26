package me.alivesteve.ffatourney.Commands;

import me.alivesteve.ffatourney.Utilities.Utilities;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

public class ResetEvent implements CommandExecutor {

    Server server = Bukkit.getServer();
    ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
    BukkitScheduler scheduler = Bukkit.getServer().getScheduler();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        Utilities.event = false;
        server.dispatchCommand(console, "rg flag __global__ -w world pvp deny");

        Location location = new Location(player.getWorld(), 124, 9, 52);
        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
            p.teleport(location);
            p.getInventory().clear();
            p.setGameMode(GameMode.SPECTATOR);
            p.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 0.0f);
        }
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&l[FFA Tournament] &r&aThe tournament has been reset"));

        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&l[FFA Tournament] &r&aEvent reset and ready!"));


        return true;
    }
}
