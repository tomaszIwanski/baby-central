package com.archangel_design.babycentral.service.onesignal;

import com.archangel_design.babycentral.enums.Language;
import com.archangel_design.babycentral.enums.ScheduleEntryPriority;
import com.archangel_design.babycentral.enums.ScheduleEntryRepeatType;
import com.archangel_design.babycentral.service.onesignal.notificationfilters.NotificatonFilter;
import com.archangel_design.babycentral.service.onesignal.notificationfilters.TagFilter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.sql.Time;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Getter
// TODO rethink
public class OneSignalPushNotification {

    @JsonProperty("app_id")
    private final String appId;
    private final List<NotificatonFilter> filters;
    private final HashMap<Language, String> contents = new HashMap<Language, String>();

    public OneSignalPushNotification(final String appId, final String organizationId) {
        this.appId = appId;
        this.filters = Collections.singletonList(
                new TagFilter("organizationId", organizationId));
        this.contents.put(Language.ENGLISH, "");
    }

    public void addMessage(final Language language, final String message) {
        contents.put(language, message);
    }
}
