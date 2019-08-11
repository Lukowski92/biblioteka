package pl.projekt.biblioteka.Repositories;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.projekt.biblioteka.Entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class BookRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Transactional
  public List<Book> findAllUsers() {
    List<Book> books = entityManager.createQuery("from User", Book.class).getResultList();
    return books;
  }

}
