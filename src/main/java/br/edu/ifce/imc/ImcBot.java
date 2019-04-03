package br.edu.ifce.imc;

import java.text.DecimalFormat;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;


public class ImcBot extends TelegramLongPollingBot {

	public String getBotUsername() {
		
		return "imc_bot_ifce_07_bot";
	}

	public void onUpdateReceived(Update update) {
		double peso;
		double altura;
		double imc;
		
		DecimalFormat casa = new DecimalFormat("0.0");
		
			
			Message msn = update.getMessage();
			
			String texto = msn.getText();
			
			String[] s = texto.split(" ");
			
			peso = Double.parseDouble(s[0]);
			altura = Double.parseDouble(s[1]);
			
			imc = peso/Math.pow(altura, 2);
			imc *= 10000;
			
			SendMessage sm = new SendMessage();
			sm.setChatId(update.getMessage().getChatId());
			sm.setText("Seu IMC é:" +casa.format( imc));
			
			try {
				execute(sm);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	@Override
	public String getBotToken() {
		// TODO Auto-generated method stub
		return "802027400:AAFISPki11-awvzsAkigqIack2onTG5p-Iw";
	}
	
}
