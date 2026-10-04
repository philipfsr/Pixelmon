package de.souperman.main;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Trainer {

    private final Player player;
    private int pokeDollars;
    private float level;
    private PC pc;
    private final Pokemon[] party = new Pokemon[6];


    public Trainer(Player p) {
        this.player = p;

        TrainerData trainerData = Main.getTrainerData();

        if(trainerData.trainerExists(p.getUniqueId())) { // player exists already?
            TrainerDataEntry trainerEntry = trainerData.getTrainerDataEntry(p);

            pokeDollars = trainerEntry.getPokeDollars();
            level = trainerEntry.getLevel();
            pc = trainerEntry.getPC();
            Pokemon[] pokemon = trainerEntry.getParty();
            for(int i = 0; i < 6; i++) {
                party[i] = pokemon[i];
            }
        } else {
            pokeDollars = 100;
            level = 1;
            pc = new PC();

            trainerData.addTrainer(this);
        }
    }

    public Player getPlayer() {
        return player;
    }

    public int getPokeDollars() {
        return pokeDollars;
    }

    public float getLevel() {
        return level;
    }

    public Pokemon[] getParty() {
        return party;
    }

    public PC getPC() {
        return pc;
    }

    public void updatePokeDollars(int change) {
        this.pokeDollars += change;
    }

    public boolean hasEnoughPokeDollars(int cost) {
        return pokeDollars >= cost;
    }

    public boolean needsStarter() {
        return getPC().getPokemon().isEmpty() && Arrays.stream(party).allMatch(Objects::isNull);
    }

    public void unSummonPokemon() {
        for(int i = 0; i < 6; i++) {
            Pokemon pokemon = party[i];

            pokemon.unSummon();
        }
    }

    public boolean save() {
        YamlConfiguration config = new YamlConfiguration();
        File file = new File(Main.getPlugin().getDataFolder(), "trainerdata/" + player.getUniqueId().toString() + ".yml");

         if(file.isFile()) {

             // Trainer data:

             config.set("pokedollars", pokeDollars);
             config.set("level", level);
             //config.set("", );

             // Save party:

             List<Map<String, Object>> partyEntry = new ArrayList<>();
             for(int i = 0; i < party.length; i++) {
                 Pokemon pokemon = party[i];
                 if(pokemon == null) {

                 } else {
                     Map<String, Object> entry = new HashMap<>();

                     entry.put("type", pokemon.getType().getName());
                     entry.put("displayName", pokemon.getDisplayName());
                     entry.put("gender", pokemon.getGender().toString());
                     entry.put("IVhp", pokemon.getIVs().getHP());
                     entry.put("IVattack", pokemon.getIVs().getAttack());
                     entry.put("IVdefense", pokemon.getIVs().getDefense());
                     entry.put("IVspAttack", pokemon.getIVs().getSPAttack());
                     entry.put("IVspDefense", pokemon.getIVs().getSPDefense());
                     entry.put("IVspeed", pokemon.getIVs().getSpeed());
                     entry.put("shiny", pokemon.getIsShiny());
                     entry.put("level", pokemon.getLevel());
                     entry.put("hp", pokemon.getHP());
                     entry.put("defense", pokemon.getDefense());
                     entry.put("attack", pokemon.getAttack());
                     entry.put("spAttack", pokemon.getSPAattack());
                     entry.put("spDefense", pokemon.getSPDefense());
                     entry.put("speed", pokemon.getSpeed());
                     entry.put("evasion", pokemon.getEvasion());

                     partyEntry.add(entry);
                 }
             }
             config.set("party", partyEntry);

             // Save Pokemon in PC:

            List<Map<String, Object>> PCPokemon = new ArrayList<>();

            for(Pokemon pokemon : pc.getPokemon()) {
                Map<String, Object> entry = new HashMap<>();

                entry.put("type", pokemon.getType().getName());
                entry.put("displayName", pokemon.getDisplayName());
                entry.put("gender", pokemon.getGender().toString());
                entry.put("IVhp", pokemon.getIVs().getHP());
                entry.put("IVattack", pokemon.getIVs().getAttack());
                entry.put("IVdefense", pokemon.getIVs().getDefense());
                entry.put("IVspAttack", pokemon.getIVs().getSPAttack());
                entry.put("IVspDefense", pokemon.getIVs().getSPDefense());
                entry.put("IVspeed", pokemon.getIVs().getSpeed());
                entry.put("shiny", pokemon.getIsShiny());
                entry.put("level", pokemon.getLevel());
                entry.put("hp", pokemon.getHP());
                entry.put("defense", pokemon.getDefense());
                entry.put("attack", pokemon.getAttack());
                entry.put("spAttack", pokemon.getSPAattack());
                entry.put("spDefense", pokemon.getSPDefense());
                entry.put("speed", pokemon.getSpeed());
                entry.put("evasion", pokemon.getEvasion());

                PCPokemon.add(entry);
            }

            config.set("pc", PCPokemon);

            try {
                config.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
             return false;
        }

        return true;
    }
}
