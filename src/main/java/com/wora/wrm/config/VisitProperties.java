package com.wora.wrm.config;

import com.wora.wrm.models.enumes.VisitorStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "visit")
@Getter
@Setter
public class VisitProperties {
    private VisitorStatus defaultVisitorStatus = VisitorStatus.WAITING;
}
