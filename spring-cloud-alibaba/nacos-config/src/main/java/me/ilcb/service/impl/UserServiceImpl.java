package me.ilcb.service.impl;

import me.ilcb.dao.UserRepository;
import me.ilcb.model.User;
import me.ilcb.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RedisTemplate redisTemplate;

    @Value("${app.user.cache}")
    private boolean cache;

    @Override
    public User findById(Long id) {
        LOGGER.info("cache: {}", cache);

        if (cache) {
            Object obj = redisTemplate.opsForValue().get(key(id));
            if (Optional.ofNullable(obj).isPresent()) {
                return (User)obj;
            }
        }
        return userRepository.findById(id).orElseGet(null);
    }

    private String key(Long id) {
        return String.format("nacos-spring-cloud-config-multi-data-ids-example:user:%d", id);
    }
}
