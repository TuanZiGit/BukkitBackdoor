package org.tuanzi.bukkitplugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerJoinListener implements Listener {
    // 玩家加入服务器事件
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        //获取主插件线程
        JavaPlugin instance = JavaPlugin.getPlugin(main.class);

        // 获取玩家信息
        Player player = event.getPlayer();

        // 发送加入服务器信息（例：玩家 114514 阴暗地爬行着进入了服务器。）
        event.setJoinMessage(I18n.getFormattedTranslate(I18n.getTranslate("msg.join"), player));

        // 发送欢迎文本
        for (String msg : I18n.getFormattedTranslate(I18n.getTransList("welcome"), player)) {
            player.sendMessage(msg);
        }
    }
}
