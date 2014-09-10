package cn.zhanglian2010.samples.concurrent.semaphore;

public class SendingThread extends Thread{

	Semaphore semaphore = null;

	public SendingThread(Semaphore semaphore){
		this.semaphore = semaphore;
	}

	public void run(){
		while(true){
			//do something, then signal
			this.semaphore.take();
		}
	}
}
