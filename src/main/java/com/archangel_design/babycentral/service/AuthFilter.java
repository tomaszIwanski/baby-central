package com.archangel_design.babycentral.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AuthFilter extends UsernamePasswordAuthenticationFilter {

    private SessionService sessionServiceService;

    public AuthFilter(SessionService sessionServiceService) {
        this.sessionServiceService = sessionServiceService;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        boolean authenticated = SecurityContextHolder.getContext().getAuthentication() != null;
        HttpServletRequest request = (HttpServletRequest) req;
        if (!authenticated) {
            if (!currentRequestIsAsyncDispatcher(request)) {
                Authenticator authentication = new Authenticator(null, null);
                authentication.setDetails((new WebAuthenticationDetailsSource()).buildDetails(request));
                authentication.setModel(sessionServiceService);
                authentication.setRequest(request);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        chain.doFilter(req, res);
    }

    private boolean currentRequestIsAsyncDispatcher(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getDispatcherType().equals(DispatcherType.ASYNC);
    }
}
