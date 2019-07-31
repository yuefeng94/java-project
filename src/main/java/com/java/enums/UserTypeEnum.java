package com.java.enums;

public enum  UserTypeEnum {

    /**
     * UserTypeEnum  ROOT_ADMIN => ROOT_ADMIN.getName()...
     * UserTypeEnum  ADMIN => ADMIN.getName()...
     * UserTypeEnum  USER => USER.getName()...
     * UserTypeEnum valueOf(String enum) // 字符串转枚举
     * UserTypeEnum[] values()
     */
    ROOT_ADMIN("1", "超级管理员", "最高权限"),
    ADMIN("2", "管理员", "相关权限"),
    USER("3", "普通用户", "普通权限");
    private String name;
    private String code;
    private String desc;
    UserTypeEnum(String code, String name, String desc){
        this.code = code;
        this.name = name;
        this.desc = desc;
    }
    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}

class Demo {
    public static void main(String[] args) {
        UserTypeEnum[] values = UserTypeEnum.values();
        for (UserTypeEnum value : values) {
            System.out.println(value.getName() + " --- " + value.getCode() + " --- " + value.getDesc());
        }
    }
}
