package com.up.javaProgs;

import java.util.List;
import java.util.Random;

public class ThreadConcurrencyEg {
public static void main(String[] args) {
	
}
}

class MyProducer implements Runnable{
	private	List<String> buffer;
	
	public MyProducer(List<String> buffer) {
		this.buffer = buffer;
	}
	
	public void run() {
	Random random = new Random();
	String[] nums= {"1","2","3","4","5"};
	for(String num: nums) {
		try {
			System.out.println("Adding number" +  num);
			synchronized (buffer) {
				buffer.add(num);
			}
			Thread.sleep(random.nextInt(1000));
		}catch(InterruptedException ex) {
			
		}
	}
		
	}
	
}