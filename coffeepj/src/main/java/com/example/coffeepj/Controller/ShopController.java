package com.example.coffeepj.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.coffeepj.Dao.CoffeeRepository;
import com.example.coffeepj.VO.Coffee;

@CrossOrigin(origins = "*")
@Controller
public class ShopController {

	@Autowired   // 알아서 객체 생성
	CoffeeRepository coffeeDao;
	
	
	//getCoffeeList , 파라미터는 없고 전체 List<Coffee>보내기
	@CrossOrigin("*")
	@RequestMapping(value = "/getCoffeeList", method = RequestMethod.GET)
	public @ResponseBody List<Coffee> getCoffeeList() {
		System.out.println("CORS1들어옴");
		List<Coffee> coffeeList = (List<Coffee>) coffeeDao.findAll();
		return coffeeList;
	}

	//List<int>로 받고 List<Coffee>로 내보내기, "/getCoffeeDetail"
	@CrossOrigin("*")
	@RequestMapping(value = "/getCoffeeDetail", method = RequestMethod.GET)
	public @ResponseBody List<Coffee> getCoffeeDetail(@RequestParam List<Integer> list) {
		System.out.println("CORS2들어옴");
		List<Coffee> coffee_list = new ArrayList<Coffee>();
		for(Integer i : list){
		    System.out.println(i);
		    coffee_list.add(coffeeDao.findById(list.get(i)));
		}
		return coffee_list;
	}
	
}