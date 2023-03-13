package com.example.superheltev_4.repository;

import com.example.superheltev_4.DTO.CountPowerDTO;
import com.example.superheltev_4.DTO.HeroCityDTO;
import com.example.superheltev_4.DTO.HeroPowerDTO;
import com.example.superheltev_4.model.Superhero;

import java.util.List;

public interface IRepository {


    //Q1:
    public List<Superhero> getSuperheroes();
    public Superhero searchHeroByName(String name);

    //Q2
    public CountPowerDTO countPowersByName(String name);

    //Q3
    public HeroPowerDTO heroPowerByName(String name);

    //Q4
    public List<HeroCityDTO> heroByCity(String city);



}
