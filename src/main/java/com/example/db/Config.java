package com.example.db;
import javax.ws.rs.ApplicationPath;

import com.example.db.controller.CountryController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/api/v1")
public class Config extends ResourceConfig {
    public void config() {
        register(CountryController.class);
    }
}