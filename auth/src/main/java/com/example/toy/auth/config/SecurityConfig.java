package com.example.toy.auth.config;

import com.example.toy.auth.security.LoginFailureHandler;
import com.example.toy.auth.security.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    public SecurityConfig(JwtTokenProvider jwtTokenProvider, JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/resources/**", "/css/**", "/js/**", "/favicon*/**", "/img/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().configurationSource(corsConfigurationSource())
                .and()
                    .authorizeRequests() //보호된 리소스 URI에 접근할 수 있는 권한을 설정
                    .antMatchers("/api/test").permitAll()
                    .antMatchers("/login").permitAll() //전체 접근 허용
                    .antMatchers("/error").permitAll()
                    .antMatchers("/logout").permitAll()
                    .antMatchers("/auth/signup").permitAll()
                    .antMatchers("/myPage").hasRole("ADMIN") //admin이라는 롤을 가진 사용자만 접근 허용
                    .antMatchers("/").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                    .exceptionHandling()
                    .authenticationEntryPoint(jwtAuthenticationEntryPoint)
//                    .accessDeniedHandler() // 인가 예외처리

                .and()


                // 토큰을 활용하면 세션이 필요 없으므로 STATELESS로 설정하여 Session을 사용하지 않는다.
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

//                .and()
//                .formLogin()
//                .usernameParameter("email")
//                .passwordParameter("password")
//                .successHandler(loginSuccessHandler)
//                .failureHandler(loginFailureHandler)
//                .permitAll()

    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return  new JwtAuthenticationFilter(jwtTokenProvider);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.setAllowCredentials(true);
        configuration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
