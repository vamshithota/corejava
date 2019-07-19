package com.up.javaProgs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPoolsEg {

	public static void main(String[] args) {
		 List<String> buffer = new ArrayList<String>();
	     ReentrantLock bufferLock = new ReentrantLock();
	     ExecutorService executorService = Executors.newFixedThreadPool(3);
	     
	     Producer producer = new Producer(buffer, bufferLock);
	     Consumer consumer1 = new Consumer(buffer, bufferLock);
	     Consumer consumer2 = new Consumer(buffer, bufferLock);
	     
	     executorService.execute(producer);
	     executorService.execute(consumer1);
	     executorService.execute(consumer2);
	        
	     Future<String> future = executorService.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
			System.out.println("In callable method");
				return "From callable method";
			}
		});
	    try {
	    	System.out.println(future.get());
	    }catch(InterruptedException ex) {
	    	System.out.println("Something interrupted");
	    }catch(ExecutionException ex) {
	    	System.out.println("Execution exception");
	    }
	    executorService.shutdown();
	}
}

class Producer implements Runnable{
	private List<String> threadBuffer;
	private ReentrantLock bufferLock;
	public Producer(List<String> threadBuffer,ReentrantLock reEntrantlock) {
		this.threadBuffer = threadBuffer;
		this.bufferLock = reEntrantlock;
	}
	@Override
	public void run() {
	 Random random = new Random();
	 String[] nums = {"1","2","3","4","5"};
	 for(String num : nums) {
		 try {
			 System.out.println("Adding number " + num ) ;
			 bufferLock.lock();
			 try {
				 threadBuffer.add(num);
			 }finally {
				 bufferLock.unlock();
			 }
			 Thread.sleep(random.nextInt(1000));
		 }catch(InterruptedException ex) {
			 System.out.println("Interceppted");
		 }
	 }
	  System.out.println("Adding EOF and finishing");
	  bufferLock.lock();
	  try {
		  threadBuffer.add("EOF");
	  }finally {
		bufferLock.unlock();
	}
	}
	
}

class Consumer implements Runnable{

	private List<String> buffer;
	private ReentrantLock bufferLock;
	public Consumer(List<String> buffer,ReentrantLock bufferLock) {
	this.buffer = buffer;
	this.bufferLock = bufferLock;
	}
	@Override
	public void run() {
		int counter = 0;
		while(true) {
			if(bufferLock.tryLock()) {
				try {
					if(buffer.isEmpty()) {
						continue;
					}
					System.out.println("The Counter " + counter);
					counter = 0;
					if(buffer.get(0).equals("EOF")) {
						System.out.println("EOF and exiting");
						break;
					}else {
						System.out.println("Removing" + buffer.remove(0));
					}
				}finally {
					bufferLock.unlock();
				}
			}else {
				counter++;
			}
		}
		
	}
	
}