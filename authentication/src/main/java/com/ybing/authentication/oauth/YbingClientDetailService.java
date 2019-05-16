package com.ybing.authentication.oauth;

import com.ybing.authentication.entity.YbingClientDetail;
import com.ybing.authentication.repositories.YbingClientDetailRepository;
import com.ybing.authentication.struct.YbingClientDetailDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * Created by niko on 2019/5/16.
 */
@Service
@Slf4j
public class YbingClientDetailService implements ClientDetailsService {

    @Autowired
    private YbingClientDetailRepository ybingClientDetailRepository;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        if(StringUtils.isEmpty(clientId)) {
            return null;
        }

        YbingClientDetail clientDetail = ybingClientDetailRepository.findYbingClientDetailByCode(clientId);
        if(Objects.isNull(clientDetail)) {
            return null;
        }
        return new YbingClientDetailDTO(clientDetail);
    }
}
