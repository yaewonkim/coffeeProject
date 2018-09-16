package com.example.coffeepj.VO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="coffee")

public class Coffee {
    @Id
    int id;
	String name;
    int price;
    int stock;
	String regdate;
    String editdate;
    int salesnum;
   
 
	public Coffee() {}
    
    public Coffee(String name, int price, int stock) {  
    	this.name = name;
        this.price = price;
        this.stock = stock;
    }

    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getEditdate() {
		return editdate;
	}

	public void setEditdate(String editdate) {
		this.editdate = editdate;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public int getSalesnum() {
		return salesnum;
	}

	public void setSalesnum(int salesnum) {
		this.salesnum = salesnum;
	}
	
}