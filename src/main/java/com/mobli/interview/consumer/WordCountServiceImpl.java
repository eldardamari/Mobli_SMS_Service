package main.java.com.mobli.interview.consumer;

import java.util.HashMap;
import java.util.Map;

import main.java.com.mobli.interview.data.SmsMessage;

public class WordCountServiceImpl implements WordCountService {

	private Map<String, Integer> totalWords = new HashMap<String, Integer>();
	
    @Override
    public Map<String, Integer> getTotalWords() {
        return this.totalWords;
    }

    @Override
    public synchronized void consume(SmsMessage message) {
    		
    	String splited[] = message.getText().split(" ");
    		
    		for (String word : splited) {
                word = word.toLowerCase();
    			if (this.totalWords.containsKey(word))
    				this.totalWords.put(word,this.totalWords.get(word)+1);
    			else
    				this.totalWords.put(word,1);
    		}
    }
}
