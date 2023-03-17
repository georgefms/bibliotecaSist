package br.com.georgefms.bibliotecaSist.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
/*
 * EnableGlobalMethodSecurity: permite controlar as permissões diretamente nos controllers.
 * @PreAuthorize("hasAnyHole('ROLE_ADMIN', ROLE_USER)") -> configuração de acesso para qualquer ROLE.
 * @PreAuthorize("hasHole('ROLE_ADMIN')") -> configuração de acesso para ROLE especifica.
 */
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeHttpRequests()
                    .antMatchers(HttpMethod.GET, "/api/books/**").hasAnyRole("ROLE_ADMIN", "ROLE_USER")
                    .antMatchers(HttpMethod.GET, "/api/users/**").hasRole("ROLE_ADMIN")
                    .antMatchers(HttpMethod.POST, "/api/books/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                    .antMatchers(HttpMethod.PUT, "/api/books/**").hasRole("ROLE_ADMMIN")
                    .antMatchers(HttpMethod.DELETE, "/api/books/**").hasRole("ROLE_ADMMIN")
                    //.antMatchers(HttpMethod.PUT, "/api/books/**").access("@")
                    //.antMatchers(HttpMethod.DELETE, "/api/books/**").access()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
