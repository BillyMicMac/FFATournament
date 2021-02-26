package me.alivesteve.ffatourney.Listeners;

import me.alivesteve.ffatourney.Utilities.Utilities;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerDeath implements Listener {
    // Gets player out of game
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        if (Utilities.event) {
            Player player = event.getEntity();
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&l[FFA Tournament] &r&aSince you have &4died&a, you have been set to spectator mode!"));
            player.setGameMode(GameMode.SPECTATOR);

            Entity killer = player.getKiller();
            if (killer instanceof Player){
                ((Player) killer).addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 200, 2));
                ((Player) killer).addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 2));
            }
        }
    }
}
