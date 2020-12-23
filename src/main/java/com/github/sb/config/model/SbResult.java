package com.github.sb.config.model;

import lombok.Data;
import lombok.ToString;

/**
 * SB响应
 * @param <T> 返回参数
 */
@Data
@ToString
public class SbResult<T> {

    private boolean success;

    private String code;

    private String msg;

    private T data;

    /* ----------------------------------- 成功结果 ------------------------------------------------------*/

    public static <T> SbResult<T> success() {
        return new SbResult<>(true, SUCCESS_200, null, null);
    }

    public static <T> SbResult<T> success(T data) {
        return new SbResult<>(true, SUCCESS_200, null, data);
    }

    public static <T> SbResult<T> success(String msg) {
        return new SbResult<>(true, SUCCESS_200, msg, null);
    }

    public static <T> SbResult<T> success(String msg, T data) {
        return new SbResult<>(true, SUCCESS_200, msg, data);
    }

    /* ----------------------------------- 失败结果 ------------------------------------------------------*/

    public static <T> SbResult<T> fail(String code) {
        return new SbResult<>(false, code, null, null);
    }

    public static <T> SbResult<T> fail(String code, String msg) {
        return new SbResult<>(false, code, msg, null);
    }

    public static <T> SbResult<T> fail(String code, String msg, T data) {
        return new SbResult<>(false, code, msg, data);
    }


    /* ----------------------------------- 构造函数 ******************************************************/

    private SbResult(boolean success, String code, String msg, T data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /* ------------------------------------ 定义响应码 -------------------------------------------------*/

    /**
     * 成功
     */
    public static final String SUCCESS_200 = "200";

    /**
     * 未登录
     */
    public static final String FAIL_NO_LOGIN = "40000";

    /**
     * 无权限
     */
    public static final String FAIL_NO_PERMISSION = "40001";

    /**
     * 非法的参数
     */
    public static final String FAIL_ERROR_PARAM = "40002";

    /**
     * 业务执行异常
     */
    public static final String FAIL_BIZ_ERROR = "20001";

    /**
     * 外部调用失败
     */
    public static final String FAIL_CALL_ERROR = "200002";

    /**
     * 服务器内部错误
     */
    public static final String FAIL_SERVER_ERROR = "500";

}
