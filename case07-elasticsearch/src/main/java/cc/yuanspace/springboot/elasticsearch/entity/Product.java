package cc.yuanspace.springboot.elasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "product")
@Setting(shards = 1,replicas = 1)
public class Product {

    /**
     * @Id 注解指定 id 字段
     */
    @Id
    private Long id;
    // 名称
    @Field(type = FieldType.Text)
    private String title;
    // 分类
    @Field(type = FieldType.Keyword)
    private String category;
    // 价格，单位分
    @Field(type = FieldType.Long)
    private Long price;
    // 图片
    @Field(type = FieldType.Keyword, index = false)
    private String image;
}
