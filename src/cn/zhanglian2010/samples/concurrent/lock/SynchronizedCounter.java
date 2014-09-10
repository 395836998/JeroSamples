package cn.zhanglian2010.samples.concurrent.lock;

public class SynchronizedCounter {

	private int count = 0;

	public int inc(){
		synchronized(this){
			return ++count;
		}
	}
}
