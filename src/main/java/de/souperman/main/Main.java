package de.souperman.main;

import de.souperman.listener.EVENTInventory;
import de.souperman.listener.EVENTjoin;
import de.souperman.listener.EVENTsummon;
import de.souperman.var.Var;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Main extends JavaPlugin {

    private static Plugin plugin;
    private static TrainerData trainerData;
    private static ArrayList<Trainer> trainers;
    private static ArrayList<Pokemon> summonedPokemon;

    @Override
    public void onEnable() {
        System.out.println("[Pixelmon] started.");

        plugin = this;
        trainerData = new TrainerData(this);
        trainers = new ArrayList<>();

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new EVENTjoin(), this);
        pm.registerEvents(new EVENTInventory(), this);
        pm.registerEvents(new EVENTsummon(), this);


        Var.pokemonMovement.runTaskTimer(this, 0, 1);
    }

    @Override
    public void onDisable() {
        System.out.println("[Pixelmon] disabled.");
    }

    public static Plugin getPlugin() {
        return plugin;
    }

    public static TrainerData getTrainerData() {
        return trainerData;
    }

    public static ArrayList<Trainer> getTrainers() {
        return trainers;
    }

    public static Trainer getTrainer(Player p) {
        for(Trainer t : trainers) {
            if(t.getPlayer() == p) {
                return t;
            }
        }
        return null;
    }

    public static ArrayList<Pokemon> getSummonedPokemon() {
        return summonedPokemon;
    }
}
