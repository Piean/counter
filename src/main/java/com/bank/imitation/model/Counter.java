package com.bank.imitation.model;

import com.bank.imitation.model.base.BaseModel;

/**
 * Created by mogu on 2016/8/15.
 */
public class Counter extends BaseModel{

    private String userName;
    private String userPass;
    private String name;
    private int sex = 0;
    private String idCard;
    private String phone;
    private int lastLoginTime;
    private int lastLeaveTime;
    private int level = -1;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(int lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public int getLastLeaveTime() {
        return lastLeaveTime;
    }

    public void setLastLeaveTime(int lastLeaveTime) {
        this.lastLeaveTime = lastLeaveTime;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
