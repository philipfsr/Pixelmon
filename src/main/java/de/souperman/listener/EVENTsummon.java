package de.souperman.listener;

import de.souperman.main.Main;
import de.souperman.main.Trainer;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class EVENTsummon implements Listener {

    @EventHandler
    public void onSummon(PlayerInteractEvent e) {
        if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
            Player p = e.getPlayer();
            if(p.getItemInHand().getType() == Material.STICK) {
                Trainer t = Main.getTrainer(p);

            }

        }
    }
}
