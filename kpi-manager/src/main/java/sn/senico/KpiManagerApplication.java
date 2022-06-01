package sn.senico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

/**
 * Init class, launcher
 */
@SpringBootApplication(scanBasePackages = "sn.senico")
@EnableSpringDataWebSupport
public class KpiManagerApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(KpiManagerApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(KpiManagerApplication.class);
    }

}
