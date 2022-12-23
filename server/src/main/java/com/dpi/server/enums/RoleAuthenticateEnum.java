package com.dpi.server.enums;

/**
 * @Package com.dpi.server.enums
 * @ClassName RoleEnum
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/23
 */
public enum RoleAuthenticateEnum {
    ROLE_PREFIX("Role_", "role prefix");

    private String name;
    private String desc;

    RoleAuthenticateEnum(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
