package pl.projekt.biblioteka.infrastructure.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserDto {
  private Long id;
  private String firstName;
  private String lastName;
}
