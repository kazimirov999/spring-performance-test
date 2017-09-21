package com.delphi.performance;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * Created by kazimirov on 7/24/17.
 */
@Configuration
@SpringBootApplication(scanBasePackages = {"com.delphi.performance"})
@EnableMetrics(proxyTargetClass = true)
public class SpringBootRestConfiguration extends MetricsConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestConfiguration.class, args);
    }

    @Override
    public void configureReporters(MetricRegistry metricRegistry) {
        // registerReporter allows the MetricsConfigurerAdapter to
        // shut down the reporter when the Spring context is closed
        registerReporter(ConsoleReporter
                .forRegistry(metricRegistry)
                .build())
                .start(1, TimeUnit.MINUTES);
    }
}
