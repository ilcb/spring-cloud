package me.ilcb.service;

import me.ilcb.model.User;

public interface UserService {
    User findById(Long id);
}
