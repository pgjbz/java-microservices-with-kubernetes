package dev.pgjbz.shoppingapi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "application.urls")
public record UrlsConfig(
    String productApi,
    String userApi
) {
}
