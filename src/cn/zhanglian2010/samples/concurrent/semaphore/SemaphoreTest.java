package cn.zhanglian2010.samples.concurrent.semaphore;

public class SemaphoreTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Semaphore semaphore = new Semaphore();
		SendingThread sender = new SendingThread(semaphore);
		ReceivingThread receiver = new ReceivingThread(semaphore);
		receiver.start();
		sender.start();
	}

}
