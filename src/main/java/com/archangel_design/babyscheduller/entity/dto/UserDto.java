package com.archangel_design.babyscheduller.entity.dto;

import com.archangel_design.babyscheduller.entity.UserEntity;

public class UserDto {
    public static UserDto build(UserEntity userEntity) {
        return new UserDto();
    }
}
