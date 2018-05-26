package com.archangel_design.babycentral.service;

import com.archangel_design.babycentral.entity.SessionEntity;
import com.archangel_design.babycentral.entity.UserEntity;
import com.archangel_design.babycentral.exception.InvalidArgumentException;
import com.archangel_design.babycentral.exception.SessionExpiredException;
import com.archangel_design.babycentral.exception.UnauthorizedException;
import com.archangel_design.babycentral.repository.SessionRepository;
import com.mysql.jdbc.StringUtils;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class SessionService {

    @Autowired
    HttpServletRequest request;

    @Autowired
    SessionRepository repository;

    /**
     * Returns valid session based on given token
     * or entire value of "Authorization" header.
     * Returns null if no valid session found.
     * Session is being extended by another 7 days.
     */
    public SessionEntity getSession(String token) throws SessionExpiredException, UnauthorizedException {
        if (StringUtils.isNullOrEmpty(token))
            throw new UnauthorizedException("No session token in request.");

        SessionEntity session = repository.fetch(unwrapToken(token));

        if (session == null)
            return null;

        if (new Date().after(session.getExpiration())) {
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
     * Returns session for current request
     * or null if no session found
     *
     * @return SessionEntity|null
     */
    public SessionEntity getCurrentSession() {
        String token = unwrapToken(request.getHeader("Authorization"));

        if (token == null)
            return null;

        return getSession(token);
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

    /**
     * Returns token from given header line
     *
     * @param headerLine input from request header
     * @return session token
     */
    private String unwrapToken(String headerLine) {
        if (StringUtils.isNullOrEmpty(headerLine))
            return null;

        if (headerLine.contains("Token "))
            return headerLine.replace("Token ", "");

        return headerLine;
    }

}
