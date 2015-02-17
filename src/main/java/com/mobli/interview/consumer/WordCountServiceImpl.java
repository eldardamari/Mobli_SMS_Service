package main.java.com.mobli.interview.consumer;

import java.util.HashMap;
import java.util.Map;

import main.java.com.mobli.interview.data.SmsMessage;
import main.java.com.mobli.interview.exception.MessageTransferException;

public class WordCountServiceImpl implements WordCountService {

	private Map<String, Integer> totalWords;
	
	public WordCountServiceImpl() throws MessageTransferException {
		this.totalWords = new HashMap<String, Integer>();
		if (this.totalWords == null)
    		throw new MessageTransferException("Error - Word counter memory allocation failed");
	}
	
	
	/**
     * Return total words map.
     */
    @Override
    public Map<String, Integer> getTotalWords() {
        return this.totalWords;
    }
    
    
    /**
     * Receive new message from broker and save words in totalWords, after word lower case.
     * Thread safe due to ConcurrentHashMap totalWords type.
     * @param message
     */
    @Override
    public synchronized void consume(SmsMessage message){
    		
    	String splited[] = message.getText().split(" ");
    		
    		for (String word : splited) {
                word = word.toLowerCase();
    			if (this.totalWords.containsKey(word))
    				this.totalWords.put(word,this.totalWords.get(word) + 1);
    			else
    				this.totalWords.put(word,1);
    		}
    }
}