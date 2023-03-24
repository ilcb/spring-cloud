package me.ilcb.hystrix.consumer.controller;

import me.ilcb.hystrix.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import me.ilcb.hystrix.consumer.model.*;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@EnableCircuitBreaker
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("testRequestMerge")
    public void testRequerstMerge() throws InterruptedException, ExecutionException {
        Future<User> f1 = userService.findUser(1L);
        Future<User> f2 = userService.findUser(2L);
        Future<User> f3 = userService.findUser(3L);
        f1.get();
        f2.get();
        f3.get();
        Thread.sleep(200);
        Future<User> f4 = userService.findUser(4L);
        f4.get();
    }

    @GetMapping("testCache")
    public void testCache() {
        userService.getUser(1L);
        userService.getUser(1L);
        userService.getUser(1L);
    }

    @GetMapping("user/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("user")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("user/add")
    public String addUser() {
        return userService.addUser();
    }

    @GetMapping("user/update")
    public void updateUser() {
        userService.updateUser(new User(1L, "CCC"));
    }

    @GetMapping("user/delete/{id:\\d+}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
