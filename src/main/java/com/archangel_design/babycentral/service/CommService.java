/*
 * Baby Central
 * Copyright (c) 2018.
 * Rafal Martinez-Marjanski
 */

package com.archangel_design.babycentral.service;

import com.archangel_design.babycentral.entity.OrganizationEntity;
import com.archangel_design.babycentral.entity.UserEntity;

public abstract class CommService {

    public abstract void sendNotification(UserEntity userEntity);

    public abstract void sendNotification(OrganizationEntity organizationEntity);
}
