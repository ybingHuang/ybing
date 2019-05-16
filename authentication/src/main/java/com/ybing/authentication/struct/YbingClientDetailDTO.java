package com.ybing.authentication.struct;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ybing.authentication.entity.YbingClientDetail;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Created by niko on 2019/5/16.
 */
@Setter
@ToString
public class YbingClientDetailDTO implements ClientDetails {

    private String clientId;

    private Set<String> resourceIds;

    private String clientSecret;

    private Set<String> scope;

    private Set<String> authorizedGrantTypes;

    private Set<String> registeredRedirectUri;

    private  Collection<GrantedAuthority> authorities;

    private Integer accessTokenValiditySeconds;

    private Integer refreshTokenValiditySeconds;

    private Map<String, Object> additionalInformation;

    public YbingClientDetailDTO() {

    }

    public YbingClientDetailDTO(YbingClientDetail ybingClientDetail) {
        String authorities = ybingClientDetail.getAuthorities();
        String additionalInfo = ybingClientDetail.getAdditionalInformation();
        String scope = ybingClientDetail.getScope();
        String grantType = ybingClientDetail.getAuthorizedGrantType();
        String redirectUri = ybingClientDetail.getRegisteredRedirectUri();
        this.clientId = ybingClientDetail.getCode();
        this.clientSecret = ybingClientDetail.getClientSecret();
        this.scope = StringUtils.isEmpty(scope) ? null : new HashSet(Arrays.asList(scope.split(",")));
        this.authorizedGrantTypes = StringUtils.isEmpty(grantType) ? null : new HashSet(Arrays.asList(grantType.split(",")));
        this.registeredRedirectUri = StringUtils.isEmpty(redirectUri) ? null : new HashSet(Arrays.asList(redirectUri.split(",")));
        this.authorities = StringUtils.isEmpty(authorities) ? null : new HashSet(Arrays.asList(authorities.split(",")));
        this.accessTokenValiditySeconds = ybingClientDetail.getAccessTokenValiditySeconds();
        this.refreshTokenValiditySeconds = ybingClientDetail.getRefreshTokenValiditySeconds();
        this.additionalInformation = StringUtils.isEmpty(additionalInfo) ? null  : (Map)JSON.parse(additionalInfo);
    }

    @Override
    public String getClientId() {
        return this.clientId;
    }

    @Override
    public Set<String> getResourceIds() {
        return this.resourceIds;
    }

    @Override
    public boolean isSecretRequired() {
        return !StringUtils.isEmpty(this.clientSecret);
    }

    @Override
    public String getClientSecret() {
        return this.clientSecret;
    }

    @Override
    public boolean isScoped() {
        return !this.scope.isEmpty();
    }

    @Override
    public Set<String> getScope() {
        return this.scope;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return this.authorizedGrantTypes;
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return this.registeredRedirectUri;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return this.accessTokenValiditySeconds;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return this.refreshTokenValiditySeconds;
    }

    @Override
    public boolean isAutoApprove(String scope) {
        return false;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return this.additionalInformation;
    }
}
