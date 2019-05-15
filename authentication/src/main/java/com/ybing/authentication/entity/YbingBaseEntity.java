package com.ybing.authentication.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by niko on 2019/5/15.
 */
@Setter
@Getter
@ToString
@MappedSuperclass
public class YbingBaseEntity implements Serializable {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="create_time")
    private Timestamp createTime;

    @Column(name="update_time")
    private Timestamp updateTime;

    @Column(name="creator")
    private String creator;

    @Column(name="update_by")
    private String updateBy;
}
