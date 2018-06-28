package com.archangel_design.babycentral.service.onesignal;

import com.archangel_design.babycentral.configuration.OneSignalConfiguration;
import com.archangel_design.babycentral.entity.ScheduleEntryEntity;
import com.archangel_design.babycentral.enums.Language;
import com.archangel_design.babycentral.service.onesignal.notificationfilters.NotificatonFilter;
import com.archangel_design.babycentral.service.onesignal.notificationfilters.TagFilter;

import java.util.Arrays;
import java.util.List;

public class OneSignalNotificationFactory {

    private final OneSignalConfiguration oneSignalConfiguration;

    public OneSignalNotificationFactory(final OneSignalConfiguration oneSignalConfiguration) {
        this.oneSignalConfiguration = oneSignalConfiguration;
    }

    public OneSignalPushNotification createPushNotification(final ScheduleEntryEntity scheduleEntry) {
        OneSignalPushNotification notification = new OneSignalPushNotification(
                oneSignalConfiguration.getAppId(),
                scheduleEntry.getOwner().getUser().getOrganization().getUuid()
        );

        // TODO logika treści wiadomości
        notification.addMessage(Language.ENGLISH, "tmp");

        return notification;
    }
}
