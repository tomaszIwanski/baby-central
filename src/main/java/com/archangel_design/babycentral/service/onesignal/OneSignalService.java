/*
 * Baby Central
 * Copyright (c) 2018.
 * Rafal Martinez-Marjanski
 */

package com.archangel_design.babycentral.service.onesignal;

import com.archangel_design.babycentral.entity.OrganizationEntity;
import com.archangel_design.babycentral.entity.UserEntity;
import com.archangel_design.babycentral.service.CommService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OneSignalService extends CommService {

    public void sendNotification(UserEntity userEntity) {}

    public void sendNotification(OrganizationEntity organizationEntity) {}

}
