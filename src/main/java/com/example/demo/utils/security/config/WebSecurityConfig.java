package com.example.demo.utils.security.config;
import com.example.demo.utils.security.JwtAccessDeniedHandler;
import com.example.demo.utils.security.JwtAuthenticationEntryPoint;
import com.example.demo.utils.security.JwtAuthenticationTokenFilter;
import com.example.demo.utils.security.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * @program: management
 * @description: spring security类
 * @author: ggmr
 * @create: 2019-01-02 00:26
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Resource
    private MyUserDetailService myUserDetailService;

    @Resource
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Resource
    private JwtAccessDeniedHandler jwtAccessDeniedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {



        http
                .csrf().disable()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                //对请求进行认证
                .authorizeRequests()
                    .antMatchers(HttpMethod.OPTIONS, "/**").permitAll();
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        //对于没有登录的用户，要返回401
        http.exceptionHandling().authenticationEntryPoint(unauthorizedHandler);
        //对于登录了但是权限有问题的用户，要返回403
        http.exceptionHandling().accessDeniedHandler(jwtAccessDeniedHandler);
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {

        return super.authenticationManagerBean();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(myUserDetailService);
    }
}
