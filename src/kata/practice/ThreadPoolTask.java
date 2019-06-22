package kata.practice;

import java.io.Serializable;

public class ThreadPoolTask implements Runnable{

	private Object threadPoolTaskData;
	
	  
	ThreadPoolTask(int tasks){   
	this.threadPoolTaskData = tasks+TestThreadPool.latch.getCount();   
	}   
	@Override
	public void run() {
		try {
			TestThreadPool.latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(threadPoolTaskData);
		
	}

}
