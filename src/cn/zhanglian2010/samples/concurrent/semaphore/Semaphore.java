package cn.zhanglian2010.samples.concurrent.semaphore;

public class Semaphore {

	private boolean signal = false;

	public synchronized void take() {
		this.signal = true;
		this.notify();
	}

	public synchronized void release() throws InterruptedException{
		while(!this.signal) {
			wait();
		}
		this.signal = false;
	}
}
