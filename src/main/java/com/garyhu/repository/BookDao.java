package com.garyhu.repository;

import com.garyhu.pojo.BookEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author: garyhu
 * @since: 2019/3/5 0005
 * @decription:
 */
@Component
public interface BookDao extends ElasticsearchRepository<BookEntity,String> {
}
