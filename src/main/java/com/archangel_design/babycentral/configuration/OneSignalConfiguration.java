package com.archangel_design.babycentral.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class OneSignalConfiguration {

    private final String appId = "tmp";
    private final String authorizationId = "tmp";
}
