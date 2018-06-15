package ua.od.provectus.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "BOOK")
@Data
public class Book {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "PRICE")
    private int price;

    @Column(name = "GENRE")
    private String genre;
}
