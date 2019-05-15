package com.ybing.authentication.enums;

import lombok.Getter;

/**
 * Created by niko on 2019/5/15.
 */
@Getter
public enum YbingUserStatusEnum {

    APPROVING(0, "待审核"),

    APPROVED(1, "审核通过"),

    UNPROVED(-1, "审核未通过"),

    FORBIDDEN(-2, "账号被禁");

    private Integer code;

    private String description;

    YbingUserStatusEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public static YbingUserStatusEnum getUserStatus(Integer code) {
        YbingUserStatusEnum[] statusEnums = YbingUserStatusEnum.values();
        for(YbingUserStatusEnum statusEnum : statusEnums) {
            if(statusEnum.getCode() == code) {
                return statusEnum;
            }
        }
        return null;
    }

}
