package com.example.toy.auth.config;

import com.example.toy.auth.security.LoginFailureHandler;
import com.example.toy.auth.security.LoginSuccessHandler;
import com.example.toy.common.filter.CorsFilter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
//위의 SecurityConfig에 붙은 @EnableWebSecurity을 보면 WebSecurityConfiguration.class,
// SpringWebMvcImportSelector.class, OAuth2ImportSelector.class, HttpSecurityConfiguration.class들을 import해서 실행시켜주는 것을 알 수 있습니다.
// 해당 annotation을 붙여야지 Securiry를 활성화 시킬 수 있습니다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private AuthenticationProvider authenticationProvider;

    //로그인 성공시 이동할 Handler 의존성 주입
    @Autowired
    LoginSuccessHandler loginSuccessHandler;

    @Autowired
    LoginFailureHandler loginFailureHandler;



//    /*UserDetailsService userDetailsService, PasswordEncoder passwordEncoder,*/
//    public void SpringSecurityConfig(AuthenticationProvider authenticationProvider) {
//        this.authenticationProvider = authenticationProvider;
//    }
//
//
//    /*
//     * 스프링 시큐리티가 사용자를 인증하는 방법이 담긴 객체.
//     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        /*
//         * AuthenticationProvider 구현체
//         */
//        auth.authenticationProvider(authenticationProvider);
////        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
//    }
//
//
//    /* * 스프링 시큐리티 룰을 무시하게 하는 Url 규칙(여기 등록하면 규칙 적용하지 않음) */
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring()
//                .antMatchers("/resources/**")
//                .antMatchers("/css/**")
//                .antMatchers("/vendor/**")
//                .antMatchers("/js/**")
//                .antMatchers("/favicon*/**")
//                .antMatchers("/img/**");
//    }
//
//
    /* * 스프링 시큐리티 규칙 */
    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http
                .csrf().disable()
                .cors().configurationSource(corsConfigurationSource()).and()
                .authorizeRequests() //보호된 리소스 URI에 접근할 수 있는 권한을 설정
                .antMatchers("/login").permitAll() //전체 접근 허용
                .antMatchers("/error").permitAll()
                .antMatchers("/logout").permitAll()
                .antMatchers("/myPage").hasRole("ADMIN") //admin이라는 롤을 가진 사용자만 접근 허용
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
            .and().formLogin()
                .successHandler(loginSuccessHandler)
                .failureHandler(loginFailureHandler)
                .permitAll()
            .and().logout()
                .permitAll();



        //해당 기능을 사용하기 위해서는 프론트단에서 csrf토큰값 보내줘야함

//            .addFilter(jwtAuthenticationFilter()) //Form Login에 사용되는 custom AuthenticationFilter 구현체를 등록
//            .addFilter(jwtAuthorizationFilter()) //Header 인증에 사용되는 BasicAuthenticationFilter 구현체를 등록
//            .exceptionHandling()
//                .accessDeniedHandler(accessDeniedHandler())
//                .authenticationEntryPoint(authenticationEntryPoint());


//        http.authorizeRequests()
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/**").permitAll();

    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.addAllowedOrigin("http://localhost:3000");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.setAllowCredentials(true);
        configuration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }



//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

}