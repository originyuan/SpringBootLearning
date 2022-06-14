package cc.yuanspace.springboot.validator.vo;

import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ValidVO {

    @NotNull(message = "不能为null")
    @NotBlank(message = "字符串不能为空")
    private String name;

    private Integer num;
    @NotEmpty(message = "列表不能为空")
    private List<Long> ids;

    private Integer gender;
}
