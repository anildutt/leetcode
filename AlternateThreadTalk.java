import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Print this from 3 threads taking turns: 0 1 2 0 3 4 0 5 6 0 7 8 0 9..
 * @author ayemmanu
 *
 */
public class AlternateThreadTalk {
	public static void main(String[] args) {
		MyWorker w1 = new MyWorker(1);
		MyWorker w2 = new MyWorker(2);
		MyWorker w3 = new MyWorker(3);
		
		w1.setVal(0);
		w2.setVal(1);
		w3.setVal(2);
		
		w1.setNext(w2);
		w2.setNext(w3);
		w3.setNext(w1);
		
		
		w1.start();w2.start();w3.start();
		w1.accept(0);
	}	
}

/**
 * Worker class communicates to "next" Worker, by putting a 
 * dummy element into it's BlockingQueue. 
 * Worker, when receives an element into BlockingQueue prints 
 * appropriate number and repeats above.
 * 
 * @author ayemmanu
 */
class MyWorker extends Thread{
	
	private BlockingQueue<Integer> Q = new ArrayBlockingQueue<Integer>(1);
	private MyWorker next = null;
	private int val;
	
	public MyWorker(int val){	this.val = val;	}
	public void setNext(MyWorker n){	next = n;	}
	public void setVal(int val){	this.val = val;	};
	public void accept(int i){	Q.add(i);	}
	
	@Override
	public void run() {
		while(true){
			try {
				Q.take(); //Wait for signal to take my turn
				
				System.out.print(val + " ");
				Thread.sleep(100);
				if(val != 0)
					val += 2;
				
				next.accept(0);	//Signal next worker to take-over
			} catch (InterruptedException e) {
			}
		}
	}
	
}
