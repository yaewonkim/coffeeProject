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

	@Autowired   // �˾Ƽ� ��ü ����
	CoffeeRepository coffeeDao;
	
	
	//getCoffeeList , �Ķ���ʹ� ���� ��ü List<Coffee>������
	@CrossOrigin("*")
	@RequestMapping(value = "/getCoffeeList", method = RequestMethod.GET)
	public @ResponseBody List<Coffee> getCoffeeList() {
		System.out.println("CORS1����");
		List<Coffee> coffeeList = (List<Coffee>) coffeeDao.findAll();
		return coffeeList;
	}

	//List<int>�� �ް� List<Coffee>�� ��������, "/getCoffeeDetail"
	@CrossOrigin("*")
	@RequestMapping(value = "/getCoffeeDetail", method = RequestMethod.GET)
	public @ResponseBody List<Coffee> getCoffeeDetail(@RequestParam List<Integer> list) {
		System.out.println("CORS2����");
		List<Coffee> coffee_list = new ArrayList<Coffee>();
		for(Integer i : list){
		    System.out.println(i);
		    coffee_list.add(coffeeDao.findById(list.get(i)));
		}
		return coffee_list;
	}
	
}