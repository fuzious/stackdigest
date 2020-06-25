package com.stackDigest.stackDigest.MVC;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Configuration
@EnableScheduling
@Component
public class ScheduledDatabase {

    @Bean
//	@ConditionalOnProperty(name = "jobs_enabled",matchIfMissing = true,havingValue = "true")
    public ScheduledDatabase scheduledJobs() {
        return new ScheduledDatabase();
    }


}
