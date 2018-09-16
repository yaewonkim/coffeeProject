package com.example.coffeepj.Dao;

import org.springframework.data.repository.CrudRepository;

import com.example.coffeepj.VO.Garbage;

public interface GarbageRepository extends CrudRepository<Garbage, String> {
    Garbage findByName(String name);
    Garbage findById(int id);
}