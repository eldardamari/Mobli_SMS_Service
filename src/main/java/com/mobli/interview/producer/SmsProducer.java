package main.java.com.mobli.interview.producer;

import main.java.com.mobli.interview.data.SmsMessage;

public interface SmsProducer {

    public void produce(final SmsMessage message);
}
