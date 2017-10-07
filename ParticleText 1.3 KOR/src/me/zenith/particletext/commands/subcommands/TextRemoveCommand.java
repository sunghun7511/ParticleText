package me.zenith.particletext.commands.subcommands;

import me.zenith.particletext.commands.ParticleCommand;
import me.zenith.particletext.text.TextHandler;
import org.bukkit.command.CommandSender;

public class TextRemoveCommand extends ParticleCommand {
	public TextRemoveCommand() {
		super("remove", new String[] { "index" }, "particle.text.admin", false,
				"/ptext remove [번호]",
				"해당 파티클텍스트를 지웁니다.");
	}

	protected void execute(CommandSender sender, String[] args) {
		try {
			int index = Integer.parseInt(args[1]);
			String messageResult = TextHandler.removeText(index) ? "&e파티클텍스트가 정상적으로 지워졌습니다!"
					: ERROR_MESSAGE;
			sendMessage(sender, messageResult);
		} catch (NumberFormatException e) {
			sendMessage(sender, "&c에러 : '" + args[1]
					+ "' 는 숫자가 아닙니다!");
		}
	}
}
