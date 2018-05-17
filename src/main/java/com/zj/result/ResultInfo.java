package com.zj.result;

import org.springframework.stereotype.Component;

public class ResultInfo {
    String mes;
    int code;
    public ResultInfo(){

    }
    public ResultInfo(String mes){
        this.mes = mes;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
