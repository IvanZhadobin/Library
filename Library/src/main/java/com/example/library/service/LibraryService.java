package com.example.library.service;

import com.example.library.dto.LibraryDto;
import com.example.library.entity.Library;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LibraryService {
    Library getLibraryById(Long id);

    List<Library> getLibrary();

    Library add(LibraryDto libraryDto);

    Library update(LibraryDto library);

    void deleteById(Long id);
}
