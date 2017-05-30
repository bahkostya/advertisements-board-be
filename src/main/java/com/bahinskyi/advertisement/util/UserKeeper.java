package com.bahinskyi.advertisement.util;

import com.bahinskyi.advertisement.domain.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Created by quento on 30.05.17.
 */

@Service
public class UserKeeper {

    public User loggedUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }


}
