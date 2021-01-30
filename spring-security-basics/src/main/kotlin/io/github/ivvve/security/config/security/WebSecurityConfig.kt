package io.github.ivvve.security.config.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.provisioning.JdbcUserDetailsManager
import javax.sql.DataSource

@Configuration
class WebSecurityConfig : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity?) {
        http!!
            .authorizeRequests()
            .antMatchers("/account", "/balance", "/loans", "/cards").authenticated()
            .antMatchers("/notices", "/contact").permitAll()
            .and()
            .formLogin()
            .and()
            .httpBasic()
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        // in-memory authentication 설정 시 spring.security.user 설정은 무시 된다
//        auth!!.inMemoryAuthentication()
//            .withUser("admin").password("1234").authorities("ROLE_ADMIN")
//                .and()
//            .withUser("user").password("1234").authorities("ROLE_USER")
//                .and()
//            .passwordEncoder(NoOpPasswordEncoder.getInstance()) // no encryption

//        val userDetailsService = InMemoryUserDetailsManager()
//
//        val admin = User.withUsername("admin").password("1234").authorities("ROLE_ADMIN").build()
//        val user = User.withUsername("user").password("1234").authorities("ROLE_USER").build()
//        userDetailsService.createUser(admin)
//        userDetailsService.createUser(user)
//
//        auth!!.userDetailsService(userDetailsService)
        // `UserDetailsService`를 등록하고 `PasswordEncoder` bean을 등록하지 않으면 오류가 난다

        super.configure(auth)
    }

//    @Bean
//    fun userDetailsService(dataSource: DataSource): UserDetailsService {
//        /**
//         * 아래와 같은 query를 통해 UserDetails를 가져온다
//         * SELECT username, password, enabled FROM users
//         *
//         * String userName = rs.getString(1);
//         * String password = rs.getString(2);
//         * boolean enabled = rs.getBoolean(3);
//         */
//        return JdbcUserDetailsManager(dataSource)
//    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
//        return NoOpPasswordEncoder.getInstance()
        return Argon2PasswordEncoder()
    }
}