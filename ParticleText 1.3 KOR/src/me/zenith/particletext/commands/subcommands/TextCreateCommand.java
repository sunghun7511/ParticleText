package me.zenith.particletext.commands.subcommands;

import me.zenith.particletext.commands.ParticleCommand;
import me.zenith.particletext.particles.ParticleEffect;
import me.zenith.particletext.text.TextHandler;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TextCreateCommand extends ParticleCommand {
	public TextCreateCommand() {
		super("create", new String[] { "particle", "text", "font", "size"},
				"particle.text.admin", true,
				"/ptext create [이펙트] [글씨] [폰트] [크기]",
				"새로운 파티클텍스틀 만듭니다. (띄워쓰기는 _)");
	}

	protected void execute(CommandSender sender, String[] args) {
		Player player = (Player) sender;
		ParticleEffect effect = ParticleEffect.fromName(args[1]);
		if (effect != null) {
			String text = args[2];
			try {
				float size = Float.parseFloat(args[4]);
				TextHandler.addText(effect, player.getLocation(),
						text.replace("_", " "), args[3], size);
				sendMessage(sender, "&e새로운 파티클텍스트가 생성되었습니다!");
				player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0F,0.7F);
			} catch (NumberFormatException e) {
				sendMessage(sender, "&c텍스트 크기가 올바르지 않습니다!");
			}
		} else {
			sendMessage(sender,
					"&c이펙트를 찾을 수 없습니다! /ptext effect-list 를 참고해주세요.");
		}
	}
}
