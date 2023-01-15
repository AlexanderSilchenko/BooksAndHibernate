package com.example.booksandhibernate.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @ManyToOne
    @JoinColumn(name = "autor_id", referencedColumnName = "id")
    private Autor autor;
    @Column(name = "year")
    private int year;
    @Column(name = "genre")
    private String genre;
    @Column(name = "pages")
    private int pages;
    @Column(name = "description")
    private String description;

}
