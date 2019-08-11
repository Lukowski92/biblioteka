package pl.projekt.biblioteka.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.projekt.biblioteka.Entity.Book;
import pl.projekt.biblioteka.Repositories.BookRepository;
import pl.projekt.biblioteka.dto.BookDto;

@Service
@RequiredArgsConstructor
public class BookService {
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
