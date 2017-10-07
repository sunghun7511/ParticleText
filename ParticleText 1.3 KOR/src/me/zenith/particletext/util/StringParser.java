package me.zenith.particletext.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public final class StringParser {
	public static BufferedImage stringToBufferedImage(Font paramFont,
			String paramString) {
		BufferedImage localBufferedImage = new BufferedImage(1, 1, 6);
		Graphics localGraphics = localBufferedImage.getGraphics();
		localGraphics.setFont(paramFont);
		FontRenderContext localFontRenderContext = localGraphics
				.getFontMetrics().getFontRenderContext();
		Rectangle2D localRectangle2D = paramFont.getStringBounds(paramString,
				localFontRenderContext);
		localGraphics.dispose();
		localBufferedImage = new BufferedImage(
				(int) Math.ceil(localRectangle2D.getWidth() > 0.0D ? localRectangle2D
						.getWidth() : 1.0D),
				(int) Math.ceil(localRectangle2D.getHeight() > 0.0D ? localRectangle2D
						.getHeight() : 1.0D), 6);
		localGraphics = localBufferedImage.getGraphics();
		localGraphics.setColor(Color.black);
		localGraphics.setFont(paramFont);
		FontMetrics localFontMetrics = localGraphics.getFontMetrics();
		int i = 0;
		int j = localFontMetrics.getAscent();
		localGraphics.drawString(paramString, i, j);
		localGraphics.dispose();
		return localBufferedImage;
	}
}
