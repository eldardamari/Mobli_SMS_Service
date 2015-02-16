package main.java.com.mobli.interview.broker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import main.java.com.mobli.interview.consumer.SmsConsumer;
import main.java.com.mobli.interview.data.SmsMessage;

public class MessageBrokerImpl implements MessageBroker {
    
	private Map<String, SmsConsumer> subscribers = new HashMap<String,SmsConsumer>();
	
	@Override
    public void synchronized addSubscriber(SmsConsumer consumer) {
			this.subscribers.put(getClassName(consumer),consumer);
    }

    @Override
    public void synchronized removeSubscriber(SmsConsumer consumer) {
			this.subscribers.remove(getClassName(consumer),consumer);
    }

    @Override
    public void receive(SmsMessage message) {

    }

    @Override
    public void shutdown() {

    }
    
    private String getClassName(SmsConsumer c) {
    	return c.getClass().getSimpleName();
    }
}
