package pl.projekt.biblioteka.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.projekt.biblioteka.infrastructure.Type.Cathegory;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CathegoryDto {
    private Cathegory id;
    private String label;
}
