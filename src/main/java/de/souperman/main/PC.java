package de.souperman.main;

import java.util.ArrayList;

public class PC {
    private ArrayList<Pokemon> pokemon;

    public PC() {
        pokemon = new ArrayList<>();
    }

    public PC(ArrayList<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

    public ArrayList<Pokemon> getPokemon() {
        return pokemon;
    }

    public boolean addPokemon(Pokemon pokemon) {

        return false;
    }
}
