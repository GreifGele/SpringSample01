package com.example.demo.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationListenerImpl implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {
    private static final Logger LOG = LoggerFactory.getLogger(ApplicationListenerImpl.class);

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
        Object userName = event.getAuthentication().getPrincipal();
        Object credentials = event.getAuthentication().getCredentials();
        LOG.info("Failed login using USERNAME [" + userName + "]");
        LOG.info("Failed login using PASSWORD [" + credentials + "]");
    }
}