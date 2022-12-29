package com.nhnacademy.customerservice.config;

import com.nhnacademy.customerservice.Base;
import com.nhnacademy.customerservice.repository.*;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackageClasses = Base.class,
        excludeFilters = {@ComponentScan.Filter(Controller.class)})
public class RootConfig {

//    @Bean
//    public PostRepository postRepository() {
//        PostRepository postRepository = new PostRepositoryImpl();
//        postRepository.register("test", "상품문의", "test", " ",null);
//        return postRepository;
//    }

    @Bean
    public UserRepository userRepository() {
        UserRepository userRepository = new UserRepositoryImpl();
        userRepository.addUser("user", "1q2w3e4r");

        return userRepository;
    }

    @Bean
    public AdminRepository adminRepository() {
        AdminRepository adminRepository = new AdminRepositoryImpl();
        adminRepository.addAdmin("매니저", "admin", "1q2w3e4r");

        return adminRepository;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setBasename("message");

        return messageSource;
    }


}
