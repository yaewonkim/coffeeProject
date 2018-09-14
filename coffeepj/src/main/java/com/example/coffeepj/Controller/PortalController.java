package com.example.coffeepj.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortalController {


		@RequestMapping(value="/index")
		public String indexPage(){
			return "index";
		}
		
}
