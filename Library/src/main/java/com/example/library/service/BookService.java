package com.example.library.service;

import com.example.library.dto.BooksDto;
import com.example.library.entity.Books;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BookService {

    Books getBookById(Long id);

    List<Books> getBooks();

    Books add(BooksDto booksDto);

    Books update(BooksDto booksDto);

    void deleteById(Long id);
}
