package com.garyhu.feign;

import com.garyhu.entity.Student;
import com.garyhu.pojo.Result;
import config.FeignConfiguration;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: garyhu
 * @since: 2018/11/15 0015
 * @decription:
 */
@FeignClient(name = "PersonalProject",configuration = FeignConfiguration.class)
public interface StudentFeignClient {

    @RequestMapping(value = "/getStudent",method = RequestMethod.GET)
    public Result<Student> findById(@RequestParam(value = "id",required = true) Integer id);

//    @RequestLine("GET /getStudent")
}
