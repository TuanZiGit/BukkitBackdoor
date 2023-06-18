package org.tuanzi.bukkitplugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Nullable;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class I18n {
    private static class FormatTable {
        public static String version = main.getVersion();
        public static String bukkit = Bukkit.getBukkitVersion();
        public static String svrver = Bukkit.getVersion();
        public static String mcver = Bukkit.getMinecraftVersion();
        public static String player = "";
        public static int onlinePlayers = Bukkit.getOnlinePlayers().size();
        public static int ping = 0;
        public static String world = "";
        public static double posx = -1;
        public static double posy = -1;
        public static double posz = -1;
        public static String time = "0:0";
        public static String ip = Bukkit.getIp();
        public static int port = Bukkit.getPort();
        public static double mspt = Bukkit.getAverageTickTime();
    }

    public static String getFormattedTranslate(String str, @Nullable Player player){
        if (player != null) {
            FormatTable.player = player.getName();
            FormatTable.ping = player.getPing();
            World world = player.getWorld();
            FormatTable.world = world.getName();
            Location location = player.getLocation();
            FormatTable.posx = location.getX();
            FormatTable.posy = location.getY();
            FormatTable.posz = location.getZ();
            FormatTable.time = player.getWorld().getTime() / 1000 + ":" + (int) (player.getWorld().getTime() % 1000 * 0.06);
        }
        String result = str
            .replaceAll("$IP$", FormatTable.ip)
            .replaceAll("$PORT$", new StringBuilder(FormatTable.port).toString())
            .replaceAll("$PLAYER$", FormatTable.player)
            .replaceAll("$PING$", new StringBuilder(FormatTable.ping).toString())
            .replaceAll("$BUKKIT$", FormatTable.bukkit)
            .replaceAll("$SERVER$", FormatTable.svrver)
            .replaceAll("$MINECRAFT$", FormatTable.mcver)
            .replaceAll("$VERSION$", FormatTable.version)
            .replaceAll("$ONLINE$", new StringBuilder(FormatTable.onlinePlayers).toString())
            .replaceAll("$X$", new StringBuilder((short) FormatTable.posx).toString())
            .replaceAll("$Y$", new StringBuilder((short) FormatTable.posy).toString())
            .replaceAll("$Z$", new StringBuilder((short) FormatTable.posz).toString())
            .replaceAll("$WORLD$", FormatTable.world)
            .replaceAll("$TIME$", FormatTable.time)
            .replaceAll("$MSPT$", new StringBuilder((short) FormatTable.mspt).toString());
        return result;
    }

    public static List<String> getFormattedTranslate(List<String> list, @Nullable Player player){
        if (player != null) {
            FormatTable.player = player.getName();
            FormatTable.ping = player.getPing();
            World world = player.getWorld();
            FormatTable.world = world.getName();
            Location location = player.getLocation();
            FormatTable.posx = location.getX();
            FormatTable.posy = location.getY();
            FormatTable.posz = location.getZ();
            FormatTable.time = player.getWorld().getTime() / 1000 + ":" + (int) (player.getWorld().getTime() % 1000 * 0.06);
        }
        List<String> result = new ArrayList<>();
        for (String str : list) {
            result.add(getFormattedTranslate(str, player));
        }
        return result;
    }

    private static YamlConfiguration i18nResource;

    public static String getTranslate(String id){
        return i18nResource.getString(id);
    }

    public static List<String> getTransList(String id){
        return i18nResource.getStringList(id);
    }

    public static void resetTransResource(File lang, YamlConfiguration config){
        // 保护措施
        JavaPlugin _jp = JavaPlugin.getPlugin(main.class);
        File _df = _jp.getDataFolder();
        File _lf = new File(_df, "lang");
        if(lang != _lf){
            return;
        }
        // 获取config.yml里的语言id
        String langid = config.getString("options.lang");
        // 打开lang/<语言id>.yml文件
        File langfile = new File(lang, langid + ".yml");
        // 存储，done！
        i18nResource = YamlConfiguration.loadConfiguration(langfile);
    }
}