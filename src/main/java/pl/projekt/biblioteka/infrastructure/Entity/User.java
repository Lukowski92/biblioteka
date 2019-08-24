package pl.projekt.biblioteka.infrastructure.Entity;

import lombok.*;
import pl.projekt.biblioteka.infrastructure.dto.BookDto;
import pl.projekt.biblioteka.infrastructure.dto.UserDto;

import javax.persistence.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Uzytkownik")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Imie")
    private String name;

    @Column(name = "Nazwisko")
    private String surname;

    public UserDto toDto() {
        return UserDto.builder
                .id(id)
                .name(name)
                .surname(surname)
                .build();
    }
}
