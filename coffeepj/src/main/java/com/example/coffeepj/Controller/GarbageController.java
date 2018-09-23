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
	
	
	 //coffee������ garbage���̺� �̸�, ���Ǹž�, ���Ǹŷ� �����ϱ�
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