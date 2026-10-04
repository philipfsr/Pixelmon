package de.souperman.listener;

import de.souperman.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class EVENTleave implements Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {

        Player p = e.getPlayer();

        Main.getTrainer(p).save();
    }
}
