DELIMITER //

CREATE PROCEDURE usp_RoleName(IN id INT, OUT name VARCHAR(20))
  BEGIN
    SELECT app_role
    INTO name
    FROM role
    WHERE role_id = id;
  END;
//
DELIMITER ;
