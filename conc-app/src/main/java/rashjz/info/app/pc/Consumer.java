package rashjz.info.app.pc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

//Consumer Class in Java
class Consumer implements Runnable{

    private final BlockingQueue sharedQueue;

    public Consumer (BlockingQueue sharedQueue ) {
        this.sharedQueue = sharedQueue;
     }

    @Override
    public void run() {
        while(true){
            try {
                 System.out.println("Consumed: "+ sharedQueue.take());
//                 System.out.println("Consumed: "+ sharedQueue.poll());
            } catch (Exception ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


}