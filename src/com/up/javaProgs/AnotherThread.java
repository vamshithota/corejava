package com.up.javaProgs;

public class AnotherThread extends Thread{
	@Override
	public void run() {
		System.out.println("From another Thread Class!!!!!  " + currentThread().getName());
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			System.out.println("Another thread woked me up!!!!");
			return;
		}
		
		System.out.println("After threee seconds");
	}
	
}
