package com.ybing.authentication.oauth;

import com.ybing.authentication.entity.YbingClientDetail;
import com.ybing.authentication.mapper.YbingClientDetailMapper;
import com.ybing.authentication.struct.YbingClientDetailDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * Created by niko on 2019/5/16.
 */
@Slf4j
public class YbingClientDetailService implements ClientDetailsService {

    @Autowired
    private YbingClientDetailMapper ybingClientDetailMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        if(StringUtils.isEmpty(clientId)) {
            return null;
        }

        YbingClientDetail clientParam = new YbingClientDetail();
        clientParam.setCode(clientId);
        YbingClientDetail clientDetail = ybingClientDetailMapper.selectOne(clientParam);
        if(Objects.isNull(clientDetail)) {
            return null;
        }
        return new YbingClientDetailDTO(clientDetail);
    }
}
