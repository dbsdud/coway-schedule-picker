package io.dbsdud.schedulepicker.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Value("${ext.group}")
    String group;
    @Value("${ext.version}")
    String version;
    @Value("${ext.appName}")
    String appName;

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder().group(group).pathsToMatch("/**").build();
    }

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .addServersItem(new Server().url("/"))
                .info(new Info().title("schedule-picker-"+ appName + " OPEN API")
                        .description(group + " " +
                                appName + " API 명세서")
                        .version(version));
    }

}
