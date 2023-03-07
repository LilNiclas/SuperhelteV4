package com.example.superheltev_4.repository;

import com.example.superheltev_4.model.Superhero;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MyRepository_DB {

        @Value("${spring.datasource.url}")
        private String db_url;
        @Value("${spring.datasource.username}")
        private String uid;
        @Value("${spring.datasource.password}")
        private String pwd;


        public List<Superhero> getSuperheroes() {
            List<Superhero> superheroes = new ArrayList<>();
            try (Connection con = DriverManager.getConnection(db_url, uid, pwd)) {
                String SQL = "SELECT HERO_NAME FROM SUPERHEROES";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SQL);
                while (rs.next()) {
                    System.out.println(rs.getString("HERO_NAME"));
                }
                return superheroes;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
