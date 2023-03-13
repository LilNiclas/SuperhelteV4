package com.example.superheltev_4.DTO;

public class CountPowerDTO {

    private String heroName;


    private String realName;
    private int powerCount;

    public CountPowerDTO(String heroName, String realName, int powerCount) {
        this.heroName = heroName;
        this.realName = realName;
        this.powerCount = powerCount;
    }

    public String getHeroName() {
        return heroName;
    }

    public String getRealName() {
        return realName;
    }

    public int getPowerCount() {
        return powerCount;
    }
}
