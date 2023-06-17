package org.tuanzi.bukkitplugin;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;

public class I18n {
    private static YamlConfiguration i18nResource;

    public static String getTranslate(String id){
        return i18nResource.getString(id);
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