package de.souperman.var;

import de.souperman.main.Main;
import de.souperman.main.Pokemon;
import de.souperman.types.Poketype;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class Var {

    public static final String STARTER_TITLE = "§cPick §fYour §cStarter!";

    public static final BukkitRunnable pokemonMovement = new BukkitRunnable() {
        @Override
        public void run() {
            for(Pokemon pokemon : Main.getSummonedPokemon()) {
                pokemon.move();
            }
        }
    };

    public static Inventory getStarterInventory() {

        Inventory inv = Bukkit.createInventory(null, 45, STARTER_TITLE);

        //gen 1

        ItemStack bulbasaur = new ItemStack(Material.STICK);
        ItemMeta bulbasaurMeta = bulbasaur.getItemMeta();
        bulbasaurMeta.setCustomModelData(10001);
        bulbasaurMeta.setDisplayName("§3"+Poketype.BULBASAUR.getName());
        bulbasaurMeta.setMaxStackSize(1);
        //TODO add lore?
        bulbasaur.setItemMeta(bulbasaurMeta);

        ItemStack squirtle = new ItemStack(Material.STICK);
        ItemMeta squirtleMeta = squirtle.getItemMeta();
        squirtleMeta.setCustomModelData(10004);
        squirtleMeta.setDisplayName("§3"+Poketype.SQUIRTLE.getName());
        squirtleMeta.setMaxStackSize(1);
        //TODO add lore?
        squirtle.setItemMeta(squirtleMeta);

        ItemStack charmander = new ItemStack(Material.STICK);
        ItemMeta charmanderMeta = charmander.getItemMeta();
        charmanderMeta.setCustomModelData(10007);
        charmanderMeta.setDisplayName("§3"+Poketype.CHARMANDER.getName());
        charmanderMeta.setMaxStackSize(1);
        //TODO add lore?
        charmander.setItemMeta(charmanderMeta);

        //gen 2

        //ItemStack  = new ItemStack(Material.STICK);

        //ItemStack  = new ItemStack(Material.STICK);

        //ItemStack  = new ItemStack(Material.STICK);

        //gen 3



        inv.setItem(9, bulbasaur);

        return inv;
    }
}
