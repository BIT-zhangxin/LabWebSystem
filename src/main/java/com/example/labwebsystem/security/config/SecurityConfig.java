package com.example.labwebsystem.security.config;


import com.example.labwebsystem.security.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)  //  启用方法级别的权限认证
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailService userDetailsService;

    @Bean(name="encoder")
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        //  允许所有用户访问"/"和"/index.html"
//        http.authorizeRequests()
//                .antMatchers("/", "/index.html").permitAll()
//                .anyRequest().authenticated()   // 其他地址的访问均需验证权限
//                .and()
//                .formLogin()
//                .loginPage("/login.html")   //  登录页
//                .failureUrl("/login-error.html").permitAll()
//                .and()
//                .logout()
//                .logoutSuccessUrl("/index.html");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .headers().frameOptions().sameOrigin().
                and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/css/**","/js/**","/login","/image/**","/register").permitAll()
                .antMatchers("/","/index").hasRole("USER")
                .and()
                .formLogin()
                .loginPage("/login").failureUrl("/login-error").permitAll()
                .and()
                .logout().permitAll()
                .logoutSuccessUrl("/login");
    }
}