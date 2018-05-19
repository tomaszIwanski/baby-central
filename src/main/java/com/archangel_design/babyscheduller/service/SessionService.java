package com.archangel_design.babyscheduller.service;

import com.archangel_design.babyscheduller.entity.SessionEntity;
import com.archangel_design.babyscheduller.entity.UserEntity;
import com.archangel_design.babyscheduller.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class SessionService {

    @Autowired
    SessionRepository repository;

    /**
     * Returns valid session based on given token
     * or entire value of "Authorization" header.
     * Returns null if no valid session found.
     */
    public SessionEntity getSession(String token) {
        return null;
    }

    public SessionEntity startSession(UserEntity user, String deviceId) {
        repository.removeSessions(user.getId(), deviceId);
        SessionEntity session = new SessionEntity();
        session.setCreated(new Date())
                .setDeviceId(deviceId)
                .setUser(user)
                .setExpiration(getExpirationDate());
        return repository.save(session);
    }

    private Date getExpirationDate() {
        Date d = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 7);
        return cal.getTime();
    }

}
