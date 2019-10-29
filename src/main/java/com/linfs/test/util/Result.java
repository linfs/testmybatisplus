package com.linfs.test.util;

import lombok.Data;

/**
 * 返回结果类
 *
 * @author linfs
 * @create 2019-10-29-12:49
 */
@Data
public class Result {

    private boolean flag;

    private Integer code;

    private String message;

    private Object data;

    public Result() {
    }

    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public Result(boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
