package com.example.coffeepj.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortalController {  //�������� ����
		  
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
		