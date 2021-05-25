package com.hk.pojo;

import lombok.Data;

import java.util.List;

@Data
public class UserQueryVo  {

    UserCustom userCustom;

    List<Integer> ids;

}
