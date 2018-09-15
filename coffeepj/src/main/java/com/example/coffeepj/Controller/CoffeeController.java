package com.example.coffeepj.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.coffeepj.Dao.CoffeeRepository;
import com.example.coffeepj.VO.Coffee;

@RestController
public class CoffeeController {

	@Autowired   // �˾Ƽ� ��ü ����
	CoffeeRepository coffeeDao;

	@RequestMapping(value = "/getdata", method = RequestMethod.GET)
	public List<Coffee> getCoffeeList() {
		List<Coffee> coffeeList = (List<Coffee>) coffeeDao.findAll();
		return coffeeList;
	}

	@RequestMapping(value = "/postdata", method = RequestMethod.POST)
	public ResponseEntity<Object> postData(@RequestBody Coffee demo) {
		System.out.println("coffee name" + demo.getName());
		System.out.println("coffee price" + demo.getPrice());
		return new ResponseEntity<Object>("Success", HttpStatus.OK);
	}

	@PostMapping("/add")     // ���ο� ������
	public Coffee insertCoffee(@RequestBody Map<String, String> params) {
		String name = params.get("name");
		String price = params.get("price");
		Coffee coffee = new Coffee(name, Integer.valueOf(price));
		coffeeDao.save(coffee);
		return coffee;
	}

	@GetMapping("/detail/{name}/getdata")    // detailȭ�� coffee������
	public Coffee getCoffeeDetail(@PathVariable String name) {
		Coffee coffee = coffeeDao.findByName(name);
		return coffee;
	}

	@GetMapping("/detail/mod/{name}/getdata")    // ����ȭ�� ��������
	public Coffee getCoffeeDetail2(@PathVariable String name) {
		Coffee coffee = coffeeDao.findByName(name);
		return coffee;
	}
	
	@PostMapping("/detail/{name}/delCoffee")   // ���� ����
	public void delCoffee(@PathVariable String name) {
		coffeeDao.delete(coffeeDao.findByName(name));
		return;
	}

	@PostMapping("/detail/mod/confirm")    // ���� ������ ���� //save���� ������.......!
	public Coffee editDataConfirm(@RequestBody Map<String, String> params) {
		String name = params.get("name");
		String price = params.get("price");
		String id = params.get("id");
		Coffee coffee = coffeeDao.findByName(id);
		if(name==null || name.trim().length()==0) { 
			System.out.println("name null");
		 } 
		if(price==null || price.trim().length()==0) { 
			System.out.println("price null");
		 }
		coffee.setName(name);
		coffee.setPrice(Integer.valueOf(price));
		coffeeDao.save(coffee);  
		return coffee;
	}
	
}