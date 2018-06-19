/*
 * Baby Central
 * Copyright (c) 2018.
 * Rafal Martinez-Marjanski
 */

package com.archangel_design.babycentral.service;

import com.archangel_design.babycentral.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public Boolean sendInvitationEmail(String recipient, UserEntity sender) {
        return true;
    }
}
