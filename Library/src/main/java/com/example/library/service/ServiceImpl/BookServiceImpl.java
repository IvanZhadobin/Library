package com.example.library.service.ServiceImpl;

import com.example.library.dto.BooksDto;
import com.example.library.entity.Books;
import com.example.library.exception.ResourceAlreadyExistsException;
import com.example.library.exception.ResourceNotFoundException;
import com.example.library.repository.BooksRepository;
import com.example.library.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    BooksRepository booksRepository;

    @Override
    public Books getBookById(Long id) {

        return booksRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Книга с данным id: " + id + " не найдена!"));
    }

    @Override
    public List<Books> getBooks() {
        return booksRepository.findAll();
    }

    @Override
    public Books add(BooksDto booksDto) {
        if (booksRepository.existsById(booksDto.getId())) {
            throw new ResourceAlreadyExistsException("Книга с таким id уже существует");
        }
        Books books = new Books();
        books.setId(booksDto.getId());

        initBooksFromDto(books, booksDto);
        booksRepository.save(books);
        return books;
    }

    @Override
    public Books update(BooksDto booksDto) {
        Books books = booksRepository.findById(booksDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Книга с id = " + booksDto.getId() + " не существует"));
        initBooksFromDto(books, booksDto);
        booksRepository.save(books);
        return books;
    }

    @Override
    public void deleteById(Long id) {
        booksRepository.deleteById(id);
    }

    private void initBooksFromDto(Books books, BooksDto booksDto) {
        books.setId(booksDto.getId());
        books.setAuthor(booksDto.getAuthor());
        books.setTitle(booksDto.getTitle());
        books.setLibrary_id(booksDto.getLibrary_id());
        books.setYear_published(booksDto.getYear_published());
    }
}
