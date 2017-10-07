package me.zenith.particletext.commands;

import me.zenith.particletext.main.ParticleText;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class ParticleCommand {
	protected static final String ERROR_MESSAGE = ParticleText
			.color("&c해당 번호에 대한 파티클텍스트를 찾을 수 없습니다!");
	private String trigger;
	private String[] args;
	private String permission;
	private String help;
	private String desc;
	private boolean playersOnly;

	public ParticleCommand(String trigger, String[] args, String permission,
			boolean playersOnly, String help, String desc) {
		this.trigger = trigger;
		this.args = args;
		this.permission = permission;
		this.playersOnly = playersOnly;
		this.help = help;
		this.desc = desc;
	}

	public ParticleCommand(String trigger, String permission,
			boolean playersOnly, String help, String desc) {
		this.trigger = trigger;
		this.permission = permission;
		this.playersOnly = playersOnly;
		this.args = new String[0];
		this.help = help;
		this.desc = desc;
	}

	public String getTrigger() {
		return this.trigger;
	}

	public String[] getArguments() {
		return this.args;
	}

	public String getPermission() {
		return this.permission;
	}

	public boolean isPlayersOnly() {
		return this.playersOnly;
	}

	public String getHelp() {
		return this.help;
	}

	public String getCommandDescription() {
		return this.desc;
	}

	protected abstract void execute(CommandSender paramCommandSender,
			String[] paramArrayOfString);

	public void callCommand(CommandSender sender, String[] args) {
		if ((sender.isOp()) || (sender.hasPermission(this.permission))
				|| (this.permission.equalsIgnoreCase("none"))) {
			if ((!(sender instanceof Player)) && (isPlayersOnly())) {
				sendMessage(sender, "&c플레이어만 사용이 가능한 커맨드입니다!");
			} else if (getArguments().length + 1 == args.length)
				execute(sender, args);
			else {
				sendMessage(sender, "&c명령어가 올비르지 않습니다!");
				sendMessage(sender, "&c/ptext 를 참고해주세요.");
			}
		} else
			sendMessage(sender,
					"&c당신은 권한이 없습니다!");
	}

	protected static void sendMessage(CommandSender sender, String message) {
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
	}
}
