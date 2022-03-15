package com.example.First;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SecurtiyConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeRequests()
                .antMatchers("/updateUser").hasRole("ADMIN")
                .antMatchers("/deleteUser/{id}").hasRole("ADMIN")
                .antMatchers("createUser").hasRole("ADMIN")
                .antMatchers("/getAllUsers").hasAnyRole("USER" , "ADMIN")
                .antMatchers("/getUser/**").hasAnyRole("USER", "ADMIN")
                .and().formLogin();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("1234").authorities("ADMIN")
                .and().withUser("user").password("1234").authorities("USER")
                .and().passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}
