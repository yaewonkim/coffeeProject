package com.example.coffeepj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.coffeepj.VO.Coffee;

@SpringBootApplication
@RestController
public class CoffeepjApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeepjApplication.class, args);
	}
	
	@RequestMapping(value="/getdata", method=RequestMethod.GET)
	public ResponseEntity<Object> getData(){
		Coffee demo =new Coffee();
		demo.setName("americano");
		demo.setPrice(2000);
		return new ResponseEntity<Object>(demo,HttpStatus.OK);
	}
	
	@RequestMapping(value="/postdata", method=RequestMethod.POST)
	public ResponseEntity<Object> postData(@RequestBody Coffee demo){
		System.out.println("coffee name"+demo.getName());
		System.out.println("coffee price"+demo.getPrice());
		return new ResponseEntity<Object>("Success",HttpStatus.OK);
	}
}

