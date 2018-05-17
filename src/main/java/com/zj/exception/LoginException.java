package com.zj.exception;

public class LoginException extends RuntimeException {

    private int errCode;

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public LoginException(){

    }

    public LoginException(String mes) {
        super(mes);
    }


}
