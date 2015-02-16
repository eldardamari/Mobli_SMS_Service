package main.java.com.mobli.interview.broker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import main.java.com.mobli.interview.consumer.SmsConsumer;
import main.java.com.mobli.interview.data.SmsMessage;

public class MessageBrokerImpl implements MessageBroker {
    
	public Map<String, SmsConsumer> subscribers = new HashMap<String,SmsConsumer>();
	
	@Override
    public void addSubscriber(SmsConsumer consumer) {
			this.subscribers.put(getClassName(consumer),consumer);
    }

    @Override
    public void removeSubscriber(SmsConsumer consumer) {

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
