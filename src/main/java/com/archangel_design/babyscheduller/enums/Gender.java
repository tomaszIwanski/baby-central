package com.archangel_design.babyscheduller.enums;

public enum Gender {
    MALE,
    FEMALE;

    public static Gender fromString(String input) {
        return Gender.valueOf(input.toUpperCase());
    }
}
