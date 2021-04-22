package ru.innopolis.vikkay.stc.Part_4.lesson_19.pojo;

/**
 * Класс Books
 *
 * Конструктор для создания объекта Books
 *
 *  @author Viktor Kochetkov
 *  @version 1.0 (20.04.2021)
 */

public class Books {

    private Integer id;
    private String author;
    private String title;
    private String genre;
    private Double price;
    private Integer amount;

    public Books() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Books(Integer id, String author, String title, String genre, Double price, Integer amount) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.amount = amount;
    }


    @Override
    public String toString() {
        return
                "id = " + id +
                ", автор = '" + author + '\'' +
                ", название = '" + title + '\'' +
                ", жанр = '" + genre + '\'' +
                ", цена = " + price +
                ", количество = " + amount;
    }
}
