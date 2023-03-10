package com.eccom.starter.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long userId;
    private String username;
    @JsonIgnore
    private String password;
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    @Min(value = 18, message = "未成年人禁止入内")
    private Integer age;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String desc;

}
