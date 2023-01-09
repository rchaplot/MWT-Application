package com.smartbee.jobdemo.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * @author prinswu
 * @version v1.0
 * @since v1.0 2020/5/18
 */
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.ofNullable("prinswu");
    }

}
