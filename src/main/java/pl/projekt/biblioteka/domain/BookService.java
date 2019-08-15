package pl.projekt.biblioteka.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import pl.projekt.biblioteka.infrastructure.Entity.Book;
import pl.projekt.biblioteka.infrastructure.Repositories.BookRepository;
import pl.projekt.biblioteka.infrastructure.dto.BookDto;

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

}
