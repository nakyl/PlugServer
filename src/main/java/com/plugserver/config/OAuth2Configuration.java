package com.plugserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.plugserver.security.CustomAuthenticationEntryPoint;
import com.plugserver.security.CustomLogoutSuccessHandler;

@Configuration
@EnableResourceServer
public class OAuth2Configuration extends ResourceServerConfigurerAdapter  {

        @Autowired
        private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

        @Autowired
        private CustomLogoutSuccessHandler customLogoutSuccessHandler;

        @Override
        public void configure(HttpSecurity http) throws Exception {

            http
            .exceptionHandling()
            .authenticationEntryPoint(customAuthenticationEntryPoint)
            .and()
            .logout()
            .logoutUrl("/oauth/logout")
            .logoutSuccessHandler(customLogoutSuccessHandler)
            .and()
            .csrf()
            .requireCsrfProtectionMatcher(new AntPathRequestMatcher("/oauth/authorize"))
            .disable()
            .headers()
            .frameOptions().disable().and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
			.authorizeRequests()
                    .antMatchers("/status").permitAll()
                    .antMatchers("/switch").hasAuthority("ROLE_ADMIN");

        }
        


}
