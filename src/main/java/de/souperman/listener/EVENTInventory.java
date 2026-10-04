package de.souperman.listener;

import de.souperman.main.Main;
import de.souperman.main.Trainer;
import de.souperman.var.Var;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class EVENTInventory implements Listener {

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {
        if(e.getView().getTitle().equalsIgnoreCase(Var.STARTER_TITLE)) {
            Player p = (Player) e.getPlayer();
            Trainer t = Main.getTrainer(p);
            if(t != null && t.needsStarter()) {
                Bukkit.getScheduler().runTask(Main.getPlugin(), () -> {
                    p.openInventory(Var.getStarterInventory());
                });
            }
        }
    }

    @EventHandler
    public void onInvenoryClick(InventoryClickEvent e) {
        if(e.getView().getTitle().equalsIgnoreCase(Var.STARTER_TITLE)) {
            e.setCancelled(true);
            if(e.getCurrentItem().getType() == Material.STICK) {
                e.getWhoClicked().closeInventory();
            }
        }
    }
}
