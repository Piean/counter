package com.bank.imitation.model;

import com.bank.imitation.model.base.BaseModel;

/**
 * Created by mogu on 2016/8/16.
 */
public class Trade extends BaseModel {
    private String outAccount;
    private String inAccount;
    private int tradeAmount;

    public String getOutAccount() {
        return outAccount;
    }

    public void setOutAccount(String outAccount) {
        this.outAccount = outAccount;
    }

    public String getInAccount() {
        return inAccount;
    }

    public void setInAccount(String inAccount) {
        this.inAccount = inAccount;
    }

    public int getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(int tradeAmount) {
        this.tradeAmount = tradeAmount;
    }
}
