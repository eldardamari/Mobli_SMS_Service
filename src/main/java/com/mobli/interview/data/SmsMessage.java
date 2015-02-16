package main.java.com.mobli.interview.data;

import java.util.Date;

public class SmsMessage {

    private final String userId;
    private final String text;
    private final Date date;

    public SmsMessage(String userId, String text, Date date) {
        this.userId = userId;
        this.text = text;
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }
}
