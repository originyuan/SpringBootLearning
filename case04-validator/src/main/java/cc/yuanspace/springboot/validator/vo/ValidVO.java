package cc.yuanspace.springboot.validator.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ValidVO {
    @NotNull
    private String name;
    private Integer num;
    private List<Long> ids;
}
