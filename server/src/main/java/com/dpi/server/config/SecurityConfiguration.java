package com.dpi.server.config;

import com.dpi.server.filter.CustomUsernamePasswordFilter;
import com.dpi.server.filter.JwtFilter;
import com.dpi.server.handler.*;
import com.dpi.server.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Package com.dpi.server.config
 * @ClassName SecurityConfiguration
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/23
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                // Spring Security should completely ignore URLs starting with /resources/
                .antMatchers("/static/**", "/resources/**");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtFilter jwtFilter, CustomLogoutHandler customLogoutHandler) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                // Possibly more configuration ...
                .formLogin() // enable form based log in
                .failureHandler(new CustomAuthenticationFailureHandler())
                .and()
                .exceptionHandling()
                .accessDeniedHandler(new CustomAccessDeniedHandler())
                .authenticationEntryPoint(new CustomAuthenticationEntryPointHandler())
                .and()
                .logout()
                .addLogoutHandler(customLogoutHandler)
                .and()
                // set permitAll for all URLs associated with Form Login
                .sessionManagement(x -> x.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf().disable()
                .cors().disable();

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);


        http.addFilterAt(customUsernamePasswordFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


    @Bean
    public CustomUsernamePasswordFilter customUsernamePasswordFilter() throws Exception {
        CustomUsernamePasswordFilter customUsernamePasswordFilter = new CustomUsernamePasswordFilter();
        customUsernamePasswordFilter.setAuthenticationSuccessHandler(new CustomUsernamePasswordSuccessHandler());
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(customUserDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        ProviderManager providerManager = new ProviderManager(daoAuthenticationProvider);

        customUsernamePasswordFilter.setAuthenticationManager(providerManager);

        return customUsernamePasswordFilter;
    }


    @Bean
    public UserDetailsService userDetailsService() {
        return customUserDetailsService;
    }


    @Bean
    public void disableWarning() {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            Unsafe u = (Unsafe) theUnsafe.get(null);

            Class cls = Class.forName("jdk.internal.module.IllegalAccessLogger");
            Field logger = cls.getDeclaredField("logger");
            u.putObjectVolatile(cls, u.staticFieldOffset(logger), null);
        } catch (Exception e) {
            // ignore
        }
    }
}
