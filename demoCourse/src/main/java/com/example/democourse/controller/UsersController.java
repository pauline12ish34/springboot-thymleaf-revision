package com.example.democourse.controller;

import com.example.democourse.service.UserService;
import com.example.democourse.utils.Constants;
import com.example.democourse.utils.Formatter;
import com.example.democourse.utils.Utility;
import com.example.democourse.utils.payload.ApiResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse> all(@RequestParam(value = "page", defaultValue = Constants.DEFAULT_PAGE_NUMBER) int page, @RequestParam(value = "limit", defaultValue = Constants.DEFAULT_PAGE_SIZE) int limit){
        Pageable pageable = Utility.from(page, limit);

        return Formatter.ok(userService.all(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> byId(@PathVariable Long id){

        return Formatter.ok(userService.findById(id));
    }
}
