package me.zenith.particletext.text;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import me.zenith.particletext.main.ParticleText;
import me.zenith.particletext.particles.ParticleEffect;

import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.scheduler.BukkitRunnable;

public class TextHandler {
	public static final ParticleEffect[] EXCLUDED_EFFECTS = {
			ParticleEffect.WATER_BUBBLE, ParticleEffect.SUSPENDED,
			ParticleEffect.FOOTSTEP, ParticleEffect.BARRIER,
			ParticleEffect.ITEM_CRACK, ParticleEffect.BLOCK_CRACK,
			ParticleEffect.BLOCK_DUST, ParticleEffect.WATER_DROP,
			ParticleEffect.ITEM_TAKE, ParticleEffect.MOB_APPEARANCE };
	private static List<Text> textList = new ArrayList<Text>();
	private static int interval = 10;

	public static void loadText() {
		File localFile = 
				new File(ParticleText.
				getInstance().
				path 
				+ "config.yml");
		if (localFile.exists()) {
			YamlConfiguration localYamlConfiguration = YamlConfiguration
					.loadConfiguration(localFile);
			List<String> localList = localYamlConfiguration
					.getStringList("text-list");
			interval = localYamlConfiguration.getInt("interval");
			for (String str : localList) {
				Text localText = Text.getText(str);
				if (localText != null)
					textList.add(localText);
			}
		} else {
			ParticleText.getInstance().saveDefaultConfig();
			loadText();
		}
	}

	public static List<String> getFormattedTextList() {
		ArrayList<String> localArrayList = new ArrayList<String>();
		for (Text localText : textList) {
			int i = textList.indexOf(localText);
			localArrayList.add(ParticleText.color("&e색인:&6 " + i));
			localArrayList.add(ParticleText.color("  &e위치: &6"
					+ localText.getLocation().getWorld().getName() + ", "
					+ localText.getLocation().getBlockX() + ", "
					+ localText.getLocation().getBlockY() + ", "
					+ localText.getLocation().getBlockZ()));
			localArrayList.add(ParticleText.color("  &e크기: &6"
					+ localText.getSize() + "f"));
			localArrayList.add(ParticleText.color("  &e이펙트: &6"
					+ localText.getEffect().name()));
			localArrayList.add(ParticleText.color("  &e글씨: &6"
					+ localText.getText()));
		}
		return localArrayList;
	}

	public static boolean setTextEffect(int paramInt,
			ParticleEffect paramParticleEffect) {
		Text localText = getTextAt(paramInt);
		if (localText != null) {
			localText.setEffect(paramParticleEffect);
			saveConfigurationFile();
			return true;
		}
		return false;
	}

	public static boolean changeText(int paramInt, String paramString) {
		Text localText = getTextAt(paramInt);
		if (localText != null) {
			localText.setText(paramString.replace("_", " "));
			saveConfigurationFile();
			return true;
		}
		return false;
	}

	public static boolean moveText(int paramInt, Location paramLocation) {
		Text localText = getTextAt(paramInt);
		if (localText != null) {
			localText.setLocation(paramLocation);
			saveConfigurationFile();
			return true;
		}
		return false;
	}

	public static boolean setTexSize(int paramInt, float paramFloat) {
		Text localText = getTextAt(paramInt);
		if (localText != null) {
			localText.setSize(paramFloat);
			return true;
		}
		return false;
	}

	public static Text getTextAt(int paramInt) {
		try {
			return (Text) textList.get(paramInt);
		} catch (IndexOutOfBoundsException localIndexOutOfBoundsException) {
		}
		return null;
	}

	public static void addText(ParticleEffect paramParticleEffect,
			Location paramLocation, String paramString, String font, float paramFloat) {
		textList.add(new Text(paramParticleEffect, paramLocation, paramString
				.replace(",", ""), font, paramFloat));
		saveConfigurationFile();
	}

	public static boolean removeText(int paramInt) {
		try {
			textList.remove(paramInt);
			saveConfigurationFile();
			return true;
		} catch (IndexOutOfBoundsException localIndexOutOfBoundsException) {
		}
		return false;
	}

	public static void saveConfigurationFile() {
		File localFile = new File(ParticleText.getInstance().getDataFolder(),
				"config.yml");
		if (localFile.exists()) {
			YamlConfiguration localYamlConfiguration = YamlConfiguration
					.loadConfiguration(localFile);
			localYamlConfiguration.set("text-list", getSerializedText());
			try {
				localYamlConfiguration.save(localFile);
			} catch (IOException localIOException) {
				localIOException.printStackTrace();
			}
		}
	}

	private static List<String> getSerializedText() {
		ArrayList<String> localArrayList = new ArrayList<String>();
		for (Text localText : textList) {
			localArrayList.add(localText.serialize());
		}
		return localArrayList;
	}

	public static void startTask() {
		new BukkitRunnable() {
			public void run() {
				for (Text localText : TextHandler.textList)
					if (localText != null)
						localText.display();
			}
		}.runTaskTimer(ParticleText.getInstance(), 0L, interval);
	}
}
