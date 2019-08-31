package pl.projekt.biblioteka.infrastructure.entity;

import lombok.*;
import pl.projekt.biblioteka.infrastructure.dto.BookDto;
import pl.projekt.biblioteka.infrastructure.dto.UserDto;

import javax.persistence.*;
import java.util.Set;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "Imię")
  private String firstName;

  @Column(name = "Nazwisko")
  private String lastName;

  @Column(name = "Login")
  private String login;

  private String password;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "users_roles",
          joinColumns = {@JoinColumn(name = "user_id")},
          inverseJoinColumns = {@JoinColumn(name = "role_id")})
  private Set<UserRole> roles;

  public UserDto toDto() {
    return UserDto.builder()
        .id(id)
        .firstName(firstName)
        .lastName(lastName)
        .login(login)
        .password(password)
        .build();
  }
}
