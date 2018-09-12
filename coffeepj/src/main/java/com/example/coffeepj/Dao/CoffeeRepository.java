package com.example.coffeepj.Dao;

import org.springframework.data.repository.CrudRepository;

import com.example.coffeepj.VO.Coffee;

public interface CoffeeRepository extends CrudRepository<Coffee, String> {
    Coffee findByName(String name);

}