package de.souperman.main;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("[Pixelmon] started.");
    }

    @Override
    public void onDisable() {
        System.out.println("[Pixelmon] disabled.");
    }
}
