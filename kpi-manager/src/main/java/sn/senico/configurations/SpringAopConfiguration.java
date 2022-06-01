package sn.senico.configurations;

import net.sf.aspect4log.aspect.LogAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local")
@EnableAspectJAutoProxy
public class SpringAopConfiguration {

    @Bean
    LogAspect createLogAspect() {
        return new LogAspect();
    }

}
