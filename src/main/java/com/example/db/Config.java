package com.example.db;
import javax.ws.rs.ApplicationPath;

import com.example.db.controller.CountryController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
@ApplicationPath("/")
public class Config extends ResourceConfig {
    public Config() {
        register(CountryController.class);
    }
}