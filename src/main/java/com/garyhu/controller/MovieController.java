package com.garyhu.controller;

import com.garyhu.entity.User;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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

    @GetMapping("/{id}")
    @ResponseBody
    public User getUser(@PathVariable Integer id){

        User user = restTemplate.getForObject("http://localhost:8000/user/" + id, User.class);

        return user;
    }

}
