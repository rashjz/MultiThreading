package rashjz.info.app;


import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import rashjz.info.app.dao.UserDao;
import rashjz.info.app.workers.TaskServiceImpl;
import rashjz.info.app.workers.WorkerThread;


public class MainClass {

    final static Logger logger = Logger.getLogger(MainClass.class);


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        WorkerThread workerThread = (WorkerThread) context.getBean("workerThread");
        UserDao userDao = (UserDao) context.getBean("userDao");
//        TaskServiceImpl taskService = (TaskServiceImpl) context.getBean("taskServiceImpl");
        try {
            workerThread.printLabel();
//            taskService.test();
            logger.info("checking stored procedure ");
            String roleName = userDao.getRoleName(1);
            logger.info("role name is " + roleName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
