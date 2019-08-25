package pl.projekt.biblioteka.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.projekt.biblioteka.infrastructure.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);
}
