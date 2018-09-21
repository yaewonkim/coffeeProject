package com.example.coffeepj.Controller;

import java.util.ArrayList;
import java.util.List;

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
	// �˾Ƽ� ��ü ����
	CoffeeRepository coffeeDao;

	// getCoffeeList , �Ķ���ʹ� ���� ��ü List<Coffee>������
	@CrossOrigin("*")
	@RequestMapping(value = "/getCoffeeList", method = RequestMethod.GET)
	public @ResponseBody
	List<Coffee> getCoffeeList() {
		System.out.println("CORS1����");
		List<Coffee> coffeeList = (List<Coffee>) coffeeDao.findAll();
		return coffeeList;
	}

	// List<int>�� �ް� List<Coffee>�� ��������, "/getCoffeeDetail"
	@CrossOrigin("*")
	@RequestMapping(value = "/getCoffeeDetail/{list}", method = RequestMethod.GET)
	public @ResponseBody
	List<Coffee> getCoffeeDetail(@PathVariable String list) {
		System.out.println("CORS2����");
		System.out.println("���� ����Ʈ" + list); 
		String aa[] = list.split(",");
		List<Coffee> coffee_list = new ArrayList<Coffee>();
		for (int i = 0; i < aa.length; i++) {
			coffee_list.add(coffeeDao.findById(Integer.parseInt(aa[i])));
		}
		return coffee_list;
	}

}