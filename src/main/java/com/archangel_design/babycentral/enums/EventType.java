package com.archangel_design.babycentral.enums;

public enum EventType {
    LOGIN,
    LOGOUT,
    FAILED_LOGIN,
    CUSTOM;

    public static EventType fromString(String input) {
        return EventType.valueOf(input.toUpperCase());
    }
}
