package com.up.javaProgs;
import java.util.Random;
import java.util.concurrent.*;
public class ArrayBlockingQueueEg {
	ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(6);

    ExecutorService executorService = Executors.newFixedThreadPool(5);

    ABProducer producer = new ABProducer(buffer);
    ABConsumer consumer1 = new ABConsumer(buffer);
    ABConsumer consumer2 = new ABConsumer(buffer);

    /*executorService.execute(producer);
    executorService.execute(consumer1);
    executorService.execute(consumer2);*/

	
}

class ABProducer implements Runnable{
	private ArrayBlockingQueue<String> queue;
	public ABProducer(ArrayBlockingQueue<String> queue) {
		this.queue = queue;
	}
	@Override
	public void run() {
	Random random = new Random();
	String[] nums = {"1","2","3","4","5"};
	for(String num: nums) {
		try {
			System.out.println("Adding number " + num);
			queue.put(num);
			Thread.sleep(random.nextInt(1000));	
		}catch(InterruptedException ex) {
			System.out.println("producer was interrupted");
		}
	}
	System.out.println("Adding EOF to queue");
	try {
		queue.put("EOF");
	}catch(InterruptedException ex) {
		
	}
		
	}
}

class ABConsumer implements Runnable{
    private ArrayBlockingQueue<String> queue;
    public ABConsumer(ArrayBlockingQueue<String> queue) {
    	this.queue = queue;
	}
    @Override
	public void run() {
	
    	while(true) {
    		synchronized (queue) {
    			try {
    				if(queue.isEmpty()) {
    					continue;
    				}
    				if(queue.peek().equals("EOF")) {
    					System.out.println("EOF found and exiting now");
    					break;
    				}else {
    					System.out.println("Removing " + queue.take());
    				}	
    			}catch(InterruptedException ex) {
       			}
			}
    	}
	}
	}