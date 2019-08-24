package pl.projekt.biblioteka.infrastructure.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.projekt.biblioteka.infrastructure.Entity.Book;
import pl.projekt.biblioteka.infrastructure.Entity.User;


import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByName(String name);
    List<User> findBySurname(String surname);

}
