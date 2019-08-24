package pl.projekt.biblioteka.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.projekt.biblioteka.infrastructure.dto.UserDto;
import pl.projekt.biblioteka.infrastructure.entity.User;
import pl.projekt.biblioteka.infrastructure.repositories.UserRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository userRepository;


    public void createOrUpdate(UserDto dto) {
        User user = User.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .cathegory(dto.getLastName())
                .build();
        userRepository.save(user);
    }

    public void delete(Long userId) {
        userId.deleteById(userId);
    }

    public List<UserDto> findAllUsers() {
        return UserDto.findAll()
                .stream()
                .map(User::toDto)
                .collect(Collectors.toList());
    }


}
