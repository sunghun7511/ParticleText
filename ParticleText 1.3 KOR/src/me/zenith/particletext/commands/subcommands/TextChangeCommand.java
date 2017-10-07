package me.zenith.particletext.commands.subcommands;

import me.zenith.particletext.commands.ParticleCommand;
import me.zenith.particletext.text.TextHandler;
import org.bukkit.command.CommandSender;

public class TextChangeCommand extends ParticleCommand {
	public TextChangeCommand() {
		super("change", new String[] { "index", "text" },
				"particle.text.admin", false, "/ptext change [번호] [글씨]",
				"글씨를 변경합니다.");
	}

	protected void execute(CommandSender sender, String[] args) {
		try {
			int index = Integer.parseInt(args[1]);
			String text = args[2];
			String messageResult = TextHandler.changeText(index, text) ? "&7글씨가 &e"
					+ text + "&7 로 변경되었습니다!"
					: ERROR_MESSAGE;
			sendMessage(sender, messageResult);
		} catch (NumberFormatException e) {
			sendMessage(sender, "&c에러 : '" + args[1]
					+ "' 는 숫자가 아닙니다!");
		}
	}
}
