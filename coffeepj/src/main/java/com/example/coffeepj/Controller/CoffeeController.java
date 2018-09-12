package com.example.coffeepj.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.coffeepj.Dao.CoffeeRepository;
import com.example.coffeepj.VO.Coffee;

@RestController
public class CoffeeController {

    @Autowired  //�˾Ƽ� ��ü ����
    CoffeeRepository coffeeDao;

    @GetMapping("/coffee/{name}") //���� ������
    public Coffee getCoffeeDetail(@PathVariable String name) {  
        Coffee coffee = coffeeDao.findByName(name);
        return coffee;
    }

    @PostMapping("/coffee") //���ο� ������
    public Coffee insertCoffee(@RequestBody Map<String, String> params) {
        String name = params.get("name");
        String price = params.get("price");
        Coffee coffee = new Coffee(name, Integer.valueOf(price));
        coffeeDao.save(coffee);
        return coffee;
    }
 
    @GetMapping("/coffee/getlist") //��ϵ� ���� ��ȸ
    public List<Coffee> getCoffeeList() {
    	List<Coffee> coffeeList=(List<Coffee>)coffeeDao.findAll();
    	return coffeeList;
    }

    @GetMapping("/coffee/del/{name}") //���� ����
    public String delCoffee(@PathVariable String name){
    	coffeeDao.delete(coffeeDao.findByName(name));
    	return "redirect:/main";
    }
    
    @GetMapping("/coffee/edit/{name}") //���� ������ ����     //�����ʿ�
    public Coffee editCoffee(Coffee editcoffee){
    	Coffee coffee=coffeeDao.save(editcoffee);
    	return coffee;
    }
    
    
    @GetMapping("/main") //����������
  	public String jspPage(Model model){
  		model.addAttribute("name","hello springBoot1234"); //value��ü�� name�̸����� �߰�
  		return "hello";  //views������ hello.jsp
  	}

}
