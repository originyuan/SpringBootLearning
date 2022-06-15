package cc.yuanspace.springboot.validator.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class ValidVO {

    // 默认为0，一定通过
    @NotNull(message = "基本类型不能为null")
    // 指定正数，0不是正数
    @Positive(message = "基本数值必须为正数")
    private int a;

    // 一定不通过，默认为0
    // @Null(message = "基本数值类型必须为null")
    private int notnullInt;

    @NotNull(message = "不能为null")
    @NotBlank(message = "字符串不能为空")
    private String name;

    @AssertTrue(message = "字段[boolTrue]必须为true")
    private Boolean boolTrue;
    @AssertFalse(message = "字段[boolFalse]必须为false")
    private Boolean boolFalse;

    @Pattern(regexp = "[1-8]{1,5}")
    private String pattern;

    @Email(message = "email格式")
    private String email;

    @Min(value = 10)
    private Integer min;

    @Min(value = 10)
    private Float minf;

    @Min(value = 10)
    private Double mind;

    @Max(value = 10, message = "最大值为10")
    @Max(value = 8, message = "最大值为8")
    private Integer max;

    @DecimalMin(value = "2.5", inclusive = true)
    private BigDecimal decimalMinDouble;

    @DecimalMax(value = "2.5", inclusive = true)
    private BigDecimal decimalMaxDouble;


    @NotEmpty(message = "列表不能为空")
    @Size(min = 1, max = 3, message = "列表元素只能为1-3个")
    private List<Long> ids;

    @Digits(integer = 4, fraction = 2)
    private Integer num;

    @Digits(integer = 5, fraction = 2)
    private BigDecimal num2;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Past(message = "必须是一个过去的时间")
    private LocalDateTime pastDateTime;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Future
    private LocalDateTime futureTime;

    @Negative(message = "一个负数")
    private Integer negative;

    @Positive(message = "一个正数")
    private Integer positive;

}
