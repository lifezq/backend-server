package com.dpi.server.enums;

/**
 * @Package com.dpi.server.enums
 * @ClassName ErrorCodeEnum
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/23
 */
public enum ErrorCodeEnum {
    ERROR_CODE_FORBIDDEN(403, "没有权限");

    private Integer code;
    private String desc;

    ErrorCodeEnum(Integer name, String desc) {
        this.code = name;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
