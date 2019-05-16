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
@Table(name = "client_detail")
public class YbingClientDetail extends YbingBaseEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "status")
    private int status;

    @Column(name = "client_secret")
    private String clientSecret;

    @Column(name = "resource_ids")
    private String resourceIds;

    @Column(name = "scope")
    private String scope;

    @Column(name = "authorized_grant_types")
    private String authorizedGrantType;

    @Column(name = "registered_redirect_uri")
    private String registeredRedirectUri;

    @Column(name = "authorities")
    private String authorities;

    @Column(name = "access_token_validity_seconds")
    private Integer accessTokenValiditySeconds;

    @Column(name = "refresh_token_validity_seconds")
    private Integer refreshTokenValiditySeconds;

    @Column(name = "additional_information")
    private String additionalInformation;


}
