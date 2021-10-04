package org.common.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 网络异常
 */
@Getter
public enum ExceptionCodeEnum {
    /**
     * 通用结果
     * */
    ERROR(-1,"操作失败"),
    SUCCESS(200,"操作成功"),
    /**
     * 参数校验
     */
    EMPTY_PARAM(1001,"参数为空"),
    ERR0R_PARAM(1000,"参数错误"),
    ERROR_PARAM_LENGTH(1002,"参数长度错误"),


    ;


    private final Integer code;

    private final String message;

    ExceptionCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private static final Map<Integer,ExceptionCodeEnum> ENUM_CACHE= new HashMap<>();

    static{
      for(ExceptionCodeEnum exceptionCodeEnum : ExceptionCodeEnum.values()){
          ENUM_CACHE.put(exceptionCodeEnum.code,exceptionCodeEnum);
      }
   }

   public static String getMessage(Integer code){
        return Optional.ofNullable(ENUM_CACHE.get(code))
                .map(ExceptionCodeEnum::getMessage)
                .orElseThrow(()->new IllegalArgumentException("invalid exception code!"));

   }

}
