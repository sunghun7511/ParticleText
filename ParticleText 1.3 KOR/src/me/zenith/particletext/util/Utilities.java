package me.zenith.particletext.util;

import me.zenith.particletext.main.ParticleText;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public final class Utilities {
	public static String locationToString(Location paramLocation) {
		return paramLocation.getWorld().getName() + ":" + paramLocation.getX()
				+ ":" + paramLocation.getY() + ":" + paramLocation.getZ() + ":"
				+ paramLocation.getYaw() + ":" + paramLocation.getPitch();
	}

	public static Location stringToLocation(String paramString) {
		String[] arrayOfString = paramString.split(":");
		if (arrayOfString.length == 6) {
			String str = arrayOfString[0];
			try {
				double d1 = Double.parseDouble(arrayOfString[1]);
				double d2 = Double.parseDouble(arrayOfString[2]);
				double d3 = Double.parseDouble(arrayOfString[3]);
				float f1 = Float.parseFloat(arrayOfString[4]);
				float f2 = Float.parseFloat(arrayOfString[5]);
				World localWorld = Bukkit.getWorld(str);
				if (localWorld != null)
					return new Location(localWorld, d1, d2, d3, f1, f2);
			} catch (NumberFormatException localNumberFormatException) {
				ParticleText.log("위치를 로드해올 수 없습니다!");
			}
		}
		return null;
	}
}
