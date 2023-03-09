package com.example.superheltev_4.controller;

import com.example.superheltev_4.DTO.HeroCityDTO;
import com.example.superheltev_4.DTO.HeroPowerDTO;
import com.example.superheltev_4.model.Superhero;
import com.example.superheltev_4.service.MyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "kea")
public class MyController {

    private MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }

    //Q1
    @GetMapping(path = "superheroes")     //localhost:8082/kea/superheroes
    public ResponseEntity<List<Superhero>> getSuperheroes() {
        List<Superhero> superheroesList = myService.getSuperheroes();
        return new ResponseEntity<>(superheroesList, HttpStatus.OK);
    }

    @GetMapping(path = "superhero/{name}")      //localhost:8082/kea/superhero/{name}
    public ResponseEntity<Superhero> superheroByName(@PathVariable String name) {
        Superhero superheroByName = myService.searchSuperhero(name);
        return new ResponseEntity<>(superheroByName, HttpStatus.OK);
    }

    //Q3
    @GetMapping(path = "superpower/{name}")     //localhost:8082/kea/superpower/{name}
    public ResponseEntity<HeroPowerDTO> powerByName (@PathVariable String name) {
        HeroPowerDTO powerByName = myService.heroPowerByName(name);
        return new ResponseEntity<>(powerByName, HttpStatus.OK);
    }


    //Q4
    @GetMapping(path = "city/{city}")     //localhost:8082/kea/city/{city}
    public ResponseEntity <List<HeroCityDTO>> heroByCity (@PathVariable String city) {
        List<HeroCityDTO> heroByCityList = myService.heroesByCity(city);
        return new ResponseEntity<>(heroByCityList, HttpStatus.OK);
    }

/*
    @PostMapping(path = "hero/create")      //localhost:8080/kea/hero/create
    public ResponseEntity<Superhero> createSuperhero(@RequestBody Superhero superhero) {
        Superhero createSuperhero = myService.createSuperhero(superhero.getName(), superhero.getSuperpower(), superhero.getIntroYear());
        return new ResponseEntity<>(createSuperhero, HttpStatus.OK);
    }

    @DeleteMapping(path = "hero/delete/{name}")     //localhost:8080/kea/hero/delete/{name}
    public ResponseEntity<Superhero> deleteSuperhero(@PathVariable String name) {
        Superhero deleteSuperhero = myService.deleteSuperhero(name);
        return new ResponseEntity<>(deleteSuperhero, HttpStatus.OK);
    }

    @PutMapping(path = "hero/edit")     //localhost:8080/kea/hero/edit
    public ResponseEntity<Superhero> editSuperhero(@RequestBody Superhero superhero) {
        Superhero editSuperhero = myService.editSuperhero(superhero);
        return new ResponseEntity<>(editSuperhero, HttpStatus.OK);
    }*/
}
