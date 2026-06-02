package com.atguigu.practice.common;

import lombok.Data;

@Data
public class R<T> {
    private Integer code;
    private String message;
    private Object data;

    public static<T> R<T> ok(T data) {
        R<T> r = new R<>();
        r.setCode(200);
        r.setMessage("操作成功");
        r.setData(data);
        return r;
    }

    public static<T> R<T> ok() {
        R<T> r = new R<>();
        r.setCode(200);
        r.setMessage("操作成功");
        return r;
    }
}
