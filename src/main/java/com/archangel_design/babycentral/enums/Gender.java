package com.archangel_design.babycentral.enums;

public enum Gender {
    MALE,
    FEMALE;

    public static Gender fromString(String input) {
        return Gender.valueOf(input.toUpperCase());
    }
}
