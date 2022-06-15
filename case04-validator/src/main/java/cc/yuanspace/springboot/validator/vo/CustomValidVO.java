package cc.yuanspace.springboot.validator.vo;

import cc.yuanspace.springboot.validator.anno.IsABC;
import lombok.Data;

@Data
public class CustomValidVO {

    @IsABC(message = "字段必须为abc")
    private String abc;
}
