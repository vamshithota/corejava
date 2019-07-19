package com.up.javaProgs;

public class Threads_eg1 {

	public static void main(String args[]) {
		System.out.println( "Hello From main thread");
		
		Thread anotherThread = new AnotherThread();
		anotherThread.setName("---- Another Thread -----");
		anotherThread.start();
	//	anotherThread.run();
		new Thread() {
			public void run() {
				System.out.println("From inner anonymous class");
			}
		}.start();
		
		
		// running anonynmus thread
		Thread myrunnable = new Thread(new MyRunnable(){
			@Override
			public void run() {
			System.out.println("From myrunnable anonymus class implementation");
			try {
				anotherThread.join(2000);
				System.out.println("Another thread terminated or timed out ");
			}catch(InterruptedException ex) {
				System.out.println("Interupted!!!");
			}
			}
		});
		
		myrunnable.start();
		anotherThread.interrupt();
		System.out.println("Hello Its again from main thread");
		
	}
	
}
