package rashjz.info.app.dao.sp;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.Map;

public class UserSP extends StoredProcedure {
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