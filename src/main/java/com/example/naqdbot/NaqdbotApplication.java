package com.example.naqdbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class NaqdbotApplication {

    public static void main(String[] args) throws TelegramApiException {
        SpringApplication.run(NaqdbotApplication.class, args);



        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);

        try {
            telegramBotsApi.registerBot(new TelegramBots());
        }catch (TelegramApiRequestException e){
            e.printStackTrace();
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }


    }

}
