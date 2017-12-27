package rashjz.info.app;

import java.sql.Types;
import java.util.Map;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

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

    private class UserSP extends StoredProcedure {
        private static final String SPROC_NAME = "usp_RoleName";

        public UserSP(DataSource datasource) {
            super(datasource, SPROC_NAME);
            declareParameter(new SqlParameter("id", Types.INTEGER));
            declareParameter(new SqlOutParameter("name", Types.VARCHAR));

        }


        public Object execute(int emp_id) {
            Map<String, Object> results = super.execute(emp_id);
            return results.get("name");
        }
    }
}

