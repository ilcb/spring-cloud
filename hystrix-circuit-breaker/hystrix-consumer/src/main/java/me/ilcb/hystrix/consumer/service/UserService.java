package me.ilcb.hystrix.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import me.ilcb.hystrix.consumer.model.User;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;

@Service("userService")
public class UserService {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getUserDefault", commandKey = "getUserById", groupKey = "userGroup",
            threadPoolKey = "getUserThread")
    public User getUser(@PathVariable Long id) {
        return restTemplate.getForObject("http://Server-Provider/user/{id}", User.class, id);
    }

    @HystrixCollapser(batchMethod = "findUserBatch", collapserProperties = {
            @HystrixProperty(name = "timerDelayInMilliseconds", value = "100")
    })
    public Future<User> findUser(Long id) {
        log.info("获取单个用户信息");
        // return new AsyncResult<User>() {
        //     @Override
        //     public User invoke() {
        //         return restTemplate.getForObject("http://Server-Provider/user/{id}", User.class, id);
        //     }
        // };
        return null;
    }

    @HystrixCommand
    public List<User> findUserBatch(List<Long> ids) {
        log.info("批量获取用户信息,ids: " + ids);
        User[] users = restTemplate.getForObject("http://Server-Provider/user/users?ids={1}", User[].class, StringUtils.join(ids, ","));
        return Arrays.asList(users);
    }

    public List<User> getUsers() {
        return this.restTemplate.getForObject("http://Server-Provider/user", List.class);
    }

    public String addUser() {
        User user = new User(1L, "AAA");
        HttpStatus status = this.restTemplate.postForEntity("http://Server-Provider/user", user, null).getStatusCode();
        if (status.is2xxSuccessful()) {
            return "新增用户成功";
        } else {
            return "新增用户失败";
        }
    }

    public void updateUser(User user) {
        this.restTemplate.put("http://Server-Provider/user", user);
    }

    public void deleteUser(@PathVariable Long id) {
        this.restTemplate.delete("http://Server-Provider/user/{1}", id);
    }

    public User getUserDefault(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setName("defaultUser");
        return user;
    }
}
