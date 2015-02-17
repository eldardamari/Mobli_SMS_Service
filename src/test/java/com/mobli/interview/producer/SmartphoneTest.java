package test.java.com.mobli.interview.producer;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import main.java.com.mobli.interview.broker.MessageBroker;
import main.java.com.mobli.interview.broker.MessageBrokerImpl;
import main.java.com.mobli.interview.consumer.PrintService;
import main.java.com.mobli.interview.consumer.WordCountService;
import main.java.com.mobli.interview.consumer.WordCountServiceImpl;
import main.java.com.mobli.interview.producer.Smartphone;

public class SmartphoneTest {

    @Test
    public void testSendSmsMessages() throws Exception {
    	
        final int numberOfMessagesPerSmartphone = 50;
        MessageBroker broker = MessageBrokerImpl.getInstance();

        PrintService printService = new PrintService();
        WordCountService wordCountService = new WordCountServiceImpl();

        broker.addSubscriber(printService);
        broker.addSubscriber(wordCountService);

        Smartphone phoneOne = new Smartphone();
        Smartphone phoneTwo = new Smartphone();
        Smartphone phoneThree = new Smartphone();

        for (int i = 0; i < numberOfMessagesPerSmartphone; i++) {
            phoneOne.sendSmsMessages(broker);
            phoneTwo.sendSmsMessages(broker);
            phoneThree.sendSmsMessages(broker);
        }

        Thread.sleep(1000);

        Map<String, Integer> totalWords = wordCountService.getTotalWords();
        Assert.assertEquals((numberOfMessagesPerSmartphone * 3 * 2), ifNullToZero(totalWords.get("the")));
        Assert.assertEquals((numberOfMessagesPerSmartphone * 3), ifNullToZero(totalWords.get("quick")));
        Assert.assertEquals((numberOfMessagesPerSmartphone * 3), ifNullToZero(totalWords.get("brown")));
        Assert.assertEquals((numberOfMessagesPerSmartphone * 3), ifNullToZero(totalWords.get("fox")));
        
        Assert.assertEquals(0, ifNullToZero(totalWords.get("unSeen1")));
        Assert.assertEquals(0, ifNullToZero(totalWords.get("")));
        Assert.assertEquals(0, ifNullToZero(totalWords.get(null)));
    }
    
    private int ifNullToZero(Integer num) {
    	return num == null ? 0 : num;
    }
}
