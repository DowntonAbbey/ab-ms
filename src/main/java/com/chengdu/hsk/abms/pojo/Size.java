package com.chengdu.hsk.abms.pojo;

public enum Size{
    SALL("S"),MEDIUM("M"),LARGE("L");

    Size(String s) {
        this.str = s;
    }
    private String str;

    public String getStr(){
        return str;
    }
}
