package main.java.com.mobli.interview.producer;

import main.java.com.mobli.interview.broker.MessageBroker;
import main.java.com.mobli.interview.data.SmsMessage;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class SimpleSmsProducer implements SmsProducer {
	
	private static Logger logger = Logger.getLogger(SimpleSmsProducer.class.getName());
	static { logger.setLevel(Level.INFO);}
    
	private MessageBroker broker;

    public SimpleSmsProducer(MessageBroker broker) {
        this.broker = broker;
    }

    @Override
    public void produce(final SmsMessage message) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
            	logger.info("Sending Message: " + message.getText());
                broker.receive(message);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
