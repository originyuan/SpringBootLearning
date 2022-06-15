package cc.yuanspace.springboot.validator.vo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class GroupValidVO {

    public interface Group1{}
    public interface Group2{}

    @NotBlank(groups = Group1.class)
    private String name;

    @NotNull(message = "[num]不能为空", groups = Group1.class)
    @Min(value = 10, message = "[num]最小为10", groups = {Group1.class, Group2.class})
    private Integer num;

    @Email(message = "非法的email格式", groups = Group2.class)
    private String email;

    @NotBlank(message = "[nonGroup]不为空")
    private String nonGroup;
}
