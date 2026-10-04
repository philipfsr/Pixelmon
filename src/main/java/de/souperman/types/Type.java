package de.souperman.types;

import java.util.Map;

import static java.util.Map.entry;

public enum Type {
    NONE,
    BUG,
    DARK,
    DRAGON,
    ELECTRIC,
    FAIRY,
    FIGHTING,
    FIRE,
    FLYING,
    GHOST,
    GRASS,
    GROUND,
    ICE,
    NORMAL,
    POISON,
    PSYCHIC,
    ROCK,
    STEEL,
    WATER;

    private static final Map<Type, Map<Type, Float>> EFFECTIVENESS = Map.ofEntries(
            entry(BUG, Map.of(
                    FIRE, 0.5f,
                    GRASS, 2f,
                    FIGHTING, 0.5f,
                    POISON, 0.5f,
                    FLYING, 0.5f,
                    PSYCHIC, 2f,
                    GHOST, 0.5f,
                    DARK, 2f,
                    STEEL, 0.5f,
                    FAIRY, 0.5f
            )),
            entry(DARK, Map.of(
                    FIGHTING, 0.5f,
                    PSYCHIC, 2f,
                    GHOST, 2f,
                    DARK, 0.5f,
                    FAIRY, 0.5f
            )),
            entry(DRAGON, Map.of(
                    DRAGON, 2f,
                    STEEL, 0.5f,
                    FAIRY, 0f
            )),
            entry(ELECTRIC, Map.of(
                    WATER, 2f,
                    ELECTRIC, 0.5f,
                    GRASS, 0.5f,
                    GROUND, 0f,
                    FLYING, 2f,
                    DRAGON, 0.5f
            )),
            entry(FAIRY, Map.of(
                    FIRE, 0.5f,
                    FIGHTING, 2f,
                    POISON, 0.5f,
                    DRAGON, 2f,
                    DARK, 2f,
                    STEEL, 0.5f
            )),
            entry(FIGHTING, Map.ofEntries(
                    entry(NORMAL, 2f),
                    entry(ICE, 2f),
                    entry(ROCK, 2f),
                    entry(DARK, 2f),
                    entry(STEEL, 2f),
                    entry(POISON, 0.5f),
                    entry(FLYING, 0.5f),
                    entry(PSYCHIC, 0.5f),
                    entry(BUG, 0.5f),
                    entry(FAIRY, 0.5f),
                    entry(GHOST, 0f)
            )),
            entry(FIRE, Map.of(
                    FIRE, 0.5f,
                    WATER, 0.5f,
                    GRASS, 2f,
                    ICE, 2f,
                    BUG, 2f,
                    ROCK, 0.5f,
                    DRAGON, 0.5f,
                    STEEL, 2f
            )),
            entry(FLYING, Map.of(
                    ELECTRIC, 0.5f,
                    GRASS, 2f,
                    FIGHTING, 2f,
                    BUG, 2f,
                    ROCK, 0.5f,
                    STEEL, 0.5f
            )),
            entry(GHOST, Map.of(
                    NORMAL, 0f,
                    PSYCHIC, 2f,
                    GHOST, 2f,
                    DARK, 0.5f
            )),
            entry(GRASS, Map.of(
                    FIRE, 0.5f,
                    WATER, 2f,
                    GRASS, 0.5f,
                    POISON, 0.5f,
                    GROUND, 2f,
                    FLYING, 0.5f,
                    BUG, 0.5f,
                    ROCK, 2f,
                    DRAGON, 0.5f,
                    STEEL, 0.5f
            )),
            entry(GROUND, Map.of(
                    FIRE, 2f,
                    ELECTRIC, 2f,
                    GRASS, 0.5f,
                    POISON, 2f,
                    FLYING, 0f,
                    BUG, 0.5f,
                    ROCK, 2f,
                    STEEL, 2f
            )),
            entry(ICE, Map.of(
                    FIRE, 0.5f,
                    WATER, 0.5f,
                    GRASS, 2f,
                    ICE, 0.5f,
                    GROUND, 2f,
                    FLYING, 2f,
                    DRAGON, 2f,
                    STEEL, 0.5f
            )),
            entry(NORMAL, Map.of(
                    GHOST, 0f,
                    ROCK, 0.5f,
                    STEEL, 0.5f
            )),
            entry(POISON, Map.of(
                    GRASS, 2f,
                    POISON, 0.5f,
                    GROUND, 0.5f,
                    ROCK, 0.5f,
                    GHOST, 0.5f,
                    STEEL, 0f,
                    FAIRY, 2f
            )),
            entry(PSYCHIC, Map.of(
                    FIGHTING, 2f,
                    POISON, 2f,
                    PSYCHIC, 0.5f,
                    DARK, 0f,
                    STEEL, 0.5f
            )),
            entry(ROCK, Map.of(
                    FIRE, 2f,
                    ICE, 2f,
                    FIGHTING, 0.5f,
                    GROUND, 0.5f,
                    FLYING, 2f,
                    BUG, 2f,
                    STEEL, 0.5f
            )),
            entry(STEEL, Map.of(
                    FIRE, 0.5f,
                    WATER, 0.5f,
                    ELECTRIC, 0.5f,
                    ICE, 2f,
                    ROCK, 2f,
                    STEEL, 0.5f,
                    FAIRY, 2f
            )),
            entry(WATER, Map.of(
                    FIRE, 2f,
                    WATER, 0.5f,
                    GRASS, 0.5f,
                    GROUND, 2f,
                    ROCK, 2f,
                    DRAGON, 0.5f
            ))
    );

    public float getEffectiveness(Type defending) {
        return EFFECTIVENESS.getOrDefault(this, Map.of()).getOrDefault(defending, 1f);
    }
}
