package com.bank.imitation.query;

import com.bank.imitation.query.base.BaseQuery;

/**
 * Created by mogu on 2016/8/18.
 */
public class CounterQuery extends BaseQuery {
    private String userName;
    private String phone;
    private String idCard;
    private String name;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
