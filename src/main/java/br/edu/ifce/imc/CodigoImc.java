package br.edu.ifce.imc;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class CodigoImc {

	public static void main(String[] args) {
		ApiContextInitializer.init();
		
		TelegramBotsApi bot = new TelegramBotsApi();
		
		try {
			bot.registerBot(new ImcBot());
		}catch (TelegramApiRequestException e) {
			e.printStackTrace();
		}
	}

}
