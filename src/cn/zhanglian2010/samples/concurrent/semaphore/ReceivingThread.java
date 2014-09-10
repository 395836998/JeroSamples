package cn.zhanglian2010.samples.concurrent.semaphore;

public class ReceivingThread extends Thread{

	Semaphore semaphore = null;

	public ReceivingThread(Semaphore semaphore){
		this.semaphore = semaphore;
	}

	public void run() {
		while(true){
			try {
				this.semaphore.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//receive signal, then do something...
		}
	}
}
