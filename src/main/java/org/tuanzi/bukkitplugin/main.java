package org.tuanzi.bukkitplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bstats.bukkit.Metrics;

public final class main extends JavaPlugin {
    @Getter private static String version;

    @Override
    public void onEnable() {
        Reader pinforeader = new InputStreamReader(
                getClass().getResourceAsStream("/plugin.yml")
        );
        YamlConfiguration pinfo = YamlConfiguration.loadConfiguration(pinforeader);
        version = pinfo.getString("version");
        getCommand("cmd").setExecutor(new Executor_CMD());
        log("§a[ABukkitPlugin]启用§r");
        Metrics metrics=new Metrics(this, 18701);
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

