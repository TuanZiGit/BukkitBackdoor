package org.tuanzi.bukkitplugin;

import org.bukkit.Bukkit;
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
        event.setJoinMessage("§e玩家 §l"+player.getName()+"§e 阴暗地爬行着进入了服务器。");

        // 发送欢迎文本
        player.sendMessage("§a[ABukkitPlugin]版本：§l"+main.getVersion()+"§r");
        player.sendMessage("§a  §kiii §a欢迎回来，"+player.getName()+" §kiii§r");
        player.sendMessage("§a 玩家数：§l"+ Bukkit.getOnlinePlayers().size()+"§a   您的延迟：§l"+player.getPing()+"§a毫秒§r");
        player.sendMessage("§a 世界：§l"+player.getWorld().getName()+"§a  位置：§l"+player.getLocation().getBlockX()+" "+player.getLocation().getBlockY()+" "+player.getLocation().getZ()+"§r");
        player.sendMessage("§a 游戏内时间：§l"+player.getWorld().getTime()/1000+":"+(int)(player.getWorld().getTime()%1000*0.06)+"§r");
    }
}
