package com.example.coffeepj.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.coffeepj.Dao.GarbageRepository;
import com.example.coffeepj.VO.Garbage;

@RestController
public class GarbageController {

	@Autowired 
	GarbageRepository garbageDao;

	
	@RequestMapping(value = "/getGarbageData", method = RequestMethod.GET)
	public List<Garbage> getGarbageData() {
		List<Garbage> garbageList = (List<Garbage>) garbageDao.findAll();
		return garbageList;
	}
	
	
	 //coffee삭제시 garbage테이블에 이름, 총판매액, 총판매량 저장하기
	@PostMapping("/addGarbage")    
	public void addGarbage(@RequestBody Map<String, String> params) {
		String name = params.get("name");
		String tot_sales_num = params.get("tot_sales_num");
		String tot_sales = params.get("tot_sales");
		Garbage garbage = new Garbage(name, Integer.valueOf(tot_sales_num), Integer.valueOf(tot_sales));
		garbageDao.save(garbage);
		return;
	}
}