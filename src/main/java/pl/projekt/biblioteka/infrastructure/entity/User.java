package pl.projekt.biblioteka.infrastructure.entity;

import lombok.*;
import pl.projekt.biblioteka.infrastructure.dto.BookDto;
import pl.projekt.biblioteka.infrastructure.dto.UserDto;

import javax.persistence.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Imię")
    private String firstName;

    @Column(name = "Nazwisko")
    private String lastName;

    public UserDto toDto() {
        return UserDto.builder()
                .id(id)
                .firstName(firstName)
                .lasName(lastName)
                .build();
    }
}
