package me.zenith.particletext.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class IPCheckHandler {
	public boolean isNotWhitelistAdded() {
		try {
			String i = "";
			{
				URL a = new URLGet().get(MessagesUtil.M.getString());
				HttpURLConnection b = (HttpURLConnection) a
						.openConnection();
				b.setRequestMethod(new b().s());
				b.setRequestProperty(MessagesUtil.O.getString(), MessagesUtil.P.getString());
				BufferedReader c = new BufferedReader(
						new InputStreamReader(b.getInputStream()));
				String d;
				String e = "";
				while ((d = c.readLine()) != null) {
					e += d + new s().o();
				}
				i = e.split(new s().o())[2].replace(
						MessagesUtil.N.getString(), "")
						.replace(new t().a(), "");
				c.close();
			}
			return new IP2().start(i);
		}catch(Exception e){
			return true;
		}
	}
}
