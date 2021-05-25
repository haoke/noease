package com.hk.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(callSuper = true)
public class OrderCustom extends  Orders {


    private Integer user_id;
    private Integer userid;
    private String username;
    private String password;
    private String birthday;
}
