package com.archangel_design.babycentral.service.onesignal;

import com.archangel_design.babycentral.configuration.OneSignalConfiguration;
import com.archangel_design.babycentral.entity.ScheduleEntryEntity;
import com.archangel_design.babycentral.service.onesignal.notificationfilters.NotificatonFilter;
import com.archangel_design.babycentral.service.onesignal.notificationfilters.TagFilter;

import java.util.Arrays;
import java.util.List;

public class OneSignalNotificationRequestFactory {

    private final OneSignalConfiguration oneSignalConfiguration;

    public OneSignalNotificationRequestFactory(final OneSignalConfiguration oneSignalConfiguration) {
        this.oneSignalConfiguration = oneSignalConfiguration;
    }

    public OneSignalNotificationRequest createNotificationRequestForOrganization(ScheduleEntryEntity scheduleEntry) {
        List<NotificatonFilter> filters = Arrays.asList(
                new TagFilter("organizationId",
                scheduleEntry.getOwner().getUser().getOrganization().getId().toString())
        );

        return new OneSignalNotificationRequest(
                oneSignalConfiguration.getAppId(),
                scheduleEntry.getTitle(),
                scheduleEntry.getPriority(),
                scheduleEntry.getRepeatType(),
                scheduleEntry.getStart(),
                scheduleEntry.getStop(),
                filters
        );
    }
}
