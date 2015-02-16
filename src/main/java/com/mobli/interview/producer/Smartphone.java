package main.java.com.mobli.interview.producer;

import java.util.Date;
import java.util.UUID;

import main.java.com.mobli.interview.broker.MessageBroker;
import main.java.com.mobli.interview.data.SmsMessage;

public class Smartphone {

    SmsProducer smsProducer;
    private static final String SAMPLE_SMS = "The quick brown fox jumps over the lazy dog.";
    private final String id = String.valueOf(UUID.randomUUID());

    public void sendSmsMessages(MessageBroker broker) {
        smsProducer = new SimpleSmsProducer(broker);
        smsProducer.produce(new SmsMessage(id, SAMPLE_SMS, new Date()));
    }
}
