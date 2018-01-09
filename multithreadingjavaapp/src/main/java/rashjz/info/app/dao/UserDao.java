package rashjz.info.app.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import rashjz.info.app.dao.sp.UserSP;

public class UserDao {
    private JdbcTemplate jdbcTemplate;
    private UserSP sproc;

    public void setDataSource(DataSource source) {
        this.jdbcTemplate = new JdbcTemplate(source);
        this.sproc = new UserSP(jdbcTemplate.getDataSource());
    }

    public String getRoleName(int emp_id) {
        return (String) sproc.execute(emp_id);
    }

}

