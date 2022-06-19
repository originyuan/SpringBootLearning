package cc.yuanspace.springboot.elasticsearch;

import cc.yuanspace.springboot.elasticsearch.entity.Product;
import cc.yuanspace.springboot.elasticsearch.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class RepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    /**
     * 新增数据
     */
    @Test
    public void save() {
        Product product = new Product();
        product.setId(1L);
        product.setTitle("联想小新笔记本电脑");
        product.setCategory("电脑");
        product.setPrice(5000L*100);
        product.setImage("http://notfoundimgs.com/img.jpg");
        productRepository.save(product);
    }

    @Test
    public void saveAll() {
        List<Product> all =new ArrayList<>();
        for(int i=2; i<=20; i++) {
            Product product = new Product();
            product.setId((long) i);
            product.setTitle("联想小新笔记本电脑-" + i);
            product.setCategory("电脑");
            product.setPrice(5000L*100);
            product.setImage("http://notfoundimgs.com/img.jpg");
            all.add(product);
        }

        productRepository.saveAll(all);
    }

    /**
     * 修改数据
     */
    @Test
    public void update() {
        Product product = new Product();
        product.setId(1L);  // id 已存在就是修改
        product.setTitle("外星人笔记本电脑");
        product.setCategory("笔记本电脑");
        product.setPrice(5000L*100);
        product.setImage("http://notfoundimgs.com/img.jpg");
        productRepository.save(product);
    }

    @Test
    public void del() {
//        productRepository.deleteById(1L);

        Product product = new Product();
        product.setId(1L);
        productRepository.delete(product);
    }

    @Test
    public void findById() {
        Optional<Product> product = productRepository.findById(1L);
        System.out.println(product.get());
    }

    @Test
    public void findAll() {
        Iterable<Product> all = productRepository.findAll();
        for (Product product : all) {
            System.out.println(product);
        }
    }

    @Test
    public void findPage() {
        Page<Product> all = productRepository.findAll(PageRequest.of(0, 5, Sort.by("id").descending()));
        all.get().forEach(System.out::println);
    }

}
