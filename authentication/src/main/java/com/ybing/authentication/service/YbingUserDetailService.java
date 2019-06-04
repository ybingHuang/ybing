package com.ybing.authentication.service;

import com.ybing.authentication.entity.YbingRole;
import com.ybing.authentication.entity.YbingUser;
import com.ybing.authentication.mapper.YbingRoleMapper;
import com.ybing.authentication.mapper.YbingUserMapper;
import com.ybing.authentication.struct.YbingUserDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by niko on 2019/5/17.
 */
@Service
public class YbingUserDetailService implements UserDetailsService{

    //@Autowired
    private PasswordEncoder passwordEncoder;

    //@Autowired
    private YbingUserMapper ybingUserMapper;

    //@Autowired
    private YbingRoleMapper ybingRoleMapper;

    @Autowired
    public YbingUserDetailService(PasswordEncoder passwordEncoder, YbingUserMapper ybingUserMapper, YbingRoleMapper ybingRoleMapper) {
        this.ybingRoleMapper = ybingRoleMapper;
        this.passwordEncoder = passwordEncoder;
        this.ybingUserMapper = ybingUserMapper;
    }

    public YbingUserDetailDTO loadUser(String username, String password) {
        YbingUser userParam = new YbingUser();
        userParam.setName(username);
        YbingUser user = ybingUserMapper.selectOne(userParam);
        if(!passwordEncoder.matches(password, user.getPassword())) {
            return null;
        }
        List<YbingRole> roles = ybingRoleMapper.selectRoleByUserId(user.getId());
        return new YbingUserDetailDTO(user, roles);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        YbingUser userParam = new YbingUser();
        userParam.setName(username);
        YbingUser user = ybingUserMapper.selectOne(userParam);
        List<YbingRole> roles = ybingRoleMapper.selectRoleByUserId(user.getId());
        return new YbingUserDetailDTO(user, roles);
    }
}
