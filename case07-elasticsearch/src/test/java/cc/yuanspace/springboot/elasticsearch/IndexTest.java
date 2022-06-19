package cc.yuanspace.springboot.elasticsearch;

import cc.yuanspace.springboot.elasticsearch.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

/**
 * 索引操作
 */
@SpringBootTest
public class IndexTest {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    /**
     * 创建索引
     */
    @Test
    public void create() {
        System.out.println("运行自动创建不存在的索引");
    }

    /**
     * 删除索引
     */
    @Test
    public void del() {
        boolean delete = elasticsearchRestTemplate.indexOps(Product.class).delete();
        System.out.println("删除索引：" + delete);
    }

    /**
     * 查询索引
     */
    @Test
    public void get() {

    }

    /**
     * 更新索引
     */
    @Test
    public void update() {

    }


}
