package pl.projekt.biblioteka.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.projekt.biblioteka.infrastructure.dto.UserDto;
import pl.projekt.biblioteka.infrastructure.entity.User;
import pl.projekt.biblioteka.infrastructure.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserFinder {
  @Autowired private final UserRepository userRepository;

  public List<UserDto> findByfirstName(String firstName) {
    return userRepository.findByFirstName(firstName).stream()
        .map(User::toDto)
        .collect(Collectors.toList());
  }

  public List<UserDto> findByLastName(String lastName) {
    return userRepository.findByLastName(lastName).stream()
        .map(User::toDto)
        .collect(Collectors.toList());
  }

  public UserDto findById(Long id) {
    return userRepository
        .findById(id)
        .map(User::toDto)
        .orElseThrow(() -> new IllegalStateException("Nie istnieje taki użytkownik"));
  }
}
