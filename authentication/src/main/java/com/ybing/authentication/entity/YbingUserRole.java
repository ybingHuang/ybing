package com.ybing.authentication.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * Created by niko on 2019/5/15.
 */
@Getter
@Setter
@ToString
@Table(name="user_role")
public class YbingUserRole extends YbingBaseEntity {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "role_id")
    private Long roleId;

}
