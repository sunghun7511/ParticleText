package me.zenith.particletext.commands.subcommands;

import me.zenith.particletext.commands.ParticleCommand;
import me.zenith.particletext.text.TextHandler;
import org.bukkit.command.CommandSender;

public class TextChangeSizeCommand extends ParticleCommand {
	public TextChangeSizeCommand() {
		super("set-size", new String[] { "index", "size" },
				"particle.text.admin", false, "/ptext set-size [번호] [크기]",
				"파티클 텍스트의 사이즈를 변경합니다.");
	}

	protected void execute(CommandSender sender, String[] args) {
		try {
			int index = Integer.parseInt(args[1]);
			float size = Float.parseFloat(args[2]);
			String messageResult = TextHandler.setTexSize(index, size) ? "&7사이즈가 &e"
					+ size + " &7으료 변경되었습니다!"
					: ERROR_MESSAGE;
			sendMessage(sender, messageResult);
		} catch (NumberFormatException e) {
			sendMessage(sender, "&c번호 또는 사이즈가 올바르지 않습니다!");
		}
	}
}
