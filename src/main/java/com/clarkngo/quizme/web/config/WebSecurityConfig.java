//package com.clarkngo.quizme.web.config;
//
//import com.clarkngo.quizme.web.dao.UserDao;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    UserDao userDao;
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .csrf()
//                    .disable()
//                .authorizeRequests()
//                    //Доступ только для не зарегистрированных пользователей
//                    .antMatchers("/registration").not().fullyAuthenticated()
//                //.antMatchers("").not().fullyAuthenticated()
//                    //Доступ только для пользователей с ролью Администратор
//                    .antMatchers("/admin-form/**").hasRole("ADMIN")
//                    .antMatchers("/home").hasRole("USER")
//                    //Доступ разрешен всем пользователей
//                    .antMatchers("/chat").permitAll()
//               // .antMatchers("/chat").authenticated()
//                //Все остальные страницы требуют аутентификации
//               // .anyRequest().authenticated()
//                .and()
//                    //Настройка для входа в систему
//                    .formLogin()
//                    .loginPage("/login")
//                    //Перенарпавление на главную страницу после успешного входа
//                    .defaultSuccessUrl("/")
//                    .permitAll()
//                .and()
//                    .logout()
//                    .permitAll()
//                    .logoutSuccessUrl("/");
//    }
//
////    @Autowired
////    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////        auth.userDetailsService(userDao).passwordEncoder(bCryptPasswordEncoder());
////    }
//}
