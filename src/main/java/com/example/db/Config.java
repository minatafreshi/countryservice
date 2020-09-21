package com.example.db;
import javax.ws.rs.ApplicationPath;

import com.example.db.controller.CountryController;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
@ApplicationPath("/")
public class Config extends ResourceConfig {
    public Config() {
        register(CountryController.class);
        register(ApiListingResource.class);
        register(SwaggerSerializers.class);
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1");
        beanConfig.setResourcePackage("com.example.db.controller");
    }
}
