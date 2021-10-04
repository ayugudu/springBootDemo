package org.common.configure;



import lombok.extern.slf4j.Slf4j;
import org.common.core.Result;
import org.common.enums.ExceptionCodeEnum;
import org.common.exception.BizException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 业务异常
     */
    @ExceptionHandler(BizException.class)
    public Result<ExceptionCodeEnum> handleBizException(BizException bizException){
        log.error("业务异常：{}",bizException.getMessage(),bizException);
        return Result.error(bizException.getError());
    }

    /**
     * 运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public Result<ExceptionCodeEnum> handleRunTimeException(RuntimeException e){
        log.error("运行时异常:{}",e.getMessage(),e);
       return  Result.error(ExceptionCodeEnum.ERROR);
    }



}
