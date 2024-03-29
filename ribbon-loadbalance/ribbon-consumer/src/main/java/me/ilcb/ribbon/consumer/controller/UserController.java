package me.ilcb.ribbon.consumer.controller;

import me.ilcb.ribbon.consumer.model.User;
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
    private RestTemplate restTemplate;

    @GetMapping("user/{id:\\d+}")
    public User getUser(@PathVariable Long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        URI uri = UriComponentsBuilder.fromUriString("http://ribbon-provider/user/{id}")
                .build().expand(params).encode().toUri();
        return this.restTemplate.getForEntity(uri, User.class).getBody();
    }

    @GetMapping("user")
    public List<User> getUsers() {
        return this.restTemplate.getForObject("http://ribbon-provider/user", List.class);
    }

    @GetMapping("user/add")
    public String addUser() {
        User user = new User(1L, "AAA");
        HttpStatus status = this.restTemplate.postForEntity("http://ribbon-provider/user", user, null).getStatusCode();
        if (status.is2xxSuccessful()) {
            return "新增用户成功";
        } else {
            return "新增用户失败";
        }
    }

    @GetMapping("user/update")
    public void updateUser() {
        User user = new User(1L, "BBB");
        this.restTemplate.put("http://ribbon-provider/user", user);
    }

    @GetMapping("user/delete/{id:\\d+}")
    public void deleteUser(@PathVariable Long id) {
        this.restTemplate.delete("http://ribbon-provider/user/{1}", id);
    }
}