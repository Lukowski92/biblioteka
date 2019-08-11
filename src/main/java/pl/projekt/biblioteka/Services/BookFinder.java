package pl.projekt.biblioteka.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.projekt.biblioteka.Entity.Book;
import pl.projekt.biblioteka.Repositories.BookRepository;
import pl.projekt.biblioteka.dto.BookDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookFinder {
    private final BookRepository bookRepository;

    public List<BookDto> findByCathegory(String cathegory){
        return bookRepository.findByCathegory(cathegory)
                .stream()
                .map(Book::toDto)
                .collect(Collectors.toList());
    }

}
