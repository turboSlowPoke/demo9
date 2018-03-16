package com.example.demo9;

import com.example.demo9.bot.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Demo9Application {


	private static Test test;

	@Autowired
	public Demo9Application(Test test) {
		this.test=test;
	}

	public static void main(String[] args) {
		ApiContextInitializer.init();
		SpringApplication.run(Demo9Application.class, args);
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
		test.print();
		try {
			telegramBotsApi.registerBot(test);
		} catch (TelegramApiRequestException e) {
			e.printStackTrace();
		}

	}

	@PostConstruct
	public void init(){
		test.print();
	}
}
