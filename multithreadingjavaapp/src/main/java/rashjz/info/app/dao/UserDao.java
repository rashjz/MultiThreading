package rashjz.info.app.dao;

import java.sql.Types;
import java.util.Map;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import rashjz.info.app.sp.UserSP;

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

