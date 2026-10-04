package de.souperman.types;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class IV {

    private int hp;
    private int attack;
    private int defense;
    private int sp_attack;
    private int sp_defense;
    private int speed;

    public IV() {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        this.hp = random.nextInt(32);
        this.attack = random.nextInt(32);
        this.defense = random.nextInt(32);
        this.sp_attack = random.nextInt(32);
        this.sp_defense = random.nextInt(32);
        this.speed = random.nextInt(32);
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
    public int getSPAttack() {
        return sp_attack;
    }
    public int getSPDefense() {
        return sp_defense;
    }
    public int getSpeed() {
        return speed;
    }
}
