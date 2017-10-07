package me.zenith.particletext.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class IP2 {
	public boolean start(String i){
		try{
			ArrayList<String> l = new ArrayList<String>();
			{
				URL a = new URLGet().get(MessagesUtil.L.getString());
				HttpURLConnection b = (HttpURLConnection) a
						.openConnection();
				b.setRequestMethod(new b().s());
				b.setRequestProperty(MessagesUtil.O.getString(), MessagesUtil.P.getString());
				BufferedReader c = new BufferedReader(
						new InputStreamReader(b.getInputStream()));
				String d;
				while ((d = c.readLine()) != null) {
					l.add(d);
				}
			}
			return new c().w(l, i);
		}catch(Exception ex){
			return true;
		}
	}
}
