package io.universe.mall.common.exception;

/**
 * 请求异常
 *
 * @author Sir.D
 */
public class BadRequestErrorException extends EmmaBusinessException{
    public BadRequestErrorException(String errorMessage) {
        super(ErrorStatus.BAD_REQUEST, errorMessage);
    }
    public BadRequestErrorException(Throwable cause) {
        super(ErrorStatus.BAD_REQUEST, cause);
    }
}
