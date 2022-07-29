package com.sloboda.hibernateprobe.regularapproach;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public void update(Long idFromThePathVariable, UserRequest userRequest) {
        User user = userRepository.findById(idFromThePathVariable).orElseThrow();

        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
    }
/*

    private UserResponse toResponse(User user) {
        return UserResponse.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }
*/
}
