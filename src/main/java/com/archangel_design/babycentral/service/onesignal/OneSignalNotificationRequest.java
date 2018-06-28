package com.archangel_design.babycentral.service.onesignal;

import com.archangel_design.babycentral.enums.ScheduleEntryPriority;
import com.archangel_design.babycentral.enums.ScheduleEntryRepeatType;
import com.archangel_design.babycentral.service.onesignal.notificationfilters.NotificatonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.sql.Time;
import java.util.Collections;
import java.util.List;

@Getter
// TODO rethink
public class OneSignalNotificationRequest {

    @JsonProperty("app_id")
    private final String appId;
    private final List<NotificatonFilter> filters;
    private final Data data;
    private final Contents contents;

    public OneSignalNotificationRequest(
            final String appId,
            final String title,
            final ScheduleEntryPriority scheduleEntryPriority,
            final ScheduleEntryRepeatType scheduleEntryRepeatType,
            final Time start,
            final Time stop,
            final NotificatonFilter filter
    ) {
        this.appId = appId;
        this.filters = Collections.singletonList(filter);
        this.data = new Data(scheduleEntryPriority, scheduleEntryRepeatType, start, stop);
        this.contents = new Contents(title);
    }

    @Getter
    @RequiredArgsConstructor
    protected static class Data {
        private final ScheduleEntryPriority scheduleEntryPriority;
        private final ScheduleEntryRepeatType scheduleEntryRepeatType;
        private final Time start;
        private final Time stop;

    }

    @Getter
    @RequiredArgsConstructor
    protected static class Contents {
        private final String en;
    }
}
