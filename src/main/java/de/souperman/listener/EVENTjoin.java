package de.souperman.listener;

import de.souperman.main.Main;
import de.souperman.main.Trainer;
import de.souperman.var.Var;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;

import java.util.UUID;

public class EVENTjoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        if(firstLogin(p.getUniqueId())) {
            //first time
            Bukkit.broadcastMessage("§a> §fWelcome to the server!");

        }
        e.setJoinMessage("§a+§f " + p.getDisplayName() + " joined");

        Trainer trainer = new Trainer(p); // handles returning players in constructor
        Main.getTrainers().add(trainer);

        if(trainer.needsStarter()) {
            Inventory starterPick = Var.getStarterInventory();
            p.openInventory(starterPick);
        }
    }

    private static boolean firstLogin(UUID uuid) {
        return !Main.getTrainerData().trainerExists(uuid);
    }
}
