package main.java.com.mobli.interview.broker;

import java.util.HashMap;
import java.util.Map;

import main.java.com.mobli.interview.consumer.SmsConsumer;
import main.java.com.mobli.interview.data.SmsMessage;

public class MessageBrokerImpl implements MessageBroker {
    
	private Map<String, SmsConsumer> subscribers = new HashMap<String,SmsConsumer>();
	
	@Override
    public synchronized void addSubscriber(SmsConsumer consumer) {
			this.subscribers.put(getClassName(consumer),consumer);
    }

    @Override
    public synchronized void removeSubscriber(SmsConsumer consumer) {
			this.subscribers.remove(getClassName(consumer),consumer);
    }

    @Override
    public void receive(SmsMessage message) {
    	for (Map.Entry<String,SmsConsumer> entry : this.subscribers.entrySet())
    		entry.getValue().consume(message);
    }

    @Override
    public void shutdown() {

    }
    
    private String getClassName(SmsConsumer c) {
    	return c.getClass().getSimpleName();
    }
}
