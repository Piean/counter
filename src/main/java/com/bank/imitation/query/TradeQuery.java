package com.bank.imitation.query;

import com.bank.imitation.query.base.BaseQuery;

/**
 * Created by yds on 2016-8-19.
 */
public class TradeQuery extends BaseQuery {

    private String accountId;
    private String idCard;

    private int startDate;
    private int endDate;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endtDate) {
        this.endDate = endtDate;
    }
}
