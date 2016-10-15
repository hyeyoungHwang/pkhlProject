package A0000003.ModelHouse.DAO;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class JoinDAO {

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
	   
	 /* Join 회원가입 */
	   public void joinInsert(Map<String, Object> paramMap) throws SQLException{
	      sqlMapper.insert("JoinDAO.joinInsert", paramMap);
	   }
	   
	   public String selectBsnsCode(Map<String, Object> paramMap) throws SQLException{
		   return (String)sqlMapper.queryForObject("JoinDAO.selectBsnsCode",paramMap);
		      //return (String)sqlMapper.queryForList("JoinDAO.selectBsnsCode");
		   }
	
	   
}
