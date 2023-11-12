 package sn.edu.isepdiamniadio.pff.ProjetPffAngular;
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.web.servlet.FilterRegistrationBean;
// import org.springframework.context.annotation.Bean;
// import org.springframework.core.Ordered;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
// import org.springframework.web.filter.CorsFilter;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetPffAngularApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetPffAngularApplication.class, args);
	}
	// @Bean
	// public FilterRegistrationBean corsFilter(){
	// 	final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	// 	final CorsConfiguration config = new CorsConfiguration();
	//     config.setAllowCredentials(true);
	//     config.addAllowedOrigin("*");
    //     config.addAllowedHeader("*");
    //     config.addAllowedMethod("OPTIONS");
    //     config.addAllowedMethod("HEAD");
    //     config.addAllowedMethod("GET");
    //     config.addAllowedMethod("PUT");
    //     config.addAllowedMethod("POST");
    //     config.addAllowedMethod("DELETE");
    //     config.addAllowedMethod("PATCH");
    //    source.registerCorsConfiguration("/**", config);
	//    FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
	//    bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
	//    return bean;
	// }

}
