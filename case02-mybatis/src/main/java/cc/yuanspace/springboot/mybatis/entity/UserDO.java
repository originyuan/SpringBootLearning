package cc.yuanspace.springboot.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 使用二级缓存需要实现序列化接口
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDO implements Serializable {
    private Long userId;

    private String username;

    private Integer gender;

    private LocalDateTime createTime;
}
