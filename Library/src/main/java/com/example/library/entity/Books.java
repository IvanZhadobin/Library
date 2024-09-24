package com.example.library.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Books { //подправить id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "edge_id")
    private Long id;
    private String title;
    private String author;
    private int year_published;
    private Long library_id;
}
