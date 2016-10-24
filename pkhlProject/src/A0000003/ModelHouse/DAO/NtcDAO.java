package A0000003.ModelHouse.DAO;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class NtcDAO {
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

	/* Ntc �Խñ� ī��Ʈ */
	public int ntcListCount(Map<String, Object> paramMap) throws SQLException{
		return (int)sqlMapper.queryForObject("NtcDAO.ntcListCount",paramMap);
	}

	/* Ntc �Խñ� ��ȸ */
	public List<Map<String,Object>> ntcList(Map<String, Object> paramMap) throws SQLException{
		return (List<Map<String, Object>>)sqlMapper.queryForList("NtcDAO.ntcList", paramMap);
	}

	/* Ntc �Խñ� ��� */
	public void ntcInsert(Map<String, Object> paramMap) throws SQLException{
		sqlMapper.insert("NtcDAO.ntcInsert", paramMap);
	}

	/* Ntc �Խñ� �󼼺��� */
	public Map<String, Object> ntcDetail(Map<String, Object> paramMap) throws SQLException{
		sqlMapper.update("NtcDAO.ntcHitUpdate", paramMap);
		return (Map<String, Object>) sqlMapper.queryForObject("NtcDAO.ntcDetail", paramMap);
	}

	/* Ntc �Խñ� ���� */
	public void ntcUpdate(Map<String, Object> paramMap) throws SQLException{
		sqlMapper.insert("NtcDAO.ntcUpdate", paramMap);
	}

	/* Ntc �Խñ� ���� */
	public void ntcDelete(Map<String, Object> paramMap) throws SQLException{
		sqlMapper.update("NtcDAO.ntcDelete", paramMap);
	}
}