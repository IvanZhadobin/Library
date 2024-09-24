package com.example.library.dto;

import com.example.library.entity.Books;
import lombok.Data;

@Data
public class BooksDto {
    private Long id;
    private String title;
    private String author;
    private int year_published;
    private Long library_id;

    public BooksDto(Books b) {
        this.id = b.getId();
        this.title = b.getTitle();
        this.author = b.getAuthor();
        this.year_published = b.getYear_published();
        this.library_id = b.getLibrary_id();
    }
}
