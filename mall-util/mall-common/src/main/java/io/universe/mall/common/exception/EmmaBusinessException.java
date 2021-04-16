package io.universe.mall.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 统一异常
 *
 * @author Sir.D
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public abstract class EmmaBusinessException extends RuntimeException {
    static final long serialVersionUID = -7034897190745766931L;
    private final ErrorStatus errorStatus;

    protected EmmaBusinessException(ErrorStatus errorStatus) {
        super(errorStatus.getMessage());
        this.errorStatus = errorStatus;
    }

    protected EmmaBusinessException(ErrorStatus errorStatus, String message) {
        super(message);
        this.errorStatus = errorStatus;
    }

    protected EmmaBusinessException(ErrorStatus errorStatus, Throwable cause) {
        super(cause);
        this.errorStatus = errorStatus;
    }

    protected EmmaBusinessException(ErrorStatus errorStatus, String message, Throwable cause) {
        super(message, cause);
        this.errorStatus = errorStatus;
    }

    public int getHttpCode() {
        return this.errorStatus.httpCode;
    }

    public String getCode() {
        return this.errorStatus.innerCode;
    }

    public String getErrorMessage() {
        return errorStatus.message;
    }

    @Override
    public String getMessage() {
        String message = super.getMessage();
        return message != null && !message.isEmpty() ? message : this.getErrorMessage();
    }

    public ErrorStatus getErrorStatus() {
        return this.errorStatus;
    }

    public enum ErrorStatus {
        /**
         * 统一状态码
         */
        BAD_REQUEST(400, "10000", "参数异常"),
        USER_NOT_LOGIN(401, "10001", "用户未登录"),
        INSUFFICIENT_PERMISSIONS(403, "10003", "权限不足"),
        RESOURCE_NOT_FOUND(404, "10004", "资源不存在"),
        ACTION_ERROR(500, "10005", "执行异常"),
        SERVER_ERROR(500, "10006", "服务器异常"),
        ;

        @Getter
        private final int httpCode;
        @Getter
        private final String innerCode;
        @Getter
        private final String message;

        ErrorStatus(int httpCode, String innerCode, String message) {
            this.httpCode = httpCode;
            this.innerCode = innerCode;
            this.message = message;
        }
    }

}
