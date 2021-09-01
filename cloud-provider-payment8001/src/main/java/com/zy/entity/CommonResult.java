package com.zy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zhengyi
 * @Date: 2021/8/31 14:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
//    200
//    404
//    500
    private Integer code;
    private String message;
    private T data;



}
