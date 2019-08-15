package pl.projekt.biblioteka.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.projekt.biblioteka.infrastructure.Entity.Book;
import pl.projekt.biblioteka.infrastructure.Repositories.BookRepository;
import pl.projekt.biblioteka.infrastructure.dto.BookDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookFinder {
    @Autowired
    private final BookRepository bookRepository;

    public List<BookDto> findByCathegory(String cathegory){
        return bookRepository.findByCathegory(cathegory)
                .stream()
                .map(Book::toDto)
                .collect(Collectors.toList());
    }

}
