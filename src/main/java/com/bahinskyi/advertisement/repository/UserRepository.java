package com.bahinskyi.advertisement.repository;

import com.bahinskyi.advertisement.domain.User;
import org.springframework.stereotype.Repository;

/**
 * Created by quento on 29.05.17.
 */

public interface UserRepository extends AbstractRepository<User> {

    User findByPhone(String phone);
}
