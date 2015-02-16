package main.java.com.mobli.interview.consumer;

import java.util.Map;

public interface WordCountService extends SmsConsumer {

    public Map<String, Integer> getTotalWords();
}
