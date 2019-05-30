package com.ybing.blog.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by niko on 2019/5/30.
 */
@Setter
@Getter
@ToString
public class YbLoginDTO {

    private String username;

    private String password;
}
