package com.ybing.authentication.enums;

/**
 * Created by niko on 2019/5/15.
 */
public enum YbingClientStatusEnum {

    APPROVING(0, "待审核"),

    APPROVED(1, "审核通过"),

    UNPROVED(-1, "审核未通过"),

    FORBIDDEN(-2, "账号被禁");

    private int code;

    private String description;

    YbingClientStatusEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static YbingClientStatusEnum getClientStatus(Integer code) {
        YbingClientStatusEnum[] statusEnums = YbingClientStatusEnum.values();
        for(YbingClientStatusEnum statusEnum : statusEnums) {
            if(statusEnum.getCode() == code) {
                return statusEnum;
            }
        }
        return null;
    }
}
