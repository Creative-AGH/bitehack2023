package com.freecoders.server.security;

import com.freecoders.server.security.JsonObjectAuthenticationFilter;
import com.freecoders.server.security.JwtAuthorizationFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.session.DisableEncodeUrlFilter;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final RestAuthenticationFailureHandler authenticationFailureHandler;
    private final RestAuthenticationSuccessHandler authenticationSuccessHandler;
    private final String secret;
    private final UserDetailsService userDetailsService;
    public SecurityConfig(RestAuthenticationFailureHandler authenticationFailureHandler, RestAuthenticationSuccessHandler authenticationSuccessHandler,
                          @Value("${jwt.secret}") String secret, UserDetailsService userDetailsService) {
        this.authenticationFailureHandler = authenticationFailureHandler;
        this.authenticationSuccessHandler = authenticationSuccessHandler;
        this.secret = secret;
        this.userDetailsService = userDetailsService;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder
                .userDetailsService(userDetailsService);
    }
    @Override
    public void configure(WebSecurity web) throws Exception {

//        web.ignoring().antMatchers("/register")
//                .mvcMatchers("/validate")
//                .mvcMatchers("/resendEmail")
//                .mvcMatchers("/contact-form");
    }
    @Bean PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public FilterRegistrationBean<NullCorsFilter> nullCorsFilter() {
//        FilterRegistrationBean<NullCorsFilter> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter(new NullCorsFilter());
//        registrationBean.addUrlPatterns("/*");
//        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
//        return registrationBean;
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        try
        {
            http
                    .csrf().disable()
                    .cors().and().cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
                    .and()
//                    .cors().disable()
                    .authorizeRequests()
//                .mvcMatchers("/**").permitAll()
//                .mvcMatchers("/admin/**").hasRole("ADMIN")
//                .mvcMatchers("/getUserData").hasAnyRole("USER","TEST","ADMIN")
//                .mvcMatchers("/changePassword").hasAnyRole("USER","ADMIN")
                    .anyRequest().permitAll()
                    .and()
//                    .formLogin().disable().cors()
//                    .and()
                    .headers().frameOptions().disable()
                    .and()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 1
                    .and()
//                    .addFilterBefore(new NullCorsFilter(), DisableEncodeUrlFilter.class)
//                    .addFilter(new NullCorsFilter())
                    .addFilter(authenticationFilter())
                    .addFilter(new JwtAuthorizationFilter(authenticationManager(), userDetailsService, secret)) // 2
                    .exceptionHandling()
                    .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
        }
        catch (Exception e){
        log.error("Error configuring security: " + e.getMessage());
        }

    }
    @Bean
    public JsonObjectAuthenticationFilter authenticationFilter() throws Exception {
        JsonObjectAuthenticationFilter filter = new JsonObjectAuthenticationFilter();
        filter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
        filter.setAuthenticationFailureHandler(authenticationFailureHandler);
        filter.setAuthenticationManager(super.authenticationManager());
        return filter;
    }


}
