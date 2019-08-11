package pl.projekt.biblioteka.dto;


import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BookDto {
    private Long id;
    private String title;
    private String cathegory;


}
