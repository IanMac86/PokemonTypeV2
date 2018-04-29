package com.example.ian.poketype;


public class Pokemon {

    private String id;
    private String name;
    private String smallImg;
    private String largeImg;
    //private String types;
    private String type1;
    private String type2;
    //private String evolutions;
    private String evo1;
    private String evo2;
    private String evo3;
    private String evo4;

    public Pokemon(String id, String name, String smallImg, String largeImg, String type1, String type2, String evo1, String evo2, String evo3, String evo4) {
        this.id = id;
        this.name = name;
        this.smallImg = smallImg;
        this.largeImg = largeImg;
        this.type1 = type1;
        this.type2 = type2;
        this.evo1 = evo1;
        this.evo2 = evo2;
        this.evo3 = evo3;
        this.evo4 = evo4;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSmallImg() {
        return smallImg;
    }

    public void setSmallImg(String smallImg) {
        this.smallImg = smallImg;
    }

    public String getLargeImg() {
        return largeImg;
    }

    public void setLargeImg(String largeImg) {
        this.largeImg = largeImg;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getEvo1() {
        return evo1;
    }

    public void setEvo1(String evo1) {
        this.evo1 = evo1;
    }

    public String getEvo2() {
        return evo2;
    }

    public void setEvo2(String evo2) {
        this.evo2 = evo2;
    }

    public String getEvo3() {
        return evo3;
    }

    public void setEvo3(String evo3) {
        this.evo3 = evo3;
    }

    public String getEvo4() {
        return evo4;
    }

    public void setEvo4(String evo4) {
        this.evo4 = evo4;
    }
}