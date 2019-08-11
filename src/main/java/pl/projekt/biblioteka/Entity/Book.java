package pl.projekt.biblioteka.Entity;

import lombok.*;
import pl.projekt.biblioteka.dto.BookDto;

import javax.persistence.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Ksiazki")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Tytuł")
    private String title;

    @Column(name = "Kategoria")
    private String cathegory;

    public BookDto toDto() {
        return BookDto.builder()
                .id(id)
                .title(title)
                .cathegory(cathegory)
                .build();
    }
}
