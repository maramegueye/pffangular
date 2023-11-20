package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class CrossConfig  implements WebMvcConfigurer{

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
        .allowedOrigins("*") // Allow all origins (for testing purposes)
        .allowedMethods("GET", "POST", "PUT", "DELETE","OPTIONS");
    }

    
    
}
