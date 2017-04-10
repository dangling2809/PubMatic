import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.locks.ReentrantLock;


public class DeadLockExample {

	ReentrantLock lock1=new ReentrantLock();
	
	ReentrantLock lock2=new ReentrantLock();
	
	public void methodA() throws InterruptedException
	{
		lock1.lock();
		Thread.sleep(1000);
		lock2.lock();
	}
	
	public void methodB() throws InterruptedException
	{
		lock2.lock();
		Thread.sleep(1000);
		lock1.lock();
	}
	
	public static void main(String[] args) throws InterruptedException {
		final DeadLockExample dead=new DeadLockExample();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					dead.methodA();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();;
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					dead.methodB();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();;
		
		Thread.sleep(1000);
		ThreadMXBean bean=ManagementFactory.getThreadMXBean();
		System.out.println(bean.findDeadlockedThreads().length);
		
	}
}
