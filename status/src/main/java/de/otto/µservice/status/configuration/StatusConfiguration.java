package de.otto.µservice.status.configuration;

import de.otto.µservice.status.indicator.ApplicationStatusAggregator;
import de.otto.µservice.status.indicator.DefaultApplicationStatusAggregator;
import de.otto.µservice.status.indicator.StatusDetailIndicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static java.util.Collections.emptyList;

@Configuration
public class StatusConfiguration {

    @Autowired(required = false)
    private List<StatusDetailIndicator> statusDetailIndicators = emptyList();

    @Value(value = "${application.name}")
    private String applicationName;

    @Bean
    @ConditionalOnMissingBean(ApplicationStatusAggregator.class)
    public ApplicationStatusAggregator statusAggregator() {
        return new DefaultApplicationStatusAggregator(applicationName, statusDetailIndicators);
    }

}
