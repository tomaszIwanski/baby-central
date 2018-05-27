/*
 * Baby Central
 * Copyright (c) 2018.
 * Rafal Martinez-Marjanski
 */

package com.archangel_design.babycentral.service;

import com.archangel_design.babycentral.entity.OrganizationEntity;
import com.archangel_design.babycentral.entity.UserEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OneSignalService extends CommService {

    @Value("${onesignal-app-id}")
    private String appId;

    public void sendNotification(UserEntity userEntity) {}

    public void sendNotification(OrganizationEntity organizationEntity) {}


}
