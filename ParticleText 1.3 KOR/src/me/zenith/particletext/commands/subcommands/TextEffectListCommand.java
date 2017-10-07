package me.zenith.particletext.commands.subcommands;

import java.util.Arrays;
import java.util.List;

import me.zenith.particletext.commands.ParticleCommand;
import me.zenith.particletext.main.MessagesUtil;
import me.zenith.particletext.main.ParticleText;
import me.zenith.particletext.particles.ParticleEffect;
import me.zenith.particletext.text.TextHandler;

import org.bukkit.command.CommandSender;

public class TextEffectListCommand extends ParticleCommand {
	public TextEffectListCommand() {
		super("effect-list", "particle.text.admin", false,
				"/ptext effect-list", "이펙트 목록을 봅니다.");
	}

	protected void execute(CommandSender sender, String[] args) {
		sender.sendMessage(ParticleText
				.color(MessagesUtil.J.getString()));
		List<ParticleEffect> excludedEffects = Arrays.asList(TextHandler.EXCLUDED_EFFECTS);
		for (ParticleEffect e : ParticleEffect.values()) {
			if (!excludedEffects.contains(e)) {
				sendMessage(sender, "&e" + e.toString());
			}
		}
		sender.sendMessage(ParticleText
				.color(MessagesUtil.J.getString()));
	}
}
