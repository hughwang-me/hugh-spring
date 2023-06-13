package com.hugh.spring.common;

public class Result<T> {

    private static final long serialVersionUID = 1L;
    private long timestamp = System.currentTimeMillis();
    public String ret = "ok";
    public String msg = "";
    public T dataStore = null;

    public Result() {
    }

    public static <T> Result<T> ok(T dataStore) {
        Result<T> r = new Result<>();
        r.setRet("ok");
        r.setDataStore(dataStore);
        r.setMsg("Success");
        return r;
    }

    public static <T> Result<T> ok() {
        Result<T> r = new Result();
        r.setRet("ok");
        r.setMsg("成功");
        return r;
    }

    public static <T> Result<T> ok(String msg, T data) {
        Result<T> r = new Result();
        r.setRet("ok");
        r.setMsg(msg);
        r.setDataStore(data);
        return r;
    }

    public static <T> Result<T> error(String msg, T data) {
        Result<T> r = new Result();
        r.setRet("error");
        r.setMsg(msg);
        r.setDataStore(data);
        return r;
    }

    public static <T> Result<T> error(String msg) {
        Result<T> r = new Result();
        r.setRet("error");
        r.setMsg(msg);
        return r;
    }

    public static <T> Result<T> error(int code, String msg) {
        Result<T> r = new Result();
        r.setMsg(msg);
        r.setRet("ok");
        return r;
    }

    public Result<T> error500(String message) {
        this.setMsg(message);
        this.setRet("ok");
        return this;
    }

    public String getRet() {
        return this.ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getDataStore() {
        return this.dataStore;
    }

    public void setDataStore(T dataStore) {
        this.dataStore = dataStore;
    }

    public long getTimestamp() {
        return this.timestamp;
    }
}
