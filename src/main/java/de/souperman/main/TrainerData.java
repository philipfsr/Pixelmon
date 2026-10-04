package de.souperman.main;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class TrainerData {

    private File playerData;
    private Plugin plugin;

    public TrainerData(Plugin plugin) {
        this.plugin = plugin;
        playerData = new File(plugin.getDataFolder(), "trainerdata");

        if(!playerData.exists()) {
            playerData.mkdirs();
        }
    }

    public void SaveAll() {

    }

    public void addTrainer(Trainer trainer) {
        if(trainerExists(trainer.getPlayer().getUniqueId())) {
            return;
        }

        YamlConfiguration config = new YamlConfiguration();
        File file = new File(plugin.getDataFolder(), "trainerdata/" + trainer.getPlayer().getUniqueId().toString() + ".yml");

        try {
        file.createNewFile();

        config.set("pokedollars", trainer.getPokeDollars());
        config.set("level", trainer.getLevel());
        //config.set("", trainer.getParty());

        List<Map<String, Object>> partyPokemon = new ArrayList<>();
        config.set("party", partyPokemon);

        List<Map<String, Object>> PCPokemon = new ArrayList<>();
        config.set("pc", PCPokemon);

        config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public TrainerDataEntry getTrainerDataEntry(Player p) {



        TrainerDataEntry entry = new TrainerDataEntry(p.getUniqueId());
        return entry;
    }

    public boolean trainerExists(UUID uuid) {
        File file = new File(plugin.getDataFolder(), "trainerdata/" + uuid.toString() + ".yml");
        return file.exists();
    }
}
