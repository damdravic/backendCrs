package com.ddv.backendCrs.security;

import com.ddv.backendCrs.security.securityServices.CrsUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private CrsUserDetailsService crsUserDetailsService;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
         auth.userDetailsService(crsUserDetailsService).passwordEncoder(passwordEncoder);
      }




}
