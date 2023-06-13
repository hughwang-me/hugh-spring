package com.hugh.spring.common;

/**
 * @author: liangxuezhong
 * date:     2023-04-28 09:05
 * desc:     返回值状态码枚举
 */
public enum ResultCode {
    /* 成功状态码 */
    SUCCESS(0, "成功"),

    /* 参数错误: 1001-1999 */
    PARAM_IS_BLANK(1001, "参数为空"),
    PARAM_IS_INVALID(1002, "参数无效"),
    PARAM_NOT_COMPLETE(1003, "参数不全"),

    /* 权限错误: 2001-2999 */
    PERMISSION_NO_ACCESS(2001, "无访问权限"),

    /* 操作失败: 3001-3999 */
    INSERT_FAILURE(3001, "插入数据失败"),
    DELETE_FAILURE(3002, "删除数据失败"),

    /* 系统异常: 9001-9999 */
    SYSTEM_EXCEPTION(9001, "系统异常"),

    /* 项目自定义异常 */
    PROJECT_EXCEPTION(10000 , "项目自定义异常"),
    JINGQING_EXCEPTION(10001 , "警情处理异常")

    ;

    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 获取返回值状态码
     *
     * @return 返回值状态码
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 获取返回值状态名称
     *
     * @return 返回值状态名称
     */
    public String getMessage() {
        return message;
    }
}
