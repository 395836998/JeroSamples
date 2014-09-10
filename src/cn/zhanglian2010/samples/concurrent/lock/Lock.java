package cn.zhanglian2010.samples.concurrent.lock;

/**
 * 锁的模拟实现（可重入）
 *
 */
public class Lock {
	boolean isLocked = false;
	Thread  lockedBy = null;
	int lockedCount = 0;

	public synchronized void lock() throws InterruptedException{
		Thread callingThread = Thread.currentThread();
		while(isLocked && lockedBy != callingThread){
			wait();
		}
		isLocked = true;
		lockedCount++;
		lockedBy = callingThread;
	}

	public synchronized void unlock(){
		if(Thread.currentThread() == this.lockedBy){
			lockedCount--;
			if(lockedCount == 0){
				isLocked = false;
				notify();
			}
		}
	}

}