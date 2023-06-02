package TechK.identityservice.core.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import TechK.identityservice.jwt.JwtRequestFilter;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

	private JwtRequestFilter jwtRequestFilter;
	private AuthenticationProvider authenticationProvider;

	public WebSecurityConfig(JwtRequestFilter jwtRequestFilter, AuthenticationProvider authenticationProvider) {
		this.jwtRequestFilter = jwtRequestFilter;
		this.authenticationProvider = authenticationProvider;
	}
	
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/auth/register", "/auth/login", "/auth/validate").permitAll()
                .and()
                .build();
    }


//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity.csrf().disable().authorizeHttpRequests()
//				.antMatchers("/register", "/login", "/swagger-ui/**", "/swagger-ui.html", "/v3/api-docs/**","auth/**")
//				.permitAll()
////				.requestMatchers("/book").permitAll()
////				.antMatchers("/book/**")
////				.hasRole("ADMIN")
////				.antMatchers("/author/**")
////				.hasRole(Roles.ADMIN.name())
//				.anyRequest().authenticated().and().sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//				.authenticationProvider(authenticationProvider)
//				.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//		return httpSecurity.build();
//	}

}