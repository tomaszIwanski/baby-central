package com.archangel_design.babycentral.processor;

import com.archangel_design.babycentral.configuration.OneSignalConfiguration;
import com.archangel_design.babycentral.entity.ScheduleEntryEntity;
import com.archangel_design.babycentral.enums.ScheduleEntryPriority;
import com.archangel_design.babycentral.service.onesignal.OneSignalNotificationFactory;
import com.archangel_design.babycentral.service.onesignal.OneSignalPushNotification;
import com.archangel_design.babycentral.service.onesignal.OneSignalService;
import com.archangel_design.babycentral.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleEntryProcessor {

    private final ScheduleService scheduleService;

    private final OneSignalService oneSignalService;
    private final OneSignalNotificationFactory oneSignalNotificationFactory;

    @Autowired
    public ScheduleEntryProcessor(
            final ScheduleService scheduleService,
            final OneSignalService oneSignalService,
            final OneSignalConfiguration oneSignalConfiguration
    ){
        this.scheduleService = scheduleService;
        this.oneSignalService = oneSignalService;
        this.oneSignalNotificationFactory =
                new OneSignalNotificationFactory(oneSignalConfiguration);
    }

    public void sendNotificationsForScheduleEntries() {
        List<ScheduleEntryEntity> scheduleEntries =
                scheduleService.getEventsForNotificationSending();

        scheduleEntries.forEach(this::sendNotificationForScheduleEntry);
    }

    public void sendNotificationForScheduleEntry(
            final ScheduleEntryEntity scheduleEntry
    ) {
        switch (scheduleEntry.getPriority()) {
            case HIGH:
                sendSilentPushNotificationForScheduleEntry(scheduleEntry);
                return;
            case MEDIUM:
                sendPushNotificationForScheduleEntry(scheduleEntry);
                return;
            case LOW:
                sendPushNotificationForScheduleEntry(scheduleEntry);
                return;
        }
    }

    private void sendSilentPushNotificationForScheduleEntry(
            ScheduleEntryEntity scheduleEntry
    ) {



    }

    private void sendPushNotificationForScheduleEntry(
            final ScheduleEntryEntity scheduleEntry
    ) {
        OneSignalPushNotification notification =
                oneSignalNotificationFactory.createPushNotification(scheduleEntry);

        oneSignalService.sendPushNotification(notification);
    }

    public void processExpiredScheduleEntries() {

    }
}
