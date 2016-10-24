package A0000003.ModelHouse.DAO;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class UserDAO {
	
	private static SqlMapClient sqlMapper;
	
	static{
		try{
			Reader reader = Resources.getResourceAsReader("sqlMapConfig.xml");
			sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		}catch(IOException e){
			throw new RuntimeException(e);
		}   
	}
	

	/* User Login */
	public Map<String, Object> userLogin(Map<String, Object> paramMap) throws SQLException{
		return (Map<String, Object>) sqlMapper.queryForObject("UserDAO.userLogin", paramMap);
	}
}