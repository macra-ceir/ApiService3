package com.gl.ceir.config.security;

import org.springframework.security.web.util.matcher.AnyRequestMatcher;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //.addFilter(hostHeaderValidationFilter())
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .and()
                .headers()
                .httpStrictTransportSecurity() // Enable HSTS header
                .includeSubDomains(true) // Include subdomains in HSTS
             //   .maxAgeInSeconds(15768000) // Set max age to one year
                .preload(false)
                .maxAgeInSeconds(15768000)
                .requestMatcher(AnyRequestMatcher.INSTANCE)

                .and()
                .xssProtection() //    .frameOptions().disable() // Disable X-Frame-Options for development
                .and()
                .frameOptions().sameOrigin() //    .contentTypeOptions().disable()
                 ; // Disable X-Content-Type-Options for development
    }

//    @Bean
//    public HostHeaderValidationFilter hostHeaderValidationFilter() {
//        return new HostHeaderValidationFilter();
//    }
}


//.addHeaderWriter(new StaticHeadersWriter("X-Content-Security-Policy", "script-src 'self'"))
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/**").permitAll()
//                .and()
//                .headers()
//                .httpStrictTransportSecurity().disable() // Disable HSTS for development
//       .xssProtection().equals(http) // .frameOptions().sameOrigin()  -----//  .xssProtection().enable(); // Disable XSS Protection for development
//                ;
//    }
//
//}
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {

//
//
//
//
//
//        http
//                .authorizeRequests()
//                .antMatchers("/**").permitAll()
//                .and()
//                .headers()
//                .httpStrictTransportSecurity().includeSubDomains(true).maxAgeInSeconds(31536000)
//                .frameOptions().sameOrigin()
//
//
//
//
//
//        http
//                .authorizeRequests()
//                .antMatchers("/**").permitAll() // Allow all endpoints without authentication
//                .and()
//                .headers()
//                .httpStrictTransportSecurity() // Enable HSTS header
//                .includeSubDomains(true) // Include subdomains in HSTS
//                .maxAgeInSeconds(31536000) // Set max age to one year
//                .and()
//                .xssProtection() // Enable X-XSS-Protection header
//                 // Disable XSS Protection
//                .and()
//                .frameOptions().sameOrigin() // Enable X-Frame-Options header
//               // .deny() // Deny all framing
//               // .and()
//            //    .contentTypeOptions(). // Enable X-Content-Type-Options header
//                //    .disable(); // Disable content-type sniffing
//
//                ;
//    }
//
//    //   .addHeaderWriter(new StaticHeadersWriter("X-Content-Security-Policy", "script-src 'self'"))\\
//
//    }
//        //        http
//        //                .authorizeRequests()
//        //                .antMatchers("/**").permitAll()
//        //                .and()
//        //                .headers()
//        //                .httpStrictTransportSecurity().includeSubDomains(true).maxAgeInSeconds(31536000)
//        //                .frameOptions().sameOrigin()
// // Disable HSTS for development
//
//                //  .xssProtection().equals(http)
//    //    .addHeaderWriter(new StaticHeadersWriter("X-Content-Security-Policy","script-src 'self'"))
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http
////                .headers()
////                .httpStrictTransportSecurity()
////                .requestMatcher(AnyRequestMatcher.INSTANCE)
////                .includeSubDomains(true)
////                .maxAgeInSeconds(31536000);
////    }
////        @Override
////        protected void configure (HttpSecurity http) throws Exception {
////            http
////                    .authorizeRequests()
////                    .antMatchers("/**").permitAll()
////                    .and()
////                    .headers()
////                    .httpStrictTransportSecurity().disable() // Disable HSTS for development
////                    .xssProtection().disable() // Disable XSS Protection for development
////                    .frameOptions().disable() // Disable X-Frame-Options for development
////                    .contentTypeOptions().disable(); // Disable X-Content-Type-Options for development
////        }
