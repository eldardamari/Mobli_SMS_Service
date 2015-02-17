package main.java.com.mobli.interview.consumer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import main.java.com.mobli.interview.data.SmsMessage;

public class WordCountServiceImpl implements WordCountService {

	private Map<String, Integer> totalWords;
	
	public WordCountServiceImpl() {
		this.totalWords = new ConcurrentHashMap<String, Integer>();
	}
	
	
	/**
     * Return total words map.
     */
    @Override
    public Map<String, Integer> getTotalWords() {
        return this.totalWords;
    }
    
    /**
     * Receive new message from broker and save words in totalWords, after lower case.
     * Thread safe due to ConcurrentHashMap totalWords type.
     * @param message
     */
    @Override
    public void consume(SmsMessage message) {
    		
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