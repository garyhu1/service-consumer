package com.garyhu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author: garyhu
 * @since: 2018/11/7 0007
 * @decription:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MovieApplication {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(MovieApplication.class,args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
