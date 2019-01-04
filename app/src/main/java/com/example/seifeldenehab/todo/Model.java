package com.example.seifeldenehab.todo;

public class Model {
    private String name,mail;
   private  int image,score;
    public Model(String name, String mail, int score , int image){
        this.name=name;
        this.mail=mail;
        this.image=image;
        this.score=score;

    }

    public int getImage() {
        return image;
    }

    public int getScore() {
        return score;
    }

    public String getMail() {
        return mail;
    }

    public String getName() {
        return name;
    }
}
