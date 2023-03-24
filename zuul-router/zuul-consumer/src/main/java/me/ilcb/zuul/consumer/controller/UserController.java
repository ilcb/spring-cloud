package me.ilcb.zuul.consumer.controller;

import me.ilcb.zuul.consumer.model.User;
import me.ilcb.zuul.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("user/{id:\\d+}")
    public User getUser(@PathVariable Long id) {
        return userService.get(id);
    }

    @GetMapping("user")
    public List<User> getUsers() {
        return userService.get();
    }

    @GetMapping("user/add")
    public void addUser() {
        User user = new User(1L, "AAA");
         userService.add(user);
    }

    @GetMapping("user/update")
    public void updateUser() {
        User user = new User(1L, "BBB");
        userService.update(user);
    }

    @GetMapping("user/delete/{id:\\d+}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }
}