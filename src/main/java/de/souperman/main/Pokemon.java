package de.souperman.main;

import de.souperman.types.Gender;
import de.souperman.types.IV;
import de.souperman.types.Poketype;
import de.souperman.types.Type;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

import java.util.concurrent.ThreadLocalRandom;

public class Pokemon {

    private Trainer trainer;
    private Poketype poketype;
    private String display_Name;
    private Poketype evolution;
    private Type primary_Type;
    private Type secondary_Type;
    private Gender gender;
    private IV ivs;
    private boolean shiny;
    private float level;
    private int hp;
    private int attack;
    private int defense;
    private int sp_attack;
    private int sp_defense;
    private int speed;
    private int evasion;

    private boolean summoned;
    private Location location;

    private ItemStack body;

    public Pokemon(Poketype type) {
        this.trainer = null;
        this.poketype = type;
        this.display_Name = poketype.getName();

        this.shiny = ThreadLocalRandom.current().nextInt(4096) == 0;
        this.level = 1.0f;

        this.summoned = false;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public Poketype getType() {
        return poketype;
    }

    public String getName() {
        return poketype.getName();
    }

    public String getDisplayName() {
        return display_Name;
    }

    public Type getPrimaryType() {
        return primary_Type;
    }

    public Type getSecondaryType() {
        return secondary_Type;
    }

    public Gender getGender() {
        return gender;
    }

    public IV getIVs() {
        return ivs;
    }

    public boolean getIsShiny() {
        return shiny;
    }

    public float getLevel() {
        return level;
    }

    public int getHP() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSPAattack() {
        return sp_attack;
    }

    public int getSPDefense() {
        return sp_defense;
    }

    public int getSpeed() {
        return speed;
    }

    public int getEvasion() {
        return evasion;
    }

    public void summon() {
        //TODO

        summoned = true;
    }

    public void unSummon() {
        if (!isSummoned()) {
            return;
        }
        //TODO
        summoned = false;
    }

    private boolean isSummoned() {
        return summoned;
    }

    public void move() { //gets called every game tick
        //TODO
    }
}
