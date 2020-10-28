package com.bourntec.apmg.inventorymanagement.v1.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
/**
 * 
 * The class is used for configuring the resource server 
 *
 */
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class InventoryManagementConfiguration extends WebSecurityConfigurerAdapter{
	@Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}")
	String jwkSetUri;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http.cors().and().csrf().disable().authorizeRequests()
		.mvcMatchers(HttpMethod.OPTIONS, "/**").permitAll().and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and().oauth2ResourceServer().jwt().jwtAuthenticationConverter(new JwtAuthenticationConverter() {
					/**
					 * This block is added here for accessing the end points based on Role. By
					 * default, the resource server populates the authorities based on the "scope"
					 * claim. In order to add the roles(ROLE_) in to authorities we need to fetch
					 * and add claim "authorities"
					 */
					@Override
					protected Collection<GrantedAuthority> extractAuthorities(Jwt jwt) {
						JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
						Collection<GrantedAuthority> authorities = grantedAuthoritiesConverter.convert(jwt);
						List<String> resourceAccess = (List) jwt.getClaim("authorities");
						if (resourceAccess != null && !resourceAccess.isEmpty()) {
							authorities.addAll(resourceAccess.stream().map(role -> new SimpleGrantedAuthority(role))
									.collect(Collectors.toSet()));
						}
						return authorities;
					}
				});
	}

	@Bean
	public FilterRegistrationBean corsFilterRegistrationBean() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.applyPermitDefaultValues();
		config.setAllowCredentials(true);
		config.setAllowedOrigins(Arrays.asList("*"));
		config.setAllowedHeaders(Arrays.asList("*"));
		config.setAllowedMethods(Arrays.asList("*"));
		config.setExposedHeaders(Arrays.asList("content-length"));
		config.setMaxAge(3600L);
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(0);
		return bean;
	}

	@Bean
	JwtDecoder jwtDecoder() {
		return NimbusJwtDecoder.withJwkSetUri(this.jwkSetUri).build();
	}
}
