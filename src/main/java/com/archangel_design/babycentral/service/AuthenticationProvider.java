package com.archangel_design.babycentral.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class AuthenticationProvider implements org.springframework.security.authentication.AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        authentication.setAuthenticated(false);
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
