package com.github.hank9999.PingPlayer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class PingPlayer extends JavaPlugin {
    public static PingPlayer plugin;

    public PingPlayer() {
    }

    public void onLoad() {
        this.getLogger().info(ChatColor.BLUE + "获取玩家Ping值插件正在加载");
    }

    public void onEnable() {
        plugin = this;
        this.getLogger().info(ChatColor.BLUE + "获取玩家Ping值插件已启用");
        this.getLogger().info(ChatColor.GOLD + "版本v1.0.1");
        Bukkit.getPluginCommand("ping").setExecutor(new ping());
    }

    public void onDisable() {
        plugin = null;
        this.getLogger().info(ChatColor.BLUE + "获取玩家Ping值插件已停用");
    }
}