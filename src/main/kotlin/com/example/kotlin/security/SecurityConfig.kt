//package com.example.kotlin.security
//
//import org.springframework.context.annotation.Bean
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
//import org.springframework.security.web.SecurityFilterChain
//
//
//@EnableWebSecurity
//class SecurityConfig {
//    @Bean
//    @Throws(Exception::class)
//    fun filterChain(http: HttpSecurity): SecurityFilterChain {
//        return http.oauth2Login()
//            .and().build()
//    }
//}