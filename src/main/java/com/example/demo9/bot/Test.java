package com.example.demo9.bot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

@Component
public class Test extends TelegramLongPollingBot {
    public void print(){
        System.out.println("Я ебаный компонент");
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            sendApiMethod(new SendMessage(update.getMessage().getChatId(),"her"));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "tradebeeperbot";
    }

    @Override
    public String getBotToken() {
        return "499086618:AAGtttl7ZsoTdSzNt7F1SDsH3d4SCnybTSs";
    }
}
