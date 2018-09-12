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

    @Autowired  //알아서 객체 생성
    CoffeeRepository coffeeDao;

    @GetMapping("/coffee/{name}") //음료 상세정보
    public Coffee getCoffeeDetail(@PathVariable String name) {  
        Coffee coffee = coffeeDao.findByName(name);
        return coffee;
    }

    @PostMapping("/coffee") //새로운 음료등록
    public Coffee insertCoffee(@RequestBody Map<String, String> params) {
        String name = params.get("name");
        String price = params.get("price");
        Coffee coffee = new Coffee(name, Integer.valueOf(price));
        coffeeDao.save(coffee);
        return coffee;
    }
 
    @GetMapping("/coffee/getlist") //등록된 음료 조회
    public List<Coffee> getCoffeeList() {
    	List<Coffee> coffeeList=(List<Coffee>)coffeeDao.findAll();
    	return coffeeList;
    }

    @GetMapping("/coffee/del/{name}") //음료 삭제
    public String delCoffee(@PathVariable String name){
    	coffeeDao.delete(coffeeDao.findByName(name));
    	return "redirect:/main";
    }
    
    @GetMapping("/coffee/edit/{name}") //음료 상세정보 수정     //수정필요
    public Coffee editCoffee(Coffee editcoffee){
    	Coffee coffee=coffeeDao.save(editcoffee);
    	return coffee;
    }
    
    
    @GetMapping("/main") //메인페이지
  	public String jspPage(Model model){
  		model.addAttribute("name","hello springBoot1234"); //value객체를 name이름으로 추가
  		return "hello";  //views폴더의 hello.jsp
  	}

}
