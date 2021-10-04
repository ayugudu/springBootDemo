package org.common.core;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.common.enums.ExceptionCodeEnum;

import java.io.Serializable;

/**
 * 统一结果返回值
 */
@Data
@NoArgsConstructor
public class Result<T> implements Serializable {

       private Integer code;

       private String message;

       private T  data;

      public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


     public Result(Integer code,String message){
          this.code =code;
          this.message = message;
          this.data =null;
     }
    /**
     * 带数据成功返回
     */
    public static <T> Result<T> success(T t){
        return  new Result<>(ExceptionCodeEnum.SUCCESS.getCode(), ExceptionCodeEnum.SUCCESS.getMessage(),t);
    }

    /**
     * 不带数据成功返回
     */

    public static <T> Result<T> success(){
        return  new Result<>(ExceptionCodeEnum.SUCCESS.getCode(),ExceptionCodeEnum.SUCCESS.getMessage());
    }
    /**
     * 通用错误返回
     */
    public static <T> Result<T> error(ExceptionCodeEnum exceptionCodeEnum){
        return  new Result<>(exceptionCodeEnum.getCode(),exceptionCodeEnum.getMessage());
    }
    /**
     * 通用错误返回，覆盖message
     */
    public static <T> Result<T> error(ExceptionCodeEnum exceptionCodeEnum,String message){
        return  new Result<>(exceptionCodeEnum.getCode(),message);
    }
    /**
     * 通用错误返回，只传入 message
     *
     */
    public static <T> Result<T> error(String message){
        return  new Result<>(ExceptionCodeEnum.ERROR.getCode(), message);
    }

}
