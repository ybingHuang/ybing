package com.ybing.blog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by niko on 2019/5/30.
 */
@Getter
@Setter
public class YbAuthLoginDTO {

    private String username;

    private String password;

    private String client_id;

    private String grant_type;

    private String scope;

    private String client_secret;


    @Override
    public String toString() {
        return "username=" + username + "password=" + password + "client_id=" + client_id +
                "grant_type=" + grant_type + "scope=" + scope + "client_secret=" + client_secret;
    }
}
