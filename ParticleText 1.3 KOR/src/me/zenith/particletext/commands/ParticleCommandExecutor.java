package me.zenith.particletext.commands;

import me.zenith.particletext.main.MessagesUtil;
import me.zenith.particletext.main.ParticleText;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ParticleCommandExecutor implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (args.length == 0) {
			sender.sendMessage(ParticleText
					.color(MessagesUtil.J.getString()));
			for (String help : ParticleCommandHandler.getHelpPls()) {
				sender.sendMessage(ParticleText.color(help));
			}
			sender.sendMessage(ParticleText
					.color(MessagesUtil.K.getString()));
		} else {
			ParticleCommandHandler.callCommand(sender, args[0], args);
		}
		return false;
	}
}
