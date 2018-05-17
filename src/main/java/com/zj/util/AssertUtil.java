package com.zj.util;

import com.zj.exception.ParameterException;

public class AssertUtil {

    public static void isNull(Object value){
        if(value == null){
            throw new ParameterException("不能空");
        }
    }
}
