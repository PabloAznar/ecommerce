package com.example.ecommerce.shared.configuration;

import com.example.ecommerce.shared.aspects.infrastructure.ControllerLogAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AspectConfiguration {

    @Bean
    public ControllerLogAspect controllerLogAspect() {
        return new ControllerLogAspect();
    }
}
