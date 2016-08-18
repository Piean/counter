package com.bank.imitation.result;

/**
 * Created by mogu on 2016/8/16.
 */
public class ResultSupport<T> implements Result<T> {

    private static final long serialVersionUID = 4661096805690919752L;

    private boolean success = true;
    private String resultCode;
    private String message;
    private T model;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getModel() {
        return model;
    }

    /**
     * 创建一个result。
     */
    public ResultSupport() {
    }

    /**
     * 创建一个result
     *
     * @param success 是否成功
     */
    public ResultSupport(boolean success) {
        this.success = success;
    }

    public ResultSupport(boolean success,String resultCode,String message){
        this.success = success;
        this.resultCode = resultCode;
        this.message = message;
    }

    public ResultSupport(String resultCode,String message){
        this.success = Boolean.FALSE;
        this.resultCode = resultCode;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public void setModel(T model) {
        this.model= model;
    }
}
