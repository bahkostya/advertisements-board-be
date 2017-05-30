package com.bahinskyi.advertisement.api.rest;

import com.bahinskyi.advertisement.api.dto.UserVO;
import com.bahinskyi.advertisement.util.UserKeeper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by quento on 30.05.17.
 */

@Controller("user")
public class UserController {

    @Autowired
    private UserKeeper userKeeper;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public UserVO getLoggedUser() {
        return modelMapper.map(userKeeper.loggedUser(), UserVO.class);
    }
}
