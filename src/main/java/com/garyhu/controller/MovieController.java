package com.garyhu.controller;

import com.garyhu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author: garyhu
 * @since: 2018/11/9 0009
 * @decription:
 */
@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id){

        User user = restTemplate.getForObject("http://localhost:8000/user/" + id, User.class);

        return user;
    }

    @GetMapping("/movie-instance")
    public List<ServiceInstance> showInfo(){
        return this.discoveryClient.getInstances("microservice-simple-consumer-movie");
    }
}
