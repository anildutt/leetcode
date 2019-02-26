/**
 * Monitor based solution to alternate between 3 threads
 * to print the sequence :  0 1 0 2 0 3 0 4 0 5 0 6 0 7 0 8 0..
 *
 * @author Anil
 */
public class MonitorCommunicate {
	public static void main(String[] args) {
		Monitor monitor = new Monitor(0); //start with thread-0's turn

		Thread t1 = new Thread(new MyJob(0, 0, monitor));
		Thread t2 = new Thread(new MyJob(1, 1, monitor));
		Thread t3 = new Thread(new MyJob(2, 2, monitor));

		t1.start();
		t2.start();
		t3.start();
	}
}

/**
 * Communicates which thread to run next. 
 * turn/prevTurn together determine this.
 *  
 * @author ayemmanu
 */
class Monitor{
	int turn;		//current turn
	int prevTurn; //last non-zero turn
	public Monitor(int id){	this.turn = id;	}
}

class MyJob implements Runnable{
	Monitor monitor;
	int id;
	int val;
	
	public MyJob(int id, int val, Monitor monitor){
		this.id = id;
		this.val = val;
		this.monitor = monitor;
	}
	
	@Override
	public void run() {
		while(true){
			synchronized(monitor){
				
				while(monitor.turn != this.id) //Wait for my thread turn
					try {	monitor.wait();	} 
					catch (InterruptedException e) {}
				
				System.out.print(val + " ");
				
				if(val != 0) val += 2; //Value to be printed in next turn of this thread.
				
				//Logic to switch between threads - 0 1 0 2 0 1 0 2 ..
				//if cur is 0th thread: Next go to 2 if last visited=1. else go to 1 if last visited=2;
				//else: Next switch to 0'th thread if cur thread = 1 or 2
				if (monitor.turn == 0) { 
					if (monitor.prevTurn == 1)	monitor.turn = 2;
					else					monitor.turn = 1;
				} else { 
					monitor.prevTurn = monitor.turn;
					monitor.turn = 0;
				}
				
				try {	Thread.sleep(10);	} catch (InterruptedException e) {}
				
				monitor.notifyAll(); //Awake everyone
			}
		}
	}
}
