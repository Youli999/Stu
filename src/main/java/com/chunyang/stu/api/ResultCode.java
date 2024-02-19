package com.chunyang.stu.api;

public enum ResultCode {
    // 成功
    SUCCESS(200, "操作成功"),

    // 客户端错误
    BAD_REQUEST(400, "请求参数有误"),
    UNAUTHORIZED(401, "权限不足"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "未找到资源"),

    NOT_LOGIN(303, "密码错误"),

    // 服务器错误
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    SERVICE_UNAVAILABLE(503, "服务不可用");

    private final int code; // 状态码
    private final String message; // 提示信息

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
