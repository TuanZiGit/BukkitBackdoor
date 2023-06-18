package org.tuanzi.bukkitplugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerQuitListener implements Listener {
    // 玩家退出服务器事件
    @EventHandler
    public void onPlayerJoin(PlayerQuitEvent event){
        // 获取主插件线程
        JavaPlugin instance = JavaPlugin.getPlugin(main.class);

        // 获取玩家信息
        Player player = event.getPlayer();

        // 发送退出服务器信息（例：玩家 114514 咆哮着退出了服务器。）
        //event.setQuitMessage("§e玩家 §l"+player.getName()+"§e 咆哮着退出了服务器。");
        event.setQuitMessage(I18n.getFormattedTranslate(I18n.getTranslate("msg.quit"), player));
    }
}
