package com.garyhu.feign;

import com.garyhu.entity.Student;
import com.garyhu.pojo.Result;
import config.FeignConfiguration;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author: garyhu
 * @since: 2018/11/15 0015
 * @decription:
 */
@FeignClient(name = "PersonalProject",configuration = FeignConfiguration.class)
public interface StudentFeignClient {

    @RequestMapping(value = "/getStudent",method = RequestMethod.GET)
    public Result<Student> findById(@RequestParam(value = "id",required = true) Integer id);

    /**
     * 这里不可以使用@RequestBody
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value="/student",method = RequestMethod.GET)
    public Result<Student> findByNameAndAge(@RequestParam("name")String name,@RequestParam("age")Integer age);

    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public Result<Student> student(@RequestParam Map<String,Object> map);

    @RequestMapping(value = "/obtainStudent",method = RequestMethod.POST)
    public Result obtainStudent(@RequestBody Student student);
}
