package com.wora.wrm.config;

import com.wora.wrm.models.enumes.AlgorithmType;
import com.wora.wrm.models.enumes.WorkMode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "waiting-room")
@Getter
@Setter
public class WaitingRoomProperties {
    private AlgorithmType defaultAlgorithmType = AlgorithmType.FIFO;
    private WorkMode defaultWorkMode = WorkMode.MORNING;
}
