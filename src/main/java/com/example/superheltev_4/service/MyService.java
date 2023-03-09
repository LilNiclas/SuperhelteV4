package com.example.superheltev_4.service;

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


    public List<Superhero> getSuperheroes() {
        return myRepositoryDB.getSuperheroes();
    }

    public Superhero searchSuperhero(String name) {
        return myRepositoryDB.searchHeroByName(name);
    }

    public HeroPowerDTO heroPowerByName(String name) {
        return myRepositoryDB.heroPowerByName(name);
    }

    public List<HeroCityDTO> heroesByCity(String city) {
        return myRepositoryDB.heroByCity(city);
    }

    //MyRepository myRepository;

/*
    public Superhero createSuperhero(String name, String superpower, boolean human, int introYear, double strengthPoint) {
        return myRepository.createSuperhero(name, superpower, human, introYear, strengthPoint);
    }

    public Superhero deleteSuperhero(String name) {
        return myRepository.deleteSuperhero(name);
    }

    public Superhero editSuperhero(Superhero superhero) {
        Superhero returnSuperhero = myRepository.editSuperhero(superhero);
        return returnSuperhero;
    }*/

}
