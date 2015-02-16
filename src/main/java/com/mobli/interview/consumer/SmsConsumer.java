package main.java.com.mobli.interview.consumer;


import main.java.com.mobli.interview.data.SmsMessage;

public interface SmsConsumer {

    public void consume(final SmsMessage message);
}
