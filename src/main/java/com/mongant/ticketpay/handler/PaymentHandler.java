package com.mongant.ticketpay.handler;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PaymentHandler {

    public String getIndex() {
        return Long.toHexString(System.currentTimeMillis());
    }

    public Date getSqlDate(String dateStr) {
        Date dtSql = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
            java.util.Date dt = sdf.parse(dateStr);
            dtSql = new Date(dt.getTime());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return dtSql;
    }
}
