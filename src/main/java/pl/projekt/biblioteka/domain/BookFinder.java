package pl.projekt.biblioteka.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.projekt.biblioteka.infrastructure.entity.Book;
import pl.projekt.biblioteka.infrastructure.repositories.BookRepository;
import pl.projekt.biblioteka.infrastructure.dto.BookDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookFinder {
    @Autowired
    private final BookRepository bookRepository;

    public List<BookDto> findByCathegory(String cathegory) {
        return bookRepository.findByCathegory(cathegory)
                .stream()
                .map(Book::toDto)
                .collect(Collectors.toList());
    }

    public BookDto findById(Long id) {
        return bookRepository.findById(id)
                .map(Book::toDto)
                .orElseThrow(() -> new IllegalStateException("Nie istnieje tak ksiazk"));
    }

}
