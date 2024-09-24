package com.example.library.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Libraries")
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "edge_id")
    private Long id;
    private String name;

}
