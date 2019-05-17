package com.ybing.authentication.service;

import com.ybing.authentication.entity.YbingRole;
import com.ybing.authentication.entity.YbingUser;
import com.ybing.authentication.repositories.YbingRoleRepository;
import com.ybing.authentication.repositories.YbingUserRepository;
import com.ybing.authentication.struct.YbingUserDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by niko on 2019/5/17.
 */
@Service
public class YbingUserDetailService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private YbingUserRepository ybingUserRepository;

    @Autowired
    private YbingRoleRepository ybingRoleRepository;

    public YbingUserDetailDTO loadUser(String username, String password) {
        YbingUser user = ybingUserRepository.findByName(username);
        if(!passwordEncoder.matches(user.getPassword(), password)) {
            return null;
        }
        List<YbingRole> roles = ybingRoleRepository.findRoles(user.getId());
        return new YbingUserDetailDTO(user, roles);
    }

}
