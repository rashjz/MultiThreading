package rashjz.info.app;

import org.apache.log4j.Logger;

public class WorkerThread
{
    final static Logger logger = Logger.getLogger(WorkerThread.class);
    private  String name;

    public void printLabel() {
        logger.info("Author : " + name);
    }

    public  void setName(String name) {
        this.name = name;
    }

}
