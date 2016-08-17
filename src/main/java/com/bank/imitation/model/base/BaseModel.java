package com.bank.imitation.model.base;

/**
 * Created by mogu on 2016/8/15.
 */
public class BaseModel{
//    private static final long serialVersionUID = 553726412419903014L;

    private String id;
    private int opTime;
    private int createTime;
    private int isValid;
    private int lastVer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getOpTime() {
        return opTime;
    }

    public void setOpTime(int opTime) {
        this.opTime = opTime;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public int getIsValid() {
        return isValid;
    }

    public void setIsValid(int isValid) {
        this.isValid = isValid;
    }

    public int getLastVer() {
        return lastVer;
    }

    public void setLastVer(int lastVer) {
        this.lastVer = lastVer;
    }
}
