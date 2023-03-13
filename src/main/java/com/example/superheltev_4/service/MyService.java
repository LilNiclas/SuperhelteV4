package com.example.superheltev_4.service;

import com.example.superheltev_4.DTO.CountPowerDTO;
import com.example.superheltev_4.DTO.HeroCityDTO;
import com.example.superheltev_4.DTO.HeroPowerDTO;
import com.example.superheltev_4.model.Superhero;
import com.example.superheltev_4.repository.MyRepository_DB;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyService {

    MyRepository_DB myRepositoryDB;

    public MyService(MyRepository_DB myRepositorydb) {
        this.myRepositoryDB = myRepositorydb;
    }

    //Q1
    public List<Superhero> getSuperheroes() {
        return myRepositoryDB.getSuperheroes();
    }

    public Superhero searchSuperhero(String name) {
        return myRepositoryDB.searchHeroByName(name);
    }

    //Q2
    public CountPowerDTO countPowersByName(String name) {
        return myRepositoryDB.countPowersByName(name);
    }

    //Q3
    public HeroPowerDTO heroPowerByName(String name) {
        return myRepositoryDB.heroPowerByName(name);
    }

    //Q4
    public List<HeroCityDTO> heroesByCity(String city) {
        return myRepositoryDB.heroByCity(city);
    }
}
