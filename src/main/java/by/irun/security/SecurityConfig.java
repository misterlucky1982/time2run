package by.irun.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

import by.irun.config.ConfigHelper;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                    .antMatchers(ConfigHelper.allPublicResourcesFor(ConfigHelper.CLUB_PAGE)).permitAll()
                    .antMatchers(ConfigHelper.allPublicResourcesFor(ConfigHelper.EVENTS_PAGE)).permitAll()
                    .antMatchers(ConfigHelper.allPublicResourcesFor(ConfigHelper.RACE_PAGE)).permitAll()
                    .antMatchers(ConfigHelper.allPublicResourcesFor(ConfigHelper.RUNNER_PAGE)).permitAll()
                    .antMatchers("/css/*","/css/**/*", "/images/*", "/images/**/*", "/scripts/**/*").permitAll()
                    .antMatchers("/*/admin/** ** ").hasAnyRole("ADMIN")
                    .antMatchers("/*/user/** ** ").hasAnyRole("USER")
                    .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/login/")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll()
                    .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }

   //create two users, admin and user
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER")
                .and()
                .withUser("admin").password("password").roles("ADMIN");
    }
    
}
