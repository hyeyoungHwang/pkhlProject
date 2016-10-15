package A0000001.Archidom.DAO;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class AdminDAO {
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
	   
	   public Map<String, Object> adminLogin(Map<String, Object> paramMap) throws SQLException{
	      return (Map<String, Object>) sqlMapper.queryForObject("AdminDAO.adminLogin", paramMap);
	   }
	   
	   public List<Map<String,Object>> adminImageList() throws SQLException{
	      return (List<Map<String, Object>>)sqlMapper.queryForList("AdminDAO.adminImageList");
	   }
	   
	   public void adminImageInsert(Map<String, Object> paramMap) throws SQLException{
	      sqlMapper.insert("AdminDAO.adminImageInsert", paramMap);
	   }
	   
	   public void adminImageDelete(Map<String, Object> paramMap) throws SQLException{
	      sqlMapper.delete("AdminDAO.adminImageDelete", paramMap);
	   }
}
