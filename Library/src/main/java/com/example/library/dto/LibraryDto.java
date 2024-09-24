package com.example.library.dto;

import com.example.library.entity.Library;
import lombok.Data;

@Data
public class LibraryDto {
    private Long id;
    private String name;
    private int year_published;
    private Long library_id;

    public LibraryDto(Library l) {
        this.id = l.getId();
        this.name = l.getName();
    }
}
