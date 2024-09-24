package com.example.library.controller;

import com.example.library.dto.BooksDto;
import com.example.library.dto.LibraryDto;
import com.example.library.entity.Books;
import com.example.library.service.BookService;
import com.example.library.service.LibraryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
@AllArgsConstructor
public class LibraryController {
    private final LibraryService service;

    @GetMapping("/{id}")
    public ResponseEntity<LibraryDto> getLibraryById(@PathVariable Long id) {
        return new ResponseEntity<>(new LibraryDto(service.getLibraryById(id)), HttpStatus.OK);
    }

  /*  @GetMapping("/views")
    public ResponseEntity<List<Library>> getAll() {
    }*/

    @PostMapping("/add")
    public ResponseEntity<LibraryDto> addLibrary(@RequestBody LibraryDto libraryDto) {
        return new ResponseEntity<>(new LibraryDto(service.add(libraryDto)), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<LibraryDto> updateLibrary(@RequestBody LibraryDto libraryDto) {
        return new ResponseEntity<>(new LibraryDto(service.update(libraryDto)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
