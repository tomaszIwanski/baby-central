package com.archangel_design.babycentral.entity.dto;

import com.archangel_design.babycentral.entity.SessionEntity;
import com.archangel_design.babycentral.entity.UserEntity;

public class UserDto {

    private String email;

    private String uuid;

    private SessionEntity session;

    public String getEmail() {
        return email;
    }

    public UserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public UserDto setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public SessionEntity getSession() {
        return session;
    }

    public UserDto setSession(SessionEntity session) {
        this.session = session;
        return this;
    }

    public static UserDto build(UserEntity userEntity) {
        UserDto dto = new UserDto();
        dto.setEmail(userEntity.getEmail())
                .setUuid(userEntity.getUuid());
        return dto;
    }
}
