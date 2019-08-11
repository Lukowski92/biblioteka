package pl.projekt.biblioteka.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.projekt.biblioteka.Entity.Book;
import pl.projekt.biblioteka.Repositories.BookRepository;


import java.util.List;

public class BookControler {
    private BookRepository bookRepository;

    public BookControler(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepository.findAllBooks();
    }
    @GetMapping("/books")
    public void addBook(@RequestBody Book book){
        bookRepository.addBook(book);
    }

}
