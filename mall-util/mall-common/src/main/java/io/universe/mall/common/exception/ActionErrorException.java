package io.universe.mall.common.exception;

/**
 * 执行异常
 *
 * @author Sir.D
 */
public class ActionErrorException extends EmmaBusinessException{
    public ActionErrorException(String errorMessage) {
        super(ErrorStatus.ACTION_ERROR, errorMessage);
    }
    public ActionErrorException(Throwable cause) {
        super(ErrorStatus.ACTION_ERROR, cause);
    }
}
