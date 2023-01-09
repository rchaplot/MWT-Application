package com.smartbee.jobdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class DemoUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("========= loadUserByUsername:{}", username);
        if ("super_user".equals(username)) {
            return User.builder().username(username).password(passwordEncoder.encode("super_user")).roles(
                    "SUPER_USER").build();
        } else if ("manager".equals(username)) {
            return User.builder().username(username).password(passwordEncoder.encode("manager")).roles(
                    "MANAGER").build();
        } else if ("operator".equals(username)) {
            return User.builder().username(username).password(passwordEncoder.encode("operator")).roles(
                    "OPERATOR").build();
        }
        log.info("========= loadUserByUsername: not found");
        throw new UsernameNotFoundException(String.format("username[%s] not found", username));
    }
}
