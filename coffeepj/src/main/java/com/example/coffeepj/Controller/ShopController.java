package com.example.coffeepj.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.coffeepj.Dao.CoffeeRepository;
import com.example.coffeepj.VO.Coffee;

@CrossOrigin(origins = "*")
@Controller
public class ShopController {   

	@Autowired
	CoffeeRepository coffeeDao;

	
	@CrossOrigin("*")
	@RequestMapping(value = "/getCoffeeList", method = RequestMethod.GET)
	public @ResponseBody 
	List<Coffee> getCoffeeList() {
		System.out.println("CORS1µé¾î¿È");
		List<Coffee> coffeeList = (List<Coffee>) coffeeDao.findAll();
		return coffeeList;
	}

	
	@CrossOrigin("*")
	@RequestMapping(value = "/getCoffeeDetail/{list}", method = RequestMethod.GET)
	public @ResponseBody 
	List<Coffee> getCoffeeDetail(@PathVariable String list) {
		System.out.println("CORS2µé¾î¿È");
		System.out.println("µé¾î¿Â ¸®½ºÆ®" + list); 
		String aa[] = list.split(",");
		List<Coffee> coffee_list = new ArrayList<Coffee>();
		for (int i = 0; i < aa.length; i++) {
			coffee_list.add(coffeeDao.findById(Integer.parseInt(aa[i])));
		}
		return coffee_list;
	}
	
	@CrossOrigin("*")
	@RequestMapping(value = "/coffeeSold", method = RequestMethod.GET)
	public @ResponseBody
	void postCoffeeSold(@RequestBody Map<String, String> params) {
		String coffee_id = params.get("cno");
		String num = params.get("num");
		System.out.println(coffee_id+"¹ø Ä¿ÇÇ "+num+"°³ ÆÈ·ÈÀ½");
		Coffee coffee = coffeeDao.findById(coffee_id);
		coffee.setSalesnum(coffee.getSalesnum + Integer.parseInt(num));
		coffee.setStock(coffee.getStock - Integer.parseInt(num));
		coffeeDao.save(coffee);
		return;
	}

}