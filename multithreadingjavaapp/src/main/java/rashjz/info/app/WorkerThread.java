package rashjz.info.app;

import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.SQLException;

public class WorkerThread
{
    final static Logger logger = Logger.getLogger(WorkerThread.class);
    private  String name;
    private DataSource dataSource;

    public void printLabel() throws SQLException {
        logger.info("Author : " +dataSource.getConnection());
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public  void setName(String name) {
        this.name = name;
    }

}
