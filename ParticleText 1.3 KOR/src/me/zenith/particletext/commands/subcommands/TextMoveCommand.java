package me.zenith.particletext.commands.subcommands;

import me.zenith.particletext.commands.ParticleCommand;
import me.zenith.particletext.text.TextHandler;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TextMoveCommand extends ParticleCommand {
	public TextMoveCommand() {
		super("move", new String[] { "index" }, "particle.text.admin", true,
				"/ptext move [번호]",
				"자신이 서있는 위치로 해당 파티클텍스트를 이동합니다.");
	}

	protected void execute(CommandSender sender, String[] args) {
		Player player = (Player) sender;
		try {
			int index = Integer.parseInt(args[1]);
			String messageResult = TextHandler.moveText(index,
					player.getLocation()) ? "&e성공적으로 이동하였습니다!" : ERROR_MESSAGE;
			sendMessage(sender, messageResult);
		} catch (NumberFormatException e) {
			sendMessage(sender, "&c번호이 올바르지 않습니다!");
		}
	}
}
