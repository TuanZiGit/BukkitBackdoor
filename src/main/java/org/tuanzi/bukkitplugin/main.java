package org.tuanzi.bukkitplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bstats.bukkit.Metrics;
import java.io.InputStreamReader;
import java.io.File;
import lombok.Getter;

public final class main extends JavaPlugin {
    // 定义 getVersion()
    @Getter private static String version;

    // 启用插件
    @Override
    public void onEnable() {
        // 检测文件存在性
        if(!new File(getDataFolder(), "config.yml").exists()) this.saveDefaultConfig();
        if(!new File(getDataFolder(), "lang").exists()) saveResource("lang", true);

        // 插件属性文件
        YamlConfiguration plugin_yml = YamlConfiguration.loadConfiguration(new InputStreamReader(getClass().getResourceAsStream("/plugin.yml")));

        // 获取版本
        version = plugin_yml.getString("version");

        // 获取配置文件
        FileConfiguration config = this.getConfig();

        // 初始化i18n
        I18n.resetTransResource(new File(getDataFolder(), "lang"), (YamlConfiguration) config);

        // 注册命令/补全
        getCommand("cmd").setExecutor(new Command_CMD());
        getCommand("cmd").setTabCompleter(new Command_CMD());

        // 注册事件
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(),this);
        Bukkit.getPluginManager().registerEvents(new PlayerQuitListener(),this);

        // 发送启用信息
        log("§a[ABukkitPlugin]启用§r");

        // 使用 bStats Metrics 统计信息
        Metrics metrics = new Metrics(this, 18701);
    }

    // 禁用插件
    @Override
    public void onDisable() {
        // 发送禁用信息
        log("§c[ABukkitPlugin]禁用§r");
    }

    // 控制台发送信息
    public void log(String s) {
        // 获取控制台
        CommandSender sender = Bukkit.getConsoleSender();

        // 发送信息
        sender.sendMessage(s);
    }
}

