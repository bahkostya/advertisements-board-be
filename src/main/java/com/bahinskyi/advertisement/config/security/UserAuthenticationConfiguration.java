package com.bahinskyi.advertisement.config.security;

import com.bahinskyi.advertisement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by quento on 30.05.17.
 */
@Configuration
public class UserAuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {

    private final UserRepository userRepository;

    @Autowired
    public UserAuthenticationConfiguration(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    UserDetailsService userDetailsService() {
        return phone -> {
            com.bahinskyi.advertisement.domain.User user = userRepository.findByPhone(phone);
            if (user != null)
                return new User(user.getPhone(), user.getPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
            else
                throw new UsernameNotFoundException("could not find the user '" + phone + "'");

        };
    }


}
