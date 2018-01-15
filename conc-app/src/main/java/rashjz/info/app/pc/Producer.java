package rashjz.info.app.pc;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

//Producer Class in java
class Producer implements Runnable {

    private final BlockingQueue sharedQueue;

    public Producer(BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
     }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {

//                Thread.sleep(1500);
                System.out.println("Produced: " + i);
                sharedQueue.put(i);
//                sharedQueue.offer(i);
            } catch (Exception ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}