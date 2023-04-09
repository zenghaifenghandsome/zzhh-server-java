package com.zzhh.zzhhserverjava.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @Author zenghaifeng
 * @Date 2023/4/9 14:37
 * @Package: com.zzhh.zzhhserverjava.config
 * @Class: SecurityConfig
 * @Description: TODO
 * @Version 1.0
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       http
               .authorizeRequests((requests) -> requests
                       .requestMatchers("/","/home").permitAll()
                       .anyRequest().authenticated()
               )
               .formLogin((form) -> form
                       .loginPage("/login")
                       .permitAll()
               )
               .logout(LogoutConfigurer::permitAll);

       return http.build();
    }
}
