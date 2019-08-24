package pl.projekt.biblioteka.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.projekt.biblioteka.infrastructure.entity.Book;
import pl.projekt.biblioteka.infrastructure.entity.User;
import pl.projekt.biblioteka.infrastructure.repositories.BookRepository;
import pl.projekt.biblioteka.infrastructure.dto.BookDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    @Autowired
    private final BookRepository bookRepository;


    public void createOrUpdate(BookDto dto) {
        Book book = Book.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .cathegory(dto.getCathegory())
                .build();
        bookRepository.save(book);
    }

    public void delete(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    public List<BookDto> findAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(Book::toDto)
                .collect(Collectors.toList());
    }


}
