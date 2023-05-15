package com.paf.mealdrop.controller;

import com.paf.mealdrop.model.User;
import com.paf.mealdrop.security.CurrentUser;
import com.paf.mealdrop.security.UserPrincipal;
import com.paf.mealdrop.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userService.getByUserId(userPrincipal.getId());
    }

    @GetMapping("/user/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/user/delete/{id}")
    public Map<String, String> deleteUserById(@PathVariable String id) {
        return userService.deleteUserById(id);
    }

    @PutMapping("/user/edit/{id}")
    public User editUserById(@PathVariable String id, @RequestBody User user) {
        return userService.editUserById(id, user);
    }

}
