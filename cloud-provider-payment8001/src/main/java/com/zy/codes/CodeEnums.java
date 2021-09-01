package com.zy.codes;

/**
 * @Author: zhengyi
 * @Date: 2021/8/31 15:08
 */
public enum CodeEnums {

    SUCCESS(200, null);

    private Integer code;
    private String message;

    CodeEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
