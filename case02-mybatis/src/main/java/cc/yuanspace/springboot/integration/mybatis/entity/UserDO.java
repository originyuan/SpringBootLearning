package cc.yuanspace.springboot.integration.mybatis.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDO {
    private Long userId;

    private Integer gender;

    private LocalDateTime createTime;
}
