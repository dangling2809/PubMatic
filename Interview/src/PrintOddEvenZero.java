import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintOddEvenZero {
    public static void main(String[] args) throws InterruptedException {
        Printer p = new Printer();
        Thread oddThread = new Thread(new PrintThread(p,false),"Odd  :");
        Thread evenThread = new Thread(new PrintThread(p,true),"Even :");
        oddThread.start();
        evenThread.start();
    }
}

class PrintThread implements Runnable{
    Printer p;
    boolean isEven = false;

    PrintThread(Printer p, boolean isEven){
        this.p = p;
        this.isEven = isEven;
    }

    @Override
    public void run() {
        int i = (isEven==true) ? 2 : 1;
        while(i < 10 ){
            if(isEven){
                p.printEven(i);
            }else{
                p.printOdd(i);
            }
            i=i+2;
        }
    }
}

class Printer{

    boolean isEven = true;
    Lock lock = new ReentrantLock();
    Condition condEven = lock.newCondition();
    Condition condOdd = lock.newCondition();

    public void printEven(int no){
        lock.lock();
        while(isEven==true){
            try {
                condEven.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() +no);
        System.out.println("ZeroEven:"+ 0);
        isEven = true;
        condOdd.signalAll();
        lock.unlock();
    }

    public void printOdd(int no){
        lock.lock();
        while(isEven==false){
            try {
                condOdd.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() +no);
        System.out.println("ZeroOdd:"+ 0);
        isEven = false;
        condEven.signalAll();
        lock.unlock();
    }
}