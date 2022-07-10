package com.example.democourse.serviceImpl;

import com.example.democourse.Model.User;
import com.example.democourse.repositories.IUserRepository;
import com.example.democourse.service.UserService;
import com.example.democourse.utils.Utility;
import com.example.democourse.utils.dtos.UserDTO;
import com.example.democourse.utils.exceptions.BadRequestException;
import com.example.democourse.utils.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final IUserRepository userRepository;

    @Autowired
    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Page<User> all(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("User","id", id.toString())
        );
    }

    @Override
    public User create(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(Utility.encode(userDTO.getPassword()));
        user.setFullName(userDTO.getFullNames());
        user.setPhoneNumber(userDTO.getPhoneNumber());

        if (!isUnique(user))
            throw new BadRequestException("The provided email is already used in the app");

        return userRepository.save(user);
    }

    @Override
    public Boolean isUnique(User user) {
        Optional<User> uniqueUser = userRepository.findByEmailOrPhoneNumber(user.getEmail(), user.getPhoneNumber());
        return uniqueUser.isEmpty();
    }

    @Override
    public User getLoggedInUser() {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal()=="anonymousUser")
            throw new RuntimeException("you are not logged in, try to log in");

        String email;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails){
            email = ((UserDetails) principal).getUsername();
        }else{
            email = principal.toString();
        }
        return userRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("User","email",email)
        );

    }
}
