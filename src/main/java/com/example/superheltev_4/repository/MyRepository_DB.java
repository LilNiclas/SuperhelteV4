package com.example.superheltev_4.repository;

import com.example.superheltev_4.DTO.HeroCityDTO;
import com.example.superheltev_4.DTO.HeroPowerDTO;
import com.example.superheltev_4.model.Superhero;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MyRepository_DB implements IRepository {

    @Value("${spring.datasource.url}")
    private String db_url;

    @Value("${spring.datasource.username}")
    private String uid;

    @Value("${spring.datasource.password}")
    private String pwd;

    //Returns all heroes
    @Override
    public List<Superhero> getSuperheroes() {
        List<Superhero> superheroes = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(db_url, uid, pwd)) {
            String SQL = "SELECT * FROM SUPERHEROES";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                int ID = rs.getInt("SUPERHERO_ID");
                String heroName = rs.getString("HERO_NAME");
                String realName = rs.getString("REAL_NAME");
                int creationYear = rs.getInt("CREATION_YEAR");
                int superpowerID = rs.getInt("SUPERPOWER_ID");
                String cityID = rs.getString("CITY_ID");

                superheroes.add(new Superhero(ID, heroName, realName, creationYear, superpowerID, cityID));
            }
            return superheroes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Returns hero by search
    @Override
    public Superhero searchHeroByName(String name) {
        Superhero heroObj = null;
        try (Connection con = DriverManager.getConnection(db_url, uid, pwd)) {
            String SQL = "SELECT * FROM SUPERHEROES WHERE HERO_NAME = ?";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int ID = rs.getInt("SUPERHERO_ID");
                String heroName = rs.getString("HERO_NAME");
                String realName = rs.getString("REAL_NAME");
                int creationYear = rs.getInt("CREATION_YEAR");
                int superpowerID = rs.getInt("SUPERPOWER_ID");
                String cityID = rs.getString("CITY_ID");
                heroObj = new Superhero(ID, heroName, realName, creationYear, superpowerID, cityID);
            }
            return heroObj;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public HeroPowerDTO heroPowerByName(String name) {
        HeroPowerDTO heroPowerObj = null;
        try (Connection con = DriverManager.getConnection(db_url, uid, pwd)) {
            String SQL = "SELECT HERO_NAME, REAL_NAME, SUPERPOWER FROM SUPERHEROES INNER JOIN SUPERPOWER USING(SUPERPOWER_ID) WHERE HERO_NAME = ?";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String heroName = rs.getString("HERO_NAME");
                String realName = rs.getString("REAL_NAME");
                String superpower = rs.getString("SUPERPOWER");
                heroPowerObj = new HeroPowerDTO(heroName, realName, superpower);
            }
            return heroPowerObj;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<HeroCityDTO> heroByCity(String city) {
        List<HeroCityDTO> heroCityDTOList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(db_url, uid, pwd)) {
            String SQL = "SELECT HERO_NAME, CITY FROM SUPERHEROES INNER JOIN CITY USING(CITY_ID) WHERE City = ?";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, city);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String heroName = rs.getString("HERO_NAME");
                String cityName = rs.getString("CITY");
                heroCityDTOList.add(new HeroCityDTO(heroName, cityName));
            }
            return heroCityDTOList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
