package com.example.library.service.ServiceImpl;

import com.example.library.dto.LibraryDto;
import com.example.library.entity.Books;
import com.example.library.entity.Library;
import com.example.library.exception.ResourceAlreadyExistsException;
import com.example.library.exception.ResourceNotFoundException;
import com.example.library.repository.LibraryRepository;
import com.example.library.service.LibraryService;

import java.util.List;

public class LibraryServiceImpl implements LibraryService {

    LibraryRepository libraryRepository;

    @Override
    public Library getLibraryById(Long id) {
        return libraryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Библиотека с данным id: " + id + " не найдена!"));

    }

    @Override
    public List<Library> getLibrary() {
        return libraryRepository.findAll();
    }

    @Override
    public Library add(LibraryDto libraryDto) {
        if (libraryRepository.existsById(libraryDto.getId())) {
            throw new ResourceAlreadyExistsException("Библиотека с таким id уже существует");
        }
        Library library = new Library();
        library.setId(libraryDto.getId());

        initLibraryFromDto(library, libraryDto);
        libraryRepository.save(library);
        return library;
    }


    @Override
    public Library update(LibraryDto libraryDto) {
        Library library = libraryRepository.findById(libraryDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Библиотека с id = " + libraryDto.getId() + " не существует"));
        initLibraryFromDto(library, libraryDto);
        libraryRepository.save(library);
        return library;
    }

    @Override
    public void deleteById(Long id) {
        libraryRepository.deleteById(id);
    }

    private void initLibraryFromDto(Library library, LibraryDto libraryDto) {
        library.setId(libraryDto.getId());
        library.setName(libraryDto.getName());

    }

}
