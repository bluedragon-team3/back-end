package com.example.cau.bluedragon.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
    info = @Info(
        title = "BlueDragon API Docs",
        description = "Back-end API Docs for CAU BlueDragon Hackathon",
        version = "v1"
    )
)
@Configuration
public class SwaggerConfig {

}
