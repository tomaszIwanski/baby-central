package com.archangel_design.babyscheduller.service;

import com.archangel_design.babyscheduller.entity.SessionEntity;
import com.archangel_design.babyscheduller.entity.UserEntity;
import com.archangel_design.babyscheduller.exception.SessionExpiredException;
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
     * Session is being extended by another 7 days.
     */
    public SessionEntity getSession(String token) throws SessionExpiredException {
        if (token.contains("Token "))
            token = token.replace("Token ", "");
        SessionEntity session = repository.fetch(token);
        if (session == null)
            return null;
        if (session.getExpiration().after(new Date())) {
            repository.remove(token);
            throw new SessionExpiredException();
        }

        session.setExpiration(getExpirationDate());
        return repository.save(session);
    }

    /**
     * Starts new session for 7 days from now.
     * Any other sessions assigned to deviceId
     * are removed.
     *
     * @param user UserEntity that starts session
     * @param deviceId string identifier of device
     * @return Newly created session
     */
    public SessionEntity startSession(UserEntity user, String deviceId) {
        repository.removeSessions(user.getId(), deviceId);
        SessionEntity session = new SessionEntity();
        session.setCreated(new Date())
                .setDeviceId(deviceId)
                .setUser(user)
                .setExpiration(getExpirationDate());
        return repository.save(session);
    }

    /**
     * Returns date 7 days in the future
     *
     * @return Date
     */
    private Date getExpirationDate() {
        Date d = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 7);
        return cal.getTime();
    }

}
