package com.dpi.server.enums;

/**
 * @Package com.dpi.server.enums
 * @ClassName CommonEnum
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/24
 */
public enum CommonEnum {
    MEDIA_TYPE_APPLICATION_JSON("Content-Type", "application/json;charset=UTF-8");

    private String name;
    private String value;

    CommonEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
