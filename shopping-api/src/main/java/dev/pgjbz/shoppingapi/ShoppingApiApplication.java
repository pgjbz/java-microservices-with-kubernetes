package dev.pgjbz.shoppingapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import dev.pgjbz.shoppingapi.config.UrlsConfig;


@SpringBootApplication
@ConfigurationPropertiesScan(basePackageClasses = {UrlsConfig.class})
public class ShoppingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingApiApplication.class, args);
	}

}
