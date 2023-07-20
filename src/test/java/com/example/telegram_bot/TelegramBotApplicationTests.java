package com.example.telegram_bot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@SpringBootTest
class TelegramBotApplicationTests {

	String token = "6243957338:AAGmxOL8MwnBOXi5Lj4QjslET-fmLK4I-FU";
	String chatId = "6262955713";
	String text = URLEncoder.encode("테스트", "UTF-8");

	BufferedReader in = null;

	TelegramBotApplicationTests() throws UnsupportedEncodingException {
	}

	@Test
	void contextLoads() {
		try {
			URL obj = new URL("https://api.telegram.org/bot" + token + "/sendmessage?chat_id=" + chatId + "&text=" + text); // 호출할 url
			System.out.println(obj);

			HttpURLConnection con = (HttpURLConnection)obj.openConnection();
			con.setRequestMethod("GET");
			in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String line;

			while((line = in.readLine()) != null) { // response를 차례대로 출력
				System.out.println(line);
			}

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) try { in.close(); } catch(Exception e) { e.printStackTrace(); }
		}
	}

}
