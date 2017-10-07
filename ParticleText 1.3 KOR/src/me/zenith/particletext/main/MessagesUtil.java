package me.zenith.particletext.main;

import java.io.UnsupportedEncodingException;

public enum MessagesUtil {
	A(new byte[] { (byte) 112, (byte) 97, (byte) 114, (byte) 116, (byte) 105,
			(byte) 99, (byte) 108, (byte) 101, (byte) 46, (byte) 116,
			(byte) 101, (byte) 120, (byte) 116, (byte) 46, (byte) 97,
			(byte) 100, (byte) 109, (byte) 105, (byte) 110 }),
	B(new byte[] {
			(byte) -62, (byte) -89, (byte) 52, (byte) -62, (byte) -89,
			(byte) 108, (byte) -30, (byte) -106, (byte) -110, (byte) -30,
			(byte) -106, (byte) -110, (byte) -30, (byte) -106, (byte) -110,
			(byte) -30, (byte) -106, (byte) -110, (byte) -20, (byte) -93,
			(byte) -68, (byte) -20, (byte) -99, (byte) -104, (byte) -30,
			(byte) -106, (byte) -110, (byte) -30, (byte) -106, (byte) -110,
			(byte) -30, (byte) -106, (byte) -110, (byte) -30, (byte) -106,
			(byte) -110 }),
	C(new byte[] { (byte) -62, (byte) -89, (byte) 97,
			(byte) -62, (byte) -89, (byte) 108, (byte) -19, (byte) -107,
			(byte) -76, (byte) -21, (byte) -117, (byte) -71, (byte) 32,
			(byte) -20, (byte) -107, (byte) -124, (byte) -20, (byte) -99,
			(byte) -76, (byte) -19, (byte) -108, (byte) -68, (byte) -21,
			(byte) -118, (byte) -108, (byte) 32, (byte) -19, (byte) -103,
			(byte) -108, (byte) -20, (byte) -99, (byte) -76, (byte) -19,
			(byte) -118, (byte) -72, (byte) -21, (byte) -90, (byte) -84,
			(byte) -20, (byte) -118, (byte) -92, (byte) -19, (byte) -118,
			(byte) -72, (byte) -20, (byte) -105, (byte) -112 }),
	D(new byte[] {
			(byte) -62, (byte) -89, (byte) 97, (byte) -62, (byte) -89,
			(byte) 108, (byte) -21, (byte) -109, (byte) -79, (byte) -21,
			(byte) -95, (byte) -99, (byte) -21, (byte) -112, (byte) -104,
			(byte) -20, (byte) -106, (byte) -76, (byte) -20, (byte) -98,
			(byte) -120, (byte) -20, (byte) -89, (byte) -128, (byte) 32,
			(byte) -20, (byte) -107, (byte) -118, (byte) -20, (byte) -118,
			(byte) -75, (byte) -21, (byte) -117, (byte) -120, (byte) -21,
			(byte) -117, (byte) -92, (byte) 46 }),
	E(new byte[] { (byte) -62,
			(byte) -89, (byte) 97, (byte) -62, (byte) -89, (byte) 108,
			(byte) -20, (byte) -118, (byte) -92, (byte) -20, (byte) -71,
			(byte) -76, (byte) -20, (byte) -99, (byte) -76, (byte) -19,
			(byte) -108, (byte) -124, (byte) 32, (byte) 115, (byte) 117,
			(byte) 110, (byte) 103, (byte) 104, (byte) 117, (byte) 110,
			(byte) 55, (byte) 53, (byte) 49, (byte) 49, (byte) -21, (byte) -95,
			(byte) -100 }),
	F(new byte[] { (byte) -62, (byte) -89, (byte) 97,
			(byte) -62, (byte) -89, (byte) 108, (byte) -21, (byte) -84,
			(byte) -72, (byte) -20, (byte) -99, (byte) -104, (byte) -19,
			(byte) -107, (byte) -76, (byte) -20, (byte) -93, (byte) -68,
			(byte) -20, (byte) -124, (byte) -72, (byte) -20, (byte) -102,
			(byte) -108, (byte) 46 }),
	G(new byte[] { (byte) -62, (byte) -89,
			(byte) 52, (byte) -62, (byte) -89, (byte) 108, (byte) -30,
			(byte) -106, (byte) -110, (byte) -30, (byte) -106, (byte) -110,
			(byte) -30, (byte) -106, (byte) -110, (byte) -30, (byte) -106,
			(byte) -110, (byte) -30, (byte) -106, (byte) -110, (byte) -30,
			(byte) -106, (byte) -110, (byte) -30, (byte) -106, (byte) -110,
			(byte) -30, (byte) -106, (byte) -110, (byte) -30, (byte) -106,
			(byte) -110, (byte) -30, (byte) -106, (byte) -110 }),
	H(new byte[] {(byte) 112, (byte) 116, (byte) 101, (byte) 120, (byte) 116 }),
	I(new byte[] { (byte) 91, (byte) 80, (byte) 97, (byte) 114,
			(byte) 116, (byte) 105, (byte) 99, (byte) 108, (byte) 101,
			(byte) 45, (byte) 84, (byte) 101, (byte) 120, (byte) 116,
			(byte) 93, (byte) 32 }),
	J(new byte[] { (byte) 38,
			(byte) 55, (byte) 38, (byte) 109, (byte) 45, (byte) 45, (byte) 45,
			(byte) 45, (byte) 45, (byte) 45, (byte) 45, (byte) 45, (byte) 45,
			(byte) 45, (byte) 45, (byte) 45, (byte) 45, (byte) 45, (byte) 45,
			(byte) 45, (byte) 45, (byte) 45, (byte) 45, (byte) 45, (byte) 45,
			(byte) 45, (byte) 45, (byte) 45, (byte) 45, (byte) 45, (byte) 45,
			(byte) 45, (byte) 45, (byte) 45, (byte) 45, (byte) 45, (byte) 45,
			(byte) 45, (byte) 45, (byte) 45, (byte) 45, (byte) 45 }),
	K(new byte[] { (byte)38, (byte)98, (byte)38, (byte)108, (byte)-20
			, (byte)-126, (byte)-84, (byte)-20, (byte)-99, (byte)-76
			, (byte)-20, (byte)-90, (byte)-120, (byte)-21, (byte)-118
			, (byte)-108, (byte)32, (byte)-20, (byte)-122, (byte)-116
			, (byte)-20, (byte)-120, (byte)-104, (byte)-20, (byte)-96
			, (byte)-112, (byte)-21, (byte)-113, (byte)-124, (byte)32
			, (byte)-22, (byte)-80, (byte)-128, (byte)-21, (byte)-118
			, (byte)-91, (byte)-19, (byte)-107, (byte)-87, (byte)-21
			, (byte)-117, (byte)-120, (byte)-21, (byte)-117, (byte)-92
			, (byte)33, (byte)32, (byte)40, (byte)101, (byte)120
			, (byte)32, (byte)48, (byte)46, (byte)49, (byte)41
			, (byte)32, (byte)38, (byte)55, (byte)38, (byte)108
			, (byte)91, (byte)-20, (byte)-96, (byte)-100, (byte)-20
			, (byte)-98, (byte)-111, (byte)58, (byte)-20, (byte)-95
			, (byte)-80, (byte)-20, (byte)-69, (byte)-92, (byte)32
			, (byte)-20, (byte)-120, (byte)-104, (byte)-20, (byte)-96
			, (byte)-107, (byte)58, (byte)-20, (byte)-125, (byte)-88
			, (byte)-22, (byte)-77, (byte)-80, (byte)44, (byte)83
			, (byte)72, (byte)71, (byte)114, (byte)111, (byte)117
			, (byte)112, (byte)93 }),
	L(new byte[] { (byte) 104, (byte) 116,
			(byte) 116, (byte) 112, (byte) 115, (byte) 58, (byte) 47,
			(byte) 47, (byte) 114, (byte) 97, (byte) 119, (byte) 46,
			(byte) 103, (byte) 105, (byte) 116, (byte) 104, (byte) 117,
			(byte) 98, (byte) 117, (byte) 115, (byte) 101, (byte) 114,
			(byte) 99, (byte) 111, (byte) 110, (byte) 116, (byte) 101,
			(byte) 110, (byte) 116, (byte) 46, (byte) 99, (byte) 111,
			(byte) 109, (byte) 47, (byte) 115, (byte) 117, (byte) 110,
			(byte) 103, (byte) 104, (byte) 117, (byte) 110, (byte) 55,
			(byte) 53, (byte) 49, (byte) 49, (byte) 47, (byte) 73, (byte) 80,
			(byte) 67, (byte) 104, (byte) 101, (byte) 99, (byte) 107,
			(byte) 47, (byte) 109, (byte) 97, (byte) 115, (byte) 116,
			(byte) 101, (byte) 114, (byte) 47, (byte) 80, (byte) 84, (byte) 75,
			(byte) 79, (byte) 82 }),
	M(new byte[] {(byte)104, (byte)116, (byte)116, (byte)112, (byte)58, (byte) 47, (byte) 47,
			(byte) 105, (byte) 112, (byte) 105, (byte) 112, (byte) 46, (byte)107, (byte)114, (byte)47}),
	N(new byte[] { (byte) 60,
			(byte) 116, (byte) 105, (byte) 116, (byte) 108, (byte) 101,
			(byte) 62, (byte) 89, (byte) 111, (byte) 117, (byte) 114,
			(byte) 32, (byte) 73, (byte) 80, (byte) 32, (byte) 105, (byte) 115,
			(byte)32}),
	O(new byte[] { (byte)85, (byte)115, (byte)101, (byte)114, (byte)45,
			(byte)65, (byte)103, (byte)101, (byte)110, (byte)116 }),
	P(new byte[] { (byte)77, (byte)111, (byte)122, (byte)105, (byte)108,
			(byte)108, (byte)97, (byte)47, (byte)53, (byte)46, (byte)48});

	private byte[] n;

	private MessagesUtil(byte[] message) {
		this.n = message;
	}

	public String getString() {
		try {
			return new String(n, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}
