package com.example.library.controller;

import com.example.library.dto.BooksDto;
import com.example.library.entity.Books;
import com.example.library.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
@AllArgsConstructor
public class BookController {
    private final BookService service;

    @GetMapping("/{id}")
    public ResponseEntity<BooksDto> getBookById(@PathVariable Long id) {
        return new ResponseEntity<>(new BooksDto(service.getBookById(id)), HttpStatus.OK);
    }

    @GetMapping("/views")
    public ResponseEntity<List<Books>> getBooks(){
        return new ResponseEntity<>(service.getBooks(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<BooksDto> addCar(@RequestBody BooksDto booksDto){
        return new ResponseEntity<>(new BooksDto(service.add(booksDto)), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<BooksDto> updateCar(@RequestBody BooksDto booksDto){
        return new ResponseEntity<>(new BooksDto(service.update(booksDto)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }
}
