package com.garyhu.controller;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.garyhu.pojo.Book;
import com.garyhu.pojo.BookEntity;
import com.garyhu.repository.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: garyhu
 * @since: 2019/3/5 0005
 * @decription:
 */
@RestController
public class ElasticController {

    @Autowired
    private BookDao bookDao;

    @GetMapping("/restClient/book/{id}")
    public String getMessage(@PathVariable String id) throws IOException {
        Book book = null;
        RestTemplate restTemplate = new RestTemplate();
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);

        String str = restTemplate.getForObject("http://127.0.0.1:9200/product/book/{id}",String.class,map);
        ObjectMapper mapper = new ObjectMapper();
        JsonFactory factory = mapper.getFactory();
        JsonParser parser = factory.createParser(str);
        JsonNode root = mapper.readTree(parser);
        JsonNode source = root.get("_source");
        book = mapper.convertValue(source,Book.class);
        return book.getMessage();
    }

    @GetMapping("/elastic/book/{id}")
    public BookEntity getBook(@PathVariable String id){
        BookEntity book = bookDao.findOne(id);
        return book;
    }
}
