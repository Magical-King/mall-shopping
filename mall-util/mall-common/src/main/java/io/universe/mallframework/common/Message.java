package io.universe.mallframework.common;

import lombok.*;

import java.io.Serializable;

/**
 * TO
 *
 * @author Sir.D
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Message<T> implements Serializable {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 数据
     */
    private T data;

    /**
     * 消息
     */
    private String message;

    /**
     * 是否执行成功
     */
    private Boolean success;

    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误消息
     */
    private String errorMessage;

    /**
     * 成功返回
     */
    public static <T> Message<T> success(T t){
        Message<T> message = new Message<>();
        message.code = 200;
        message.success = true;
        message.data = t;
        return message;
    }

    /**
     * 失败返回
     */
    public static <T> Message<T> failure(Integer httpCode, String msg, String innerCode, String errorMessage) {
        Message<T> message = new Message<>();
        message.code = httpCode;
        message.success = false;
        message.message = msg;

        message.errorCode = innerCode;
        message.errorMessage = errorMessage;
        return message;
    }


    public static <T> Message<T> failure(String msg) {
        return failure(500, msg, null, null);
    }

    public static <T> Message<T> failure(Integer httpCode, String msg) {
        return failure(httpCode, msg, null, null);
    }

    public static <T> Message<T> failure(Integer httpCode, String msg, String innerCode) {
        return failure(httpCode, msg, innerCode, null);
    }

}
