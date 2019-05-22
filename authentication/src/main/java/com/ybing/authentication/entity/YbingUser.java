package com.ybing.authentication.entity;

import com.ybing.authentication.enums.YbingUserStatusEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by niko on 2019/5/15.
 */
@Getter
@Setter
@ToString
@Entity
@Table(name="user")
public class YbingUser extends YbingBaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name = "status")
    private Integer status;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_no")
    private String phoneNo;

}
