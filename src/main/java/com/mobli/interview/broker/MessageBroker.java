package main.java.com.mobli.interview.broker;

import main.java.com.mobli.interview.consumer.SmsConsumer;
import main.java.com.mobli.interview.data.SmsMessage;


public interface MessageBroker {

    /**
     * Add message subscriber to listen and receive all the SMS messages sent to the broker.
     * @param consumer The consumer that handles the received message.
     */
    public void addSubscriber(SmsConsumer consumer);

    /**
     * Remove the subscriber from listening and receiving SMS messages.
     * @param consumer
     */
    public void removeSubscriber(SmsConsumer consumer);

    /**
     * Receive new message from message producer and publish it to all the subscribers.
     * @param message
     */
    public void receive(final SmsMessage message);

    /**
     * Shutdown broker and cleanup all resources.
     */
    public void shutdown();
}
