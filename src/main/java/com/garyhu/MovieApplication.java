package com.garyhu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author: garyhu
 * @since: 2018/11/7 0007
 * @decription:
 */
@SpringBootApplication
@EnableDiscoveryClient// 服务发现
@EnableFeignClients// feign
// 只要Hystrix在项目的classpath中，Feign就会使用短路器包裹Feign客户端的所有方法
@EnableHystrix// hystrix容错 或者使用注解@EnableCircuitBreaker
public class MovieApplication {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(MovieApplication.class,args);
    }

    @Bean
    @LoadBalanced // 客户端负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
