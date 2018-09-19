package com.example.coffeepj.Controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.coffeepj.Dao.CoffeeRepository;
import com.example.coffeepj.VO.Coffee;

@CrossOrigin(origins = "*")
@RestController
public class CoffeeController {

	@Autowired   // 알아서 객체 생성
	CoffeeRepository coffeeDao;
    
	@RequestMapping(value = "/getdata", method = RequestMethod.GET)
	public List<Coffee> getCoffeeList() {
		List<Coffee> coffeeList = (List<Coffee>) coffeeDao.findAll();
		return coffeeList;
	}


	@PostMapping("/add")     // 새로운 음료등록
	public Coffee insertCoffee(@RequestBody Map<String, String> params) {
		String name = params.get("name");
		String price = params.get("price");
		String stock = params.get("stock");
		Coffee coffee = new Coffee(name, Integer.valueOf(price), Integer.valueOf(stock));
		coffeeDao.save(coffee);
		return coffee;
	}

	@GetMapping("/detail/{id}/getdata")    // detail화면 상세정보조회
	public Coffee getCoffeeDetail(@PathVariable String id) {
		Coffee coffee = coffeeDao.findById(Integer.valueOf(id));
		return coffee;
	}

	@PostMapping("/detail/{id}/delCoffee")   // 음료 삭제
	public void delCoffee(@PathVariable String id) {
		coffeeDao.delete(coffeeDao.findById(Integer.valueOf(id)));
		return;
	}
	
	@GetMapping("/detail/mod/{id}/getdata")    // 수정화면 정보띄우기
	public Coffee getCoffeeDetail2(@PathVariable String id) {
		Coffee coffee = coffeeDao.findById(Integer.valueOf(id));
		return coffee;
	}

	@PostMapping("/detail/mod/confirm")  
	public Coffee editDataConfirm(@RequestBody Map<String, String> params) {
		String name = params.get("name");
		String price = params.get("price");
		String stock = params.get("stock");
		String id = params.get("id");
		Coffee coffee = coffeeDao.findById(Integer.valueOf(id));
		
		if(name==null || name.trim().length()==0) { 
			System.out.println("name is null");
		 } 
		if(price==null || price.trim().length()==0) { 
			System.out.println("price is null");
		 }
		if(stock==null || stock.trim().length()==0) { 
			System.out.println("stock is null");
		 }


		coffee.setEditdate(Timestamp.valueOf(LocalDateTime.now()).toString()); 
		coffee.setName(name);
		coffee.setPrice(Integer.valueOf(price));
		coffee.setStock(Integer.valueOf(stock));
		coffeeDao.save(coffee);  
		return coffee;
	}
	

	
}