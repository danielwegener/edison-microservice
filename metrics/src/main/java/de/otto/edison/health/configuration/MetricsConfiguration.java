package de.otto.edison.health.configuration;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Slf4jReporter;
import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter;
import org.springframework.context.annotation.Configuration;

import static com.codahale.metrics.Slf4jReporter.LoggingLevel.INFO;
import static java.util.concurrent.TimeUnit.MINUTES;
import static org.slf4j.LoggerFactory.getLogger;

@Configuration
@EnableMetrics
public class MetricsConfiguration extends MetricsConfigurerAdapter {

    @Override
    public void configureReporters(final MetricRegistry metricRegistry) {
        Slf4jReporter
                .forRegistry(metricRegistry)
                .outputTo(getLogger("de.otto.edison.metrics"))
                .withLoggingLevel(INFO)
                .build()
                .start(1, MINUTES);
    }

}
