package by.itechart.katstock.configuration;

import by.itechart.katstock.security.handler.AuthenticationFailureHandlerImpl;
import by.itechart.katstock.security.handler.AuthenticationSuccessHandlerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;

/**
 * Created by katsiaryna.siamikina on 09.07.2015.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final String LOGIN_PAGE = "/#login";

    private final String LOGIN_URL = "/login";
    private final String LOGOUT_URL = "/logout";

    private final String USERNAME_PARAMETER = "email";
    private final String PASSWORD_PARAMETER = "password";

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configAuthenication(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService)
                .passwordEncoder(new ShaPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/resources/**").permitAll()
        .and()
                .formLogin()
                .loginPage(LOGIN_PAGE)
                .loginProcessingUrl(LOGIN_URL)
                .usernameParameter(USERNAME_PARAMETER)
                .passwordParameter(PASSWORD_PARAMETER)
                .failureHandler(authenticationFailureHandler())
                .successHandler(authenticationSuccessHandler());
        
        http.csrf();

        http.logout()
                .permitAll()
                .logoutUrl(LOGOUT_URL)
                .invalidateHttpSession(true);

        http.rememberMe()
                .rememberMeParameter("remember");
    }

    @Bean
    public ShaPasswordEncoder shaPasswordEncoder(){
        return new ShaPasswordEncoder();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new AuthenticationFailureHandlerImpl();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {

        return new AuthenticationSuccessHandlerImpl();
    }
}
