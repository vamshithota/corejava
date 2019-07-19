package com.up.javaProgs;

public class ThreadEg2 {
public static void main(String[] args) {
	Countdown cdown = new Countdown();
	CountDownThread t1 = new CountDownThread(cdown);
	t1.setName("Thread 1");
	CountDownThread t2 = new CountDownThread(cdown);
	t2.setName("Thread 2");
	t1.start();
	t2.start();
}
}

class Countdown{
	private int i;
public synchronized void doCountdown() {
	String colour;
	switch (Thread.currentThread().getName()) {
	case "Thread 1":
		colour= "Green";
		break;
	case "Thread 2":
		colour= "Red";
		break;
	default:
		colour ="Yellow";
		break;
	}
	synchronized (this) {
		for(i =10 ;i >0 ; i--) {
			System.out.println(Thread.currentThread().getName()+ " : i= " + i);
		}	
	}
	
}
}

class CountDownThread extends Thread{
	private	Countdown threadCountdown;
	public CountDownThread(Countdown countdown) {
	threadCountdown = countdown;
	}
	public void run() {
		threadCountdown.doCountdown();
	}
}
