package org.common.exception;

import lombok.Getter;
import org.common.enums.ExceptionCodeEnum;

/**
 * 业务异常
 */
@Getter
public class BizException extends RuntimeException{

    private ExceptionCodeEnum error;

    /**
     * 传入 之前的异常
     * @param error
     * @param cause
     */
    public  BizException(ExceptionCodeEnum error,Throwable cause){
        super(cause);
        this.error=error;
    }
    public BizException(ExceptionCodeEnum error){
        this.error=error;
    }

}
