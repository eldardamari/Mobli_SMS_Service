package main.java.com.mobli.interview.broker;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import main.java.com.mobli.interview.consumer.SmsConsumer;
import main.java.com.mobli.interview.data.SmsMessage;

public class MessageBrokerImpl implements MessageBroker {
    
	private Map<String, SmsConsumer> subscribers;
    
    private MessageBrokerImpl() {
        this.subscribers = new ConcurrentHashMap<String,SmsConsumer>();
    }

    /**
     * Singleton class helper only executed when the static method getInstance is invoked
     */
    private static class SingletonHelper{
        private static final MessageBrokerImpl INSTANCE = new MessageBrokerImpl();
    }
     
    public static MessageBrokerImpl getInstance(){
        return SingletonHelper.INSTANCE;
    }

	
    /**
     * Add message subscriber to listen and receive all the SMS messages sent to the broker.
     * @param consumer The consumer that handles the received message.
     */
	@Override
    public void addSubscriber(SmsConsumer consumer) {
			this.subscribers.put(getClassName(consumer),consumer);
    }

    /**
     * Remove the subscriber from listening and receiving SMS messages.
     * @param consumer
     */
    @Override
    public void removeSubscriber(SmsConsumer consumer) {
			this.subscribers.remove(getClassName(consumer),consumer);
    }

    /**
     * Receive new message from message producer and publish it to all the subscribers.
     * @param message
     */
    @Override
    public void receive(SmsMessage message) {
    	for (Map.Entry<String,SmsConsumer> entry : this.subscribers.entrySet())
    		entry.getValue().consume(message);
    }

    /**
     * Shutdown broker and cleanup all resources.
     */
    @Override
    public void shutdown() {
        this.subscribers = null;
    }
    
    /**
     * Return class name, used to save as key in subscribers HashMap 
     * @param c
     */
    private String getClassName(SmsConsumer c) {
    	return c.getClass().getSimpleName();
    }
}
