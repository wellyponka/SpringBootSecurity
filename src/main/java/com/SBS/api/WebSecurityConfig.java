package com.SBS.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
        .antMatchers("/hello.html", "/bye.html").authenticated()
        .anyRequest().permitAll()
        .and()
      .formLogin().successHandler(mySuccessHandler()).and()
//      .loginPage("/sign.html").defaultSuccessUrl("/bye.html").permitAll().and()
      .logout().logoutSuccessUrl("/api/WebSueecssUrl?type=logout").permitAll().and()
      .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//            .inMemoryAuthentication()
//                .withUser("Barry").password("123").roles("USER");
        auth.userDetailsService(userDetailsService());
    }
    
    @Bean
    public RestLoginSuccessHandler mySuccessHandler(){
        return new RestLoginSuccessHandler();
    }
    
    @Bean
	public UserDetailsService userDetailsService(){
		return new CustomUserDetailService();
	}
}
