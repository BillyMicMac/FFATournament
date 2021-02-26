package me.alivesteve.ffatourney.Listeners;

import me.alivesteve.ffatourney.Utilities.Utilities;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
    // Stops cheating frickheads from being cheating frickheads

    @EventHandler
    public void onJoin (PlayerJoinEvent event) {
        if (Utilities.event){
            Player player = event.getPlayer();
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&l[FFA Tournament] &r&aSince you left, you have been placed in spectator!"));
            player.setGameMode(GameMode.SPECTATOR);
        }
    }
}
