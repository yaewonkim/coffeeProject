package com.example.coffeepj.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.coffeepj.Dao.CoffeeRepository;

@Controller
public class PortalController {  //페이지로 연결
	
	  @Autowired  
	    CoffeeRepository coffeeDao;
	  
		@RequestMapping("/list")
		public String listPage(Model model){
			return "list";
		}
		
		@RequestMapping("/add")   
		public String addPage(Model model){
			return "add";
		}
	
		@RequestMapping("/del")   
		public String delPage(Model model){
			return "del";
		}
		
		@RequestMapping("/detail/{name}")   
		public String detailPage(Model model){
			return "detail";
		}
		
		@RequestMapping("/detail/mod/{name}")   
		public String modifyPage(Model model){
			return "mod";
		}
			
		}
		