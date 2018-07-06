package ru.startandroid.week2homework2;

public class Post {

    private final int idPhoto;
    private final String name;
    Post(int idPhoto, String name) {
        this.idPhoto = idPhoto;
        this.name = name;
    }

    int getIdPhoto() {
        return idPhoto;
    }

    public String getName() {
        return name;
    }
}
