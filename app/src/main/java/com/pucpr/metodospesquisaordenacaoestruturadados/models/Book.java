package com.pucpr.metodospesquisaordenacaoestruturadados.models;

public class Book {

    private final String id;
    private String title;
    private int releaseYear;
    private String author;

    private String generateIdFromTitle() {
        return this.title.toLowerCase().replace(" ", "").strip();
    }

    public Book() {
        this.title = "Le petit prince";
        this.id = this.generateIdFromTitle();
        this.releaseYear = 1943;
        this.author = "Antoine de Saint-Exupéry";
    }

    public Book(String title) {
        this.title = title;
        this.id = this.generateIdFromTitle();
    }

    public Book(String id, String title, int releaseYear) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
    }

    public Book(String title, int releaseYear) {
        this.title = title;
        this.id = this.generateIdFromTitle();
        this.releaseYear = releaseYear;
    }

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Book(String title, String author) {
        this.title = title;
        this.id = this.generateIdFromTitle();
        this.author = author;
    }

    public Book(String id, String title, int releaseYear, String author) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return this.title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getReleaseYear() {
        return this.releaseYear;
    }

    public Book setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    @Override
    public String toString() {
        return String.format(
                "<Book id: %s, title: %s, releaseYear: %d, author: %s>",
                this.id,
                this.title,
                this.releaseYear,
                this.author);
    }

}
