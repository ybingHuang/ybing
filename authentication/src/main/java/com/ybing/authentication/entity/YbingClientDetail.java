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
@Table(name = "client_detail")
public class YbingClientDetail extends YbingBaseEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "status")
    private int status;

    @Column(name = "client_secret")
    private String clientSecret;

    @Column(name = "scope")
    private String scope;

    @Column(name = "authorized_grant_types")
    private String authorizedGrantType;

    @Column(name = "redirect_uri")
    private String redirectUri;

    @Column(name = "access_token_validity")
    private Boolean accessTokenValidity;

    @Column(name = "refresh_token_validity")
    private Boolean refreshTokenValidity;

}
