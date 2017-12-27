package rashjz.info.app;


import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

    final static Logger logger = Logger.getLogger(MainClass.class);



    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-batch.xml");
        WorkerThread workerThread = (WorkerThread) context.getBean("workerThread");
        workerThread.printLabel();
    }
}
