package com.github.hank9999.PingPlayer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_13_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ping implements CommandExecutor {
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("ping")) {
            if (commandSender.getName().equalsIgnoreCase("CONSOLE")) {
                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "Use &7/ping <players> &rto get player's ping."));
                return true;
            }

            String playername;
            if (strings.length == 0) {
                playername = commandSender.getName();
            } else {
                playername = strings[0];
            }

            Player target = Bukkit.getServer().getPlayer(playername);
            if (target == null) {
                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9" + playername + " &4is not online!"));
                return false;
            }

            Player player = Bukkit.getPlayer(playername);
            int ping = ((CraftPlayer)player).getHandle().ping;
            String ip = player.getAddress().getAddress().getHostAddress();
            if (strings.length == 0) {
                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "Use &7/ping <players> &rto get player's ping."));
            }

            if (commandSender.hasPermission("PingPlayer.ping")) {
                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9" + playername + "&f's ip is &a" + ip));
            }

            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9" + playername + "&f's ping is &a" + ping + "ms"));
        }

        return true;
    }
}
