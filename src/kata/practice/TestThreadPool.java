package kata.practice;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPool {
	//private static int produceTaskSleepTime = 2;   
	public static CountDownLatch latch=new CountDownLatch(15);
	public static void main(String[] args) {   
	  
	//构造一个线程池   
//	ThreadPoolExecutor threadPool = 
//	new ThreadPoolExecutor(10,12,20,TimeUnit.SECONDS, new ArrayBlockingQueue(3),new ThreadPoolExecutor.CallerRunsPolicy());   
	 ExecutorService threadPool = Executors.newFixedThreadPool(10);
	for(int i=1;i<=15;i++){   
			try {   
				int task=0;
				task+=1;
				latch.countDown();
//				if(threadPool.isTerminated()) {
//					System.out.println("end");
//					threadPool.shutdown();
//				}
			threadPool.execute(new ThreadPoolTask(task));   
			} catch (Exception e) {   
			e.printStackTrace();   
			}   
		}   
	}   

}
