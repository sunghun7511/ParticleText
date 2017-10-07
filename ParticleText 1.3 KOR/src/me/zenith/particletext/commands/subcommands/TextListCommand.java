package me.zenith.particletext.commands.subcommands;

import me.zenith.particletext.commands.ParticleCommand;
import me.zenith.particletext.main.ParticleText;
import me.zenith.particletext.text.TextHandler;

import org.bukkit.command.CommandSender;

public class TextListCommand extends ParticleCommand {
	public TextListCommand() {
		super("list", "particle.text.admin", false, "/ptext list",
				"파티클텍스트 목록을 봅니다.");
	}

	protected void execute(CommandSender sender, String[] args) {
		if (TextHandler.getFormattedTextList().size() > 0) {
			for (String string : TextHandler.getFormattedTextList())
				sender.sendMessage(string);
		} else
			sender.sendMessage(ParticleText.color("&c파티클텍스트를 한개도 생성하지 않았습니다!"));
	}
}
