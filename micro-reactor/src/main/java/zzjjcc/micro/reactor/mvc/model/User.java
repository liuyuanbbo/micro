package zzjjcc.micro.reactor.mvc.model;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User {
    @Email(message = "邮箱格式错误")
    private String email;

    @NotNull(message = "名字不能为空")
    @Size(min = 2, max = 30, message = "名字长度应在2到30之间")
    private String name;

    @NotNull(message = "年龄不能为空")
    @Min(18)
    private Integer age;

    @NotNull(message = "生日不能为空")
    @Past(message = "生日必须是过去的一个时间")
    private Date birthday;
}
