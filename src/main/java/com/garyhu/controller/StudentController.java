package com.garyhu.controller;

import com.garyhu.entity.Student;
import com.garyhu.feign.StudentFeignClient;
import com.garyhu.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: garyhu
 * @since: 2018/11/15 0015
 * @decription:
 */
@RestController
public class StudentController {

    @Autowired
    private StudentFeignClient studentFeignClient;

    @GetMapping("/student")
    public Result<Student> getStduent(@RequestParam(value = "id",required = true)Integer id){
        return studentFeignClient.findById(id);
    }
}
