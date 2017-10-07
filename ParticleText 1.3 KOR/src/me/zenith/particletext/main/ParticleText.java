package me.zenith.particletext.main;

import me.zenith.particletext.commands.ParticleCommandExecutor;
import me.zenith.particletext.text.TextHandler;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class ParticleText extends JavaPlugin {
	public static final String ADMIN_PERMISSION = MessagesUtil.A.getString();
	private static ParticleText instance;
	public final String path = "plugins/ParticleText/";

	public static ParticleText getInstance() {
		return instance;
	}

	public void onEnable() {
		IPCheckHandler hand = new IPCheckHandler();
		if(!hand.isNotWhitelistAdded()){
			Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
				@Override
				public void run(){
					Bukkit.getConsoleSender().sendMessage(MessagesUtil.B.getString());
					Bukkit.getConsoleSender().sendMessage(MessagesUtil.C.getString());
					Bukkit.getConsoleSender().sendMessage(MessagesUtil.D.getString());
					Bukkit.getConsoleSender().sendMessage(MessagesUtil.E.getString());
					Bukkit.getConsoleSender().sendMessage(MessagesUtil.F.getString());
					Bukkit.getConsoleSender().sendMessage(MessagesUtil.G.getString());
				}
			}, 20L);
			this.getServer().getPluginManager().disablePlugin(this);
			return;
		}
		instance = this;
		registerCommands();
		loadLater(40);
	}

	public void onDisable() {
		instance = null;
	}

	public void loadLater(int paramInt) {
		new BukkitRunnable() {
			public void run() {
				TextHandler.startTask();
				ParticleText.this.loadConfiguration();
			}
		}.runTaskLater(this, paramInt);
	}

	private void registerCommands() {
		getCommand("ptext").setExecutor(new ParticleCommandExecutor());
	}

	private void loadConfiguration() {
		TextHandler.loadText();
	}

	public static void log(String paramString) {
		System.out.println(MessagesUtil.I.getString() + paramString);
	}

	public static String color(String paramString) {
		return ChatColor.translateAlternateColorCodes('&', paramString);
	}

}
