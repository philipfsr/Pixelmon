package de.souperman.main;

import java.util.UUID;

public class TrainerDataEntry {
    private int pokedollars;
    private float level;
    private PC pc;
    private final Pokemon[] party = new Pokemon[6];
    public TrainerDataEntry(UUID uniqueId) {

    }

    public int getPokeDollars() {
        return pokedollars;
    }

    public float getLevel() {
        return level;
    }

    public PC getPC() {
        return pc;
    }

    public Pokemon[] getParty() {
        return party;
    }
}
