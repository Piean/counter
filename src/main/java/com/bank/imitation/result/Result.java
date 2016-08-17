package com.bank.imitation.result;

import java.io.Serializable;

/**
 * Created by mogu on 2016/8/16.
 */
public interface Result<T> extends Serializable {

    /**
     * 设置是否结果
     * @param success 成功标志
     */
    void setSuccess(boolean success);

    /**
     * 是否成功
     * @return 如果成功，则返回<code>true</code>
     */
    boolean isSuccess();

    /**
     * 返回相应的错误码
     * @return 返回码
     */
    String getResultCode();

    /**
     * 设置返回码
     * @param code
     */
    void setResultCode(String code);

    /**
     * 取得model对象
     * @return model对象
     */
    T getModel();

    /**
     * 设置model对象
     * @param model model对象
     */
    void setModel(T model);

    /**
     * 返回信息
     * @return
     */
    String getMessage();

    /**
     * 设置错误信息
     * @param message
     */
    void setMessage(String message);
}
