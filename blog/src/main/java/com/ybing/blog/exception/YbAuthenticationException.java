package com.ybing.blog.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by niko on 2019/5/30.
 */
public class YbAuthenticationException extends AuthenticationException {

    public YbAuthenticationException(String msg, Throwable t) {
        super(msg, t);
    }

    public YbAuthenticationException(String msg) {
        super(msg);
    }
}
