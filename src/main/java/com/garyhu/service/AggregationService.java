package com.garyhu.service;

import com.garyhu.entity.Student;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Subscriber;

/**
 * @author : Administrator
 * @decripetion :
 * @since : 2018/11/18
 **/
@Service
public class AggregationService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public Observable<Student> getStudentById(final Integer id){
        // 创建一个被观察者
        return Observable.create(new Observable.OnSubscribe<Student>() {
            @Override
            public void call(Subscriber<? super Student> subscriber) {
                // 请求用户微服务的一个端点
                Student student = restTemplate.getForObject("http://PersonalProject/getStudent?id={id}",Student.class,id);
                subscriber.onNext(student);
                subscriber.onCompleted();
            }
        });
    }

    @HystrixCommand(fallbackMethod = "fallback")
    public Observable<Student> getStudentByOther(final Integer id){
        return Observable.create(new Observable.OnSubscribe<Student>() {
            @Override
            public void call(Subscriber<? super Student> subscriber) {
                // 请求用户微服务的另一个接口，这里没有那么多微服务，多的情况下可以请求另一个微服务的端点
                Student student = restTemplate.getForObject("http://PersonalProject/myStudent?id={id}",Student.class,id);

                subscriber.onNext(student);
                subscriber.onCompleted();
            }
        });
    }

    public Student fallback(Integer id){
        Student s  = new Student();
        s.setId(-1);
        s.setAge(-1);
        s.setName("默认用户");
        return s;
    }
}
