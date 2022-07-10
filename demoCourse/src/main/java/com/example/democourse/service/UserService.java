package com.example.democourse.service;

import com.example.democourse.Model.User;
import com.example.democourse.utils.dtos.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<User> all(Pageable pageable);
    User findById(Long id);
    User create(UserDTO userDTO);
    Boolean isUnique(User user);
    User getLoggedInUser();
}
