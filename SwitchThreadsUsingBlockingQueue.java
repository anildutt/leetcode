package leetcode;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Alternate between 3 threads to print sequence of numbers.
 * 
 * Each worker maintains a BlockingQueue of size=1.
 * Each worker communicates to next Worker by putting an element into its BlockingQueue.
 * "next" is defined cyclically to take turns infinitely.
 * 
 * @author ayemmanu
 */
public class SwitchThreadsUsingBlockingQueue {
    public static void main(String[] args) {
        // Create the workers
        Worker w1 = new Worker();
        Worker w2 = new Worker();
        Worker w3 = new Worker();
        
        // chain them in a round robin fashion
        w1.setNext(w2);
        w2.setNext(w3);
        w3.setNext(w1);
        
        // Create named threads for the workers
        Thread t1 = new Thread(w1, "Thread-1 - ");
        Thread t2 = new Thread(w2, "Thread-2 - ");
        Thread t3 = new Thread(w3, "Thread-3 - ");
        
        // start the threads
        t1.start();
        t2.start();
        t3.start();
        
        // Seed the first worker
        w1.accept(1);
    }
}

class Worker implements Runnable{
    
    BlockingQueue<Integer> q = new LinkedBlockingQueue<Integer>(); 
    Worker next = null; // next worker in the chain
 
    public void setNext(Worker t) {
        this.next = t;
    }
    
    public void accept(int i) {
        q.add(i);
    }
    
    @Override
    public void run() {
        while (true){
            try {
                int i = q.take(); // blocks till it receives a number
                
                System.out.println( Thread.currentThread().getName() +  i);
                
                Thread.sleep(1000); // delay to slow the printing
                if (next != null){
                    next.accept(i+1); // pass the next number to the next worker 
                }
 
            } catch (InterruptedException e) {
                System.err.println( Thread.currentThread().getName() + " interrrupted.");
            }
        }
    }
}
