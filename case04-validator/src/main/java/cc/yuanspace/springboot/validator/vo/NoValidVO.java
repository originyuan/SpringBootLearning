package cc.yuanspace.springboot.validator.vo;

import lombok.Data;

import java.util.List;

@Data
public class NoValidVO {
    private String name;
    private Integer num;
    private List<Long> ids;
}
