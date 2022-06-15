package cc.yuanspace.springboot.validator.vo;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 嵌套校验
 */

@Data
public class NestedValidVO {

    @NotBlank(message = "[name]不能为空")
    private String name;

    //对象属性校验
    @Valid
    @NotNull(message = "[subValidVO]对象不能为空")
    private SubValidVO subValidVO;


    @Data
    public static class SubValidVO {
        @NotBlank(message = "子对象[subName]不能为空")
        private String subName;
    }
}
