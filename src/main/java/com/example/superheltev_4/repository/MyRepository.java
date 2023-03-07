package com.example.superheltev_4.repository;

import com.example.superheltev_4.model.Superhero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MyRepository {

    private List<Superhero> superheroes = new ArrayList<>(List.of(
            new Superhero("Superman", "Laser", false, 1932, 18.5),
            new Superhero("Spiderman", "Spider", true, 1953, 8.4),
            new Superhero("Batman", "Money", true, 1938, 7)));

    public List<Superhero> getSuperheroes() {
        return superheroes;
    }

    public Superhero searchSuperhero(String name) {

        for (Superhero hero : superheroes) {
            if (hero.getName().toLowerCase().contains(name.toLowerCase().trim())) {
                return hero;
            }
        }
        return null; //Nothing happened
    }

    public Superhero createSuperhero(String name, String superpower, boolean human, int introYear, double strengthPoint) {

        Superhero hero = new Superhero(name, superpower, human, introYear, strengthPoint);
        superheroes.add(hero);
        return hero;
    }

    public Superhero deleteSuperhero(String name) {

        for (Superhero hero : superheroes) {
            if (hero.getName().toLowerCase().contains(name.toLowerCase().trim())) {
                superheroes.remove(hero);
            }
            return hero;
        }
        return null; //Nothing happened
    }

    public Superhero editSuperhero(Superhero superhero) {
        for (Superhero hero : superheroes) {
            if (hero.getName().equals(superhero.getName())) {

                String newName = superhero.getName();
                hero.setName(newName);

                String newSuperpower = superhero.getSuperpower();
                hero.setSuperpower(newSuperpower);

                boolean newIsHuman = superhero.isHuman();
                hero.setHuman(newIsHuman);

                int newIntroYear = superhero.getIntroYear();
                hero.setIntroYear(newIntroYear);

                double newStrenghtPoints = superhero.getStrengthPoints();
                hero.setStrengthPoints(newStrenghtPoints);
            }
            return hero;
        }
        return null; //Nothing happened
    }
}