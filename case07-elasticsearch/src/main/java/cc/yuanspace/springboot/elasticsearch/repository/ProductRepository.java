package cc.yuanspace.springboot.elasticsearch.repository;

import cc.yuanspace.springboot.elasticsearch.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 数据访问对象，和 jpa 类似
 * 用于对象文档数据增删改查
 */
@Repository
public interface ProductRepository extends ElasticsearchRepository<Product, Long> {

    List<Product> findProductsByTitle(String title);
}
