package cn.zhanglian2010.samples.concurrent.semaphore;

public class BoundedSemaphoreAsLockTest {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		BoundedSemaphore semaphore = new BoundedSemaphore(1);
		//...
		semaphore.take();
		try{
			//critical section
		} finally {
			semaphore.release();
		}
	}

}
