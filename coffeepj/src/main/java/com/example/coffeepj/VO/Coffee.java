package com.example.coffeepj.VO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="coffee")

public class Coffee {
    @Id
	String name;
    int price;
//    int id;
//    int stock;
//    int sellednum;
//    regDate, updateDate√ﬂ∞°
   
    public Coffee() {}
    
    public Coffee(String name, int price) {
        this.name = name;
        this.price = price;
    }
    
//    public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

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

//	public int getStock() {
//		return stock;
//	}
//
//	public void setStock(int stock) {
//		this.stock = stock;
//	}
//
//	public int getSellednum() {
//		return sellednum;
//	}
//
//	public void setSellednum(int sellednum) {
//		this.sellednum = sellednum;
//	}

}