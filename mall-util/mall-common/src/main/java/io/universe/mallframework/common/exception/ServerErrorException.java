package io.universe.mallframework.common.exception;

/**
 * 服务异常
 *
 * @author Sir.D
 */
public class ServerErrorException extends EmmaBusinessException{
    public ServerErrorException(String errorMessage) {
        super(ErrorStatus.SERVER_ERROR, errorMessage);
    }
    public ServerErrorException(Throwable cause) {
        super(ErrorStatus.SERVER_ERROR, cause);
    }
}
