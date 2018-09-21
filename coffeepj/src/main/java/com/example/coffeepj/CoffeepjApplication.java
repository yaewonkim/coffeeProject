package com.example.coffeepj;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import com.example.coffeepj.Dao.CoffeeRepository;
import com.example.coffeepj.VO.Coffee;

@SpringBootApplication
@RestController
public class CoffeepjApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CoffeepjApplication.class, args);
	}
	
	@Autowired
	CoffeeRepository coffeeDao;
	public void run(String... args) throws Exception{
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		System.out.println("오늘의 날짜 점검: "+ date);
		
		//테이블 행 넣기
		coffeeDao.save(new Coffee("coffee1",1000,100));
		coffeeDao.save(new Coffee("coffee2",2000,100));
		coffeeDao.save(new Coffee("coffee3",3000,100));
		coffeeDao.save(new Coffee("coffee4",4000,100));
		coffeeDao.save(new Coffee("coffee5",5000,100));
	}
}

