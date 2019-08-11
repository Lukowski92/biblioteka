package pl.projekt.biblioteka.Repositories;

import org.springframework.stereotype.Repository;
import pl.projekt.biblioteka.Entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class BookRepository {

  @PersistenceContext private EntityManager entityManager;

  @Transactional
  public List<Book> findAllBooks() {
    List<Book> books = entityManager.createQuery("from Książki", Book.class).getResultList();
    return books;
  }

  public void addBook(Book book) {
    entityManager.persist(book);
  }
}
