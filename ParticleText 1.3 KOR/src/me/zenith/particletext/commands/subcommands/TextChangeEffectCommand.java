package me.zenith.particletext.commands.subcommands;

import java.util.Arrays;

import me.zenith.particletext.commands.ParticleCommand;
import me.zenith.particletext.particles.ParticleEffect;
import me.zenith.particletext.text.TextHandler;

import org.bukkit.command.CommandSender;

public class TextChangeEffectCommand extends ParticleCommand {
	public TextChangeEffectCommand() {
		super("set-effect", new String[] { "index", "particle effect" },
				"particle.text.admin", false,
				"/ptext set-effect [번호] [이펙트]", "");
	}

	protected void execute(CommandSender sender, String[] args) {
		try {
			int index = Integer.parseInt(args[1]);
			ParticleEffect effect = ParticleEffect.fromName(args[2]);
			if ((effect != null)
					&& (!Arrays.asList(TextHandler.EXCLUDED_EFFECTS).contains(
							effect))) {
				String messageResult = TextHandler.setTextEffect(index, effect) ? "&7파티클 이펙트가 &e"
						+ effect.name() + "&7 로 바뀌었습니다!"
						: ERROR_MESSAGE;
				sendMessage(sender, messageResult);
			} else {
				sendMessage(sender, "&c해당 파티클 이펙트가 존재하지 않습니다!");
			}
		} catch (NumberFormatException e) {
			sendMessage(sender, "&c에러: '" + args[1]
					+ "' 는 숫자가 아닙니다!");
		}
	}
}
