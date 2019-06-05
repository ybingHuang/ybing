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
import java.util.List;

/**
 * Created by niko on 2019/5/17.
 */
public class YbingUserDetailService implements UserDetailsService{

    @Autowired
    private YbingUserMapper ybingUserMapper;

    @Autowired
    private YbingRoleMapper ybingRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        YbingUser userParam = new YbingUser();
        userParam.setName(username);
        YbingUser user = ybingUserMapper.selectOne(userParam);
        List<YbingRole> roles = ybingRoleMapper.selectRoleByUserId(user.getId());
        return new YbingUserDetailDTO(user, roles);
    }
}
