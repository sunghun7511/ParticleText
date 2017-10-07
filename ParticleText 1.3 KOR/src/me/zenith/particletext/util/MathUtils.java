package me.zenith.particletext.util;

import java.util.Random;

public final class MathUtils {
	public static final float nanoToSec = 1.0E-009F;
	public static final float FLOAT_ROUNDING_ERROR = 1.0E-006F;
	public static final float PI = 3.141593F;
	public static final float PI2 = 6.283186F;
	public static final float SQRT_3 = 1.73205F;
	public static final float E = 2.718282F;
	static final int ATAN2_DIM = (int) Math.sqrt(16384.0D);
	private static final float INV_ATAN2_DIM_MINUS_1 = 1.0F / (ATAN2_DIM - 1);

	public static Random random = new Random();

	public static final float sin(float paramFloat) {
		return Sin.table[((int) (paramFloat * 2607.5945F) & 0x3FFF)];
	}

	public static final float cos(float paramFloat) {
		return Sin.table[((int) ((paramFloat + 1.570796F) * 2607.5945F) & 0x3FFF)];
	}

	public static final float sinDeg(float paramFloat) {
		return Sin.table[((int) (paramFloat * 45.511112F) & 0x3FFF)];
	}

	public static final float cosDeg(float paramFloat) {
		return Sin.table[((int) ((paramFloat + 90.0F) * 45.511112F) & 0x3FFF)];
	}

	public static final float atan2(float paramFloat1, float paramFloat2) {
		float f2;
		float f1;
		if (paramFloat2 < 0.0F) {
			if (paramFloat1 < 0.0F) {
				paramFloat1 = -paramFloat1;
				f2 = 1.0F;
			} else {
				f2 = -1.0F;
			}
			paramFloat2 = -paramFloat2;
			f1 = -3.141593F;
		} else {
			if (paramFloat1 < 0.0F) {
				paramFloat1 = -paramFloat1;
				f2 = -1.0F;
			} else {
				f2 = 1.0F;
			}
			f1 = 0.0F;
		}
		float f3 = 1.0F / ((paramFloat2 < paramFloat1 ? paramFloat1
				: paramFloat2) * INV_ATAN2_DIM_MINUS_1);

		if (f3 == (1.0F / 1.0F))
			return ((float) Math.atan2(paramFloat1, paramFloat2) + f1) * f2;

		int i = (int) (paramFloat2 * f3);
		int j = (int) (paramFloat1 * f3);
		return (Atan2.table[(j * ATAN2_DIM + i)] + f1) * f2;
	}

	public static final int random(int paramInt) {
		return random.nextInt(paramInt + 1);
	}

	public static final int random(int paramInt1, int paramInt2) {
		return paramInt1 + random.nextInt(paramInt2 - paramInt1 + 1);
	}

	public static final boolean randomBoolean() {
		return random.nextBoolean();
	}

	public static final boolean randomBoolean(float paramFloat) {
		return random() < paramFloat;
	}

	public static final float random() {
		return random.nextFloat();
	}

	public static final float random(float paramFloat) {
		return random.nextFloat() * paramFloat;
	}

	public static final float random(float paramFloat1, float paramFloat2) {
		return paramFloat1 + random.nextFloat() * (paramFloat2 - paramFloat1);
	}

	public static int nextPowerOfTwo(int paramInt) {
		if (paramInt == 0)
			return 1;
		paramInt--;
		paramInt |= paramInt >> 1;
		paramInt |= paramInt >> 2;
		paramInt |= paramInt >> 4;
		paramInt |= paramInt >> 8;
		paramInt |= paramInt >> 16;
		return paramInt + 1;
	}

	public static boolean isPowerOfTwo(int paramInt) {
		return (paramInt != 0) && ((paramInt & paramInt - 1) == 0);
	}

	public static int clamp(int paramInt1, int paramInt2, int paramInt3) {
		if (paramInt1 < paramInt2)
			return paramInt2;
		if (paramInt1 > paramInt3)
			return paramInt3;
		return paramInt1;
	}

	public static short clamp(short paramShort1, short paramShort2,
			short paramShort3) {
		if (paramShort1 < paramShort2)
			return paramShort2;
		if (paramShort1 > paramShort3)
			return paramShort3;
		return paramShort1;
	}

	public static float clamp(float paramFloat1, float paramFloat2,
			float paramFloat3) {
		if (paramFloat1 < paramFloat2)
			return paramFloat2;
		if (paramFloat1 > paramFloat3)
			return paramFloat3;
		return paramFloat1;
	}

	public static int floor(float paramFloat) {
		return (int) (paramFloat + 16384.0D) - 16384;
	}

	public static int floorPositive(float paramFloat) {
		return (int) paramFloat;
	}

	public static int ceil(float paramFloat) {
		return (int) (paramFloat + 16384.999999999996D) - 16384;
	}

	public static int ceilPositive(float paramFloat) {
		return (int) (paramFloat + 0.9999999000000001D);
	}

	public static int round(float paramFloat) {
		return (int) (paramFloat + 16384.5D) - 16384;
	}

	public static int roundPositive(float paramFloat) {
		return (int) (paramFloat + 0.5F);
	}

	public static boolean isZero(float paramFloat) {
		return Math.abs(paramFloat) <= 1.0E-006F;
	}

	public static boolean isZero(float paramFloat1, float paramFloat2) {
		return Math.abs(paramFloat1) <= paramFloat2;
	}

	public static boolean isEqual(float paramFloat1, float paramFloat2) {
		return Math.abs(paramFloat1 - paramFloat2) <= 1.0E-006F;
	}

	public static boolean isEqual(float paramFloat1, float paramFloat2,
			float paramFloat3) {
		return Math.abs(paramFloat1 - paramFloat2) <= paramFloat3;
	}

	private static class Atan2 {
		static final float[] table = new float[16384];

		static {
			for (int i = 0; i < MathUtils.ATAN2_DIM; i++)
				for (int j = 0; j < MathUtils.ATAN2_DIM; j++) {
					float f1 = i / MathUtils.ATAN2_DIM;
					float f2 = j / MathUtils.ATAN2_DIM;
					table[(j * MathUtils.ATAN2_DIM + i)] = (float) Math.atan2(
							f2, f1);
				}
		}
	}

	private static class Sin {
		static final float[] table = new float[16384];

		static {
			for (int i = 0; i < 16384; i++)
				table[i] = (float) Math.sin((i + 0.5F) / 16384.0F * 6.283186F);
			for (int i = 0; i < 360; i += 90)
				table[((int) (i * 45.511112F) & 0x3FFF)] = (float) Math
						.sin(i * 0.01745329F);
		}
	}
}
