package me.zenith.particletext.text;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;

import me.zenith.particletext.main.ParticleText;
import me.zenith.particletext.particles.ParticleEffect;
import me.zenith.particletext.util.StringParser;
import me.zenith.particletext.util.Utilities;
import me.zenith.particletext.util.VectorUtils;

import org.bukkit.Location;
import org.bukkit.util.Vector;

public class Text {
	private ParticleEffect effect;
	private Location location;
	private String text, font;
	private float size;

	public Text(ParticleEffect paramParticleEffect, Location paramLocation,
			String paramString, String font, float paramFloat) {
		this.effect = paramParticleEffect;
		this.location = paramLocation;
		this.font = font;
		this.text = paramString;
		this.size = paramFloat;
	}

	public ParticleEffect getEffect() {
		return this.effect;
	}

	public Location getLocation() {
		return this.location;
	}

	public String getText() {
		return this.text;
	}

	public float getSize() {
		return this.size;
	}

	public void setEffect(ParticleEffect paramParticleEffect) {
		this.effect = paramParticleEffect;
	}

	public void setLocation(Location paramLocation) {
		this.location = paramLocation;
	}

	public void setText(String paramString) {
		this.text = paramString;
	}

	public void setSize(float paramFloat) {
		this.size = paramFloat;
	}

	public void display() {
		int i = 1;
		int j = 1;

		BufferedImage localBufferedImage = StringParser.stringToBufferedImage(
				new Font(font.replace("_", ""), 0, 16), this.text);
		for (int m = 0; m < localBufferedImage.getHeight(); m += j)
			for (int n = 0; n < localBufferedImage.getWidth(); n += i) {
				int k = localBufferedImage.getRGB(n, m);
				if (Color.black.getRGB() != k)
					continue;
				Vector localVector = new Vector(localBufferedImage.getWidth()
						/ 2.0F - n, localBufferedImage.getHeight() / 2.0F - m,
						0.0F).multiply(this.size);
				VectorUtils.rotateAroundAxisY(localVector,
						-this.location.getYaw() * 0.01745329F);
				this.effect.display(0.0F, 0.0F, 0.0F, 0.0F, 3,
						this.location.add(localVector), 500.0D);
				this.location.subtract(localVector);
			}
	}

	public static Text getText(String paramString) {
		int i = 5;
		String[] arrayOfString = paramString.split(",");
		if (arrayOfString.length == i) {
			ParticleEffect localParticleEffect = ParticleEffect
					.fromName(arrayOfString[0]);
			float f = Float.parseFloat(arrayOfString[1]);
			String str = arrayOfString[2];
			String font = arrayOfString[3];
			Location localLocation = Utilities
					.stringToLocation(arrayOfString[4]);
			if (localLocation != null) {
				return new Text(localParticleEffect, localLocation, str, font, f);
			}
			ParticleText.log("Unable to load text! Location was null!");
		} else {
			ParticleText
					.log("Unable to load a text! Error: Corrected Length invalid!");
		}
		return null;
	}

	public String serialize() {
		return this.effect.toString() + "," + this.size + "," + this.text + "," + this.font + ","
				+ Utilities.locationToString(this.location);
	}
}
