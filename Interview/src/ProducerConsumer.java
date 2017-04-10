import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class ProducerConsumer {

	
	class Producer extends Thread{
		
		private final int MAX_ITEMS=5;
		
		private ReentrantLock lock;
		
		private Condition notFull;
		
		private Condition notEmpty;

		private Queue<Integer> items;

		public Producer(ReentrantLock lock, Condition notFull,
				Condition notEmpty, Queue<Integer> items) {
			super();
			this.lock = lock;
			this.notFull = notFull;
			this.notEmpty = notEmpty;
			this.items = items;
		}

		@Override
		public void run() {
			
			// TODO Auto-generated method stub
			for(;;)
			{
				try{
					lock.lock();
					while(MAX_ITEMS==items.size())
					{
						try {
							notEmpty.await();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					notFull.signal();
				}finally{
					lock.unlock();
				}
			}
		}
	}
}
