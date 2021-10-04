package com.example.admin.controller;

import org.bean.dto.User;
import org.common.annotation.CosmoController;
import org.common.enums.ExceptionCodeEnum;
import org.common.exception.BizException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CosmoController
public class Test {

    @PostMapping("/test")
    public int insertId(@RequestBody User user){
        if(user.getId()>18){
            throw new BizException(ExceptionCodeEnum.ERROR_PARAM_LENGTH);
        }
        return user.getId();
    }

}
