package com.archangel_design.babyscheduller.service;

import com.archangel_design.babyscheduller.entity.SessionEntity;
import com.archangel_design.babyscheduller.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class Session {

    /**
     * Returns valid session based on given token
     * or entire value of "Authorization" header.
     * Returns null if no valid session found.
     */
    public SessionEntity getSession(String token) {
        return null;
    }

    public SessionEntity startSession(UserEntity user, String httpSessionId) {
        return null;
    }

}
