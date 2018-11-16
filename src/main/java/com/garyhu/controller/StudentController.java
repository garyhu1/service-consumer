package com.garyhu.controller;

import com.garyhu.entity.Student;
import com.garyhu.feign.StudentFeignClient;
import com.garyhu.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("/getStudent")
    public Result<Student> findByNameAndAge(@RequestParam("name") String name,@RequestParam("age") Integer age){
        return studentFeignClient.findByNameAndAge(name,age);
    }

    @GetMapping("/getStudent2")
    public Result findByNameAndAge2(@RequestParam("name") String name,@RequestParam("age") Integer age){
        Map<String,Object> map = new HashMap<>();
        map.put("name",name);
        map.put("age",age);

        return studentFeignClient.student(map);
    }

    @PostMapping("/getStudent3")
    public Result obtainStudent(@RequestBody Student student){
        return studentFeignClient.obtainStudent(student);
    }
}
