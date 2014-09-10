package cn.zhanglian2010.samples.concurrent.lock;


public class LockCounter {

	private Lock lock = new Lock();
	private int count = 0;

	public int inc() throws InterruptedException{
		lock.lock();
		try{
			return ++count;
		} finally {
			lock.unlock();
		}
	}
}
