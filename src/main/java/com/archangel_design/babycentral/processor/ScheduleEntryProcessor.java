package com.archangel_design.babycentral.processor;

import com.archangel_design.babycentral.configuration.OneSignalConfiguration;
import com.archangel_design.babycentral.entity.ScheduleEntryEntity;
import com.archangel_design.babycentral.service.onesignal.OneSignalNotificationRequestFactory;
import com.archangel_design.babycentral.service.onesignal.OneSignalService;
import com.archangel_design.babycentral.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleEntryProcessor {

    private final ScheduleService scheduleService;

    private final OneSignalConfiguration oneSignalConfiguration;
    private final OneSignalService oneSignalService;
    private final OneSignalNotificationRequestFactory oneSignalNotificationRequestFactory;

    @Autowired
    public ScheduleEntryProcessor(final ScheduleService scheduleService, final OneSignalService oneSignalService, final OneSignalConfiguration oneSignalConfiguration){
        this.scheduleService = scheduleService;
        this.oneSignalService = oneSignalService;
        this.oneSignalConfiguration = oneSignalConfiguration;
        this.oneSignalNotificationRequestFactory = new OneSignalNotificationRequestFactory(oneSignalConfiguration);
    }

    public void sendNotificationsForScheduleEntries() {
        List<ScheduleEntryEntity> scheduleEntries = scheduleService.getEventsForNotificationSending();
        scheduleEntries.forEach(this::sendNotificationForScheduleEntry);
    }

    private void sendNotificationForScheduleEntry(ScheduleEntryEntity scheduleEntry) {
    }

    public void processExpiredScheduleEntries() {

    }
}
