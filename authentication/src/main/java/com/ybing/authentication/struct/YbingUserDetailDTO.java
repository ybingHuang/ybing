package com.ybing.authentication.struct;

import com.ybing.authentication.entity.YbingRole;
import com.ybing.authentication.entity.YbingUser;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by niko on 2019/5/16.
 */
@Setter
@Getter
@ToString
public class YbingUserDetailDTO implements UserDetails {

    private Long id;

    private String name;

    private String email;

    private String phoneNo;

    private String firstName;

    private String lastName;

    private Collection<? extends GrantedAuthority> authorities;

    public YbingUserDetailDTO(YbingUser user, List<YbingRole> roles) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.phoneNo = user.getPhoneNo();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        if(roles != null && !roles.isEmpty()) {
            authorities = roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
