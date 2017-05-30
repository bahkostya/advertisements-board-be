package com.bahinskyi.advertisement.util;

import com.bahinskyi.advertisement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

/**
 * Created by quento on 30.05.17.
 */

@Service
public class UserKeeper {

    private final UserRepository userRepository;

    @Autowired
    public UserKeeper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public com.bahinskyi.advertisement.domain.User loggedUser() {
        return userRepository.findByPhone(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
    }


}
