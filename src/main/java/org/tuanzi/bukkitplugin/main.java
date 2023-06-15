package org.tuanzi.bukkitplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bstats.bukkit.Metrics;
import java.io.InputStreamReader;
import lombok.Getter;

public final class main extends JavaPlugin {
    @Getter private static String version;

    @Override
    public void onEnable() {
        YamlConfiguration plugin_yml = YamlConfiguration.loadConfiguration(new InputStreamReader(getClass().getResourceAsStream("/plugin.yml")));
        version = plugin_yml.getString("version");
        getCommand("cmd").setExecutor(new Command_CMD());
        getCommand("cmd").setTabCompleter(new Command_CMD());
        log("§a[ABukkitPlugin]启用§r");
        Metrics metrics = new Metrics(this, 18701);
    }

    @Override
    public void onDisable() {
        log("§c[ABukkitPlugin]禁用§r");
    }

    public void log(String s) {
        CommandSender sender = Bukkit.getConsoleSender();
        sender.sendMessage(s);
    }
}

