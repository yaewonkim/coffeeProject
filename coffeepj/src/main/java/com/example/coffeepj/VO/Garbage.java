package com.example.coffeepj.VO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Garbage")
public class Garbage {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String name;
	int tot_sales_num;
	int tot_sales;
	
	public Garbage() {}
    
    public Garbage(String name, int tot_sales_num, int tot_sales) {  
    	this.name = name;
        this.tot_sales_num = tot_sales_num;
        this.tot_sales = tot_sales;
    }

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTot_sales_num() {
		return tot_sales_num;
	}
	public void setTot_sales_num(int tot_sales_num) {
		this.tot_sales_num = tot_sales_num;
	}
	public int getTot_sales() {
		return tot_sales;
	}
	public void setTot_sales(int tot_sales) {
		this.tot_sales = tot_sales;
	}
	
	
}