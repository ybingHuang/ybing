package com.ybing.authentication.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by niko on 2019/5/15.
 */
@Getter
@Setter
@ToString
@Entity
@Table(name="role")
public class YbingRole extends YbingBaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

}
