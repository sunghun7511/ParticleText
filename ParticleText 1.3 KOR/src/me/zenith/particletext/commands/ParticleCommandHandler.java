package me.zenith.particletext.commands;

import java.util.ArrayList;
import java.util.List;

import me.zenith.particletext.commands.subcommands.TextChangeCommand;
import me.zenith.particletext.commands.subcommands.TextChangeEffectCommand;
import me.zenith.particletext.commands.subcommands.TextChangeSizeCommand;
import me.zenith.particletext.commands.subcommands.TextCreateCommand;
import me.zenith.particletext.commands.subcommands.TextEffectListCommand;
import me.zenith.particletext.commands.subcommands.TextListCommand;
import me.zenith.particletext.commands.subcommands.TextMoveCommand;
import me.zenith.particletext.commands.subcommands.TextRemoveCommand;
import me.zenith.particletext.main.ParticleText;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class ParticleCommandHandler {
	private static List<ParticleCommand> commands = new ArrayList<ParticleCommand>();

	static {
		commands.add(new TextChangeCommand());
		commands.add(new TextChangeSizeCommand());
		commands.add(new TextChangeEffectCommand());
		commands.add(new TextCreateCommand());
		commands.add(new TextEffectListCommand());
		commands.add(new TextListCommand());
		commands.add(new TextMoveCommand());
		commands.add(new TextRemoveCommand());
	}

	public static ParticleCommand getCommand(String trigger) {
		for (ParticleCommand cmd : commands) {
			if (cmd.getTrigger().equalsIgnoreCase(trigger)) {
				return cmd;
			}
		}
		return null;
	}

	public static void callCommand(CommandSender sender, String trigger,
			String[] args) {
		ParticleCommand cmd = getCommand(trigger);
		if (cmd != null)
			cmd.callCommand(sender, args);
		else
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
					"&c해당 커맨드를 찾을 수 없습니다."));
	}

	public static List<String> getHelpPls() {
		List<String> helpMePls = new ArrayList<String>();
		for (ParticleCommand cmd : commands) {
			helpMePls.add(ParticleText.color(new StringBuilder().append("&e")
					.append(cmd.getHelp()).toString())
					+ " - &7" + cmd.getCommandDescription());
		}
		return helpMePls;
	}
}
